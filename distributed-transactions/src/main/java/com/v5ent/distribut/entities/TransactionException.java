package com.v5ent.distribut.entities;

/**
 *分布式事务异常类
 */
public class TransactionException extends RuntimeException {
	
	private static final long serialVersionUID = 728848033031216497L;

	public TransactionException(String massage) {
		super(massage);
	}
	
	public TransactionException(Throwable e) {
		super(e);
	}
	public TransactionException() {
		super();
	}

	public TransactionException(String message, Throwable e) {
		super(message,e);
	}

}
