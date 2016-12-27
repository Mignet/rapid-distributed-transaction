package com.v5ent.distribut.entities;

import java.io.Serializable;

/**
 * 分布式事务结果类
 */
public class TransactionResult implements Serializable {

	private static final long serialVersionUID = -8576874166417080403L;
	/**
	 * 事务返回结果 默认值 true
	 */
	private boolean hasResult = true;

	/**
	 * 事务是否结束 默认值 false
	 */
	private boolean ended = false;

	public boolean isHasResult() {
		return hasResult;
	}

	public void setHasResult(boolean hasResult) {
		this.hasResult = hasResult;
	}

	public boolean isEnded() {
		return ended;
	}

	public void setEnded(boolean ended) {
		this.ended = ended;
	}

}
