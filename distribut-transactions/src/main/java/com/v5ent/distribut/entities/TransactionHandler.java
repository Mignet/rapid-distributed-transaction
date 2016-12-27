package com.v5ent.distribut.entities;

/**
 *分布式事务执行体
 */
public abstract class TransactionHandler{
	/***
	 * 执行
	 * @param transactionLock 事务锁
	 * @return 通用执行结果
	 */
	public abstract Object execute(TransactionLock transactionLock);
	
}
