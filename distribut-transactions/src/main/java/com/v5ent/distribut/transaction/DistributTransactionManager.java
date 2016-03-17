package com.v5ent.distribut.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.curator.framework.CuratorFramework;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;

import com.v5ent.distribut.entities.TransactionException;
import com.v5ent.distribut.entities.TransactionHandler;
import com.v5ent.distribut.entities.TransactionLock;

/**
 * 分布式事务执行者
 * @author qhq
 *
 */
public class DistributTransactionManager implements DisposableBean{
	private static Logger logger=Logger.getLogger(DistributTransactionManager.class);
	
	private TransactionLock transactionLock;
	
	private CuratorFramework client;
	
	private List<TransactionHandler> transactionHandlers=new ArrayList<TransactionHandler>(5);
	
	private ExecutorService pool = Executors.newCachedThreadPool();
	
	public DistributTransactionManager(ZookeeperClient zkclient) {
		transactionLock=new TransactionLock();
		this.client=zkclient.getClient();
		
		transactionLock.setZkConnection(this.client.getZookeeperClient().getCurrentConnectionString());
	}
	
	
	public DistributTransactionManager pushTransactionHandler(TransactionHandler handler){
		transactionHandlers.add(handler);
		return this;
	}
	
	public void startTransaction() throws TransactionException{
		transactionLock.setCount(transactionHandlers.size());
		List<Future> flist = new ArrayList<Future>();
		try {
			for(int i=0;i<transactionHandlers.size();i++){
				final TransactionHandler handler=transactionHandlers.get(i);
				//多线程同时处理
				Future future = pool.submit(new Runnable() {					
					@Override
					public void run() {
							handler.execute(transactionLock);
					}						
				});
				flist.add(future);
			}
				 try {
					 int i = 0;
					 for(Future future:flist){
						 Object o = future.get();
						 if(o==null){//如果Future's get返回null，任务完成
							 logger.debug("sync distribut transaction success-->任务["+(++i)+"]完成<-- ");
						 }
					 }
			        } catch (InterruptedException e) {
			        } catch (ExecutionException e) {
			            //看看任务失败的原因是什么
			        	throw new TransactionException("分布式事务执行中异常:"+e);
			        }
			pool.shutdown();
	         while (!pool.isTerminated()) {
	              try {
	                   Thread.sleep(10);
	              } catch (InterruptedException e) {
	                   e.printStackTrace();
	              }
	         }
		} catch (Exception e) {
			 throw new TransactionException("分布式事务回滚,异常:"+e);
		}finally{
			try {
				if(client.checkExists().forPath(transactionLock.getParent())!=null){
					client.delete().deletingChildrenIfNeeded().forPath(transactionLock.getParent());
					logger.debug("delete distribut transaction success -->");
				}			
			} catch (Exception e) {
				 logger.debug("delete distribut transaction fail -->");
			}
		}	
	}


	@Override
	public void destroy() throws Exception {
		try {
			if(client.checkExists().forPath(transactionLock.getParent())!=null){
				client.delete().deletingChildrenIfNeeded().forPath(transactionLock.getParent());
				logger.debug("delete distribut transaction success -->");
			}			
		} catch (Exception e) {
			 logger.debug("delete distribut transaction fail -->");
		}
		
	}  
	
	public static DistributTransactionManager getDistributTransactionManager(){
		return ZookeeperClient.getApplicationContext().getBean(DistributTransactionManager.class);
	}
}
