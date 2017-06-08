package com.v5ent.distribut.entities;


import java.io.Serializable;

import com.v5ent.distribut.util.UUIDUtils;

/**
 *分布式事务锁
 */
public class TransactionLock implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 *统一事务父级路径 
	 */
	private String parent=UUIDUtils.generatorTransactionPath("mignet");	
	/**
	 * 参与当前事务的服务数量
	 */
	private int count;
	/**
	 * 事务超时时间 默认为5000毫秒
	 */
	private long timeout=5000;
	
	private String zkConnection;
	
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getTimeout() {
		return timeout;
	}
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	public String getZkConnection() {
		return zkConnection;
	}
	public void setZkConnection(String zkConnection) {
		this.zkConnection = zkConnection;
	}
	
}
