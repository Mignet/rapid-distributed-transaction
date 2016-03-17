package com.hd.interfaces;

import com.hd.domain.vo.UserVo;
import com.v5ent.distribut.entities.TransactionLock;

public interface IUserService {
	
	
	public int save(UserVo user,TransactionLock transactionLock);
	
	
	public int saveOne(UserVo user);
}
