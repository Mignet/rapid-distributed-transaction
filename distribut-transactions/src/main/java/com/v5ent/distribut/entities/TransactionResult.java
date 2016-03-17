package com.v5ent.distribut.entities;

import java.io.Serializable;

/**
 *分布式事务结果类
 */
public class TransactionResult implements Serializable{

	private static final long serialVersionUID = -8576874166417080403L;
	/**
	 *事务返回结果   默认值 true
	 */
	private boolean result=true;	
	/**
	 * 事务是否结束  默认值 false
	 */
	private boolean end=false;
		
	public boolean hasResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public boolean isEnd() {
		return end;
	}
	public void setEnd(boolean end) {
		this.end = end;
	}
	
	
	
}
