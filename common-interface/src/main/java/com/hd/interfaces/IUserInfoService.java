package com.hd.interfaces;

import com.hd.domain.vo.UserInfoVo;
import com.v5ent.distribut.entities.TransactionLock;

public interface IUserInfoService {
	public int save(UserInfoVo userInfo,TransactionLock transactionLock);
}
