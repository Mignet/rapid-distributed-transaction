package com.jdw.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hd.domain.vo.UserInfoVo;
import com.hd.interfaces.IUserInfoService;
import com.jdw.entity.UserInfo;
import com.jdw.mapper.UserInfoMapper;
import com.v5ent.distribut.entities.TransactionLock;

@Service
public class UserInfoService implements IUserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Transactional(readOnly = false)
	public int save(UserInfoVo userInfo,TransactionLock transactionLock) {		
		UserInfo record = new UserInfo();
		BeanUtils.copyProperties(userInfo, record);
		int i = userInfoMapper.insert(record);
		return i;
	}
}
