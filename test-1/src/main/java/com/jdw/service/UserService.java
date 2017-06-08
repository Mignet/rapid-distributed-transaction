package com.jdw.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hd.domain.vo.UserVo;
import com.hd.interfaces.IUserService;
import com.jdw.entity.User;
import com.jdw.mapper.UserMapper;
import com.v5ent.distribut.entities.TransactionLock;
@Service
public class UserService implements IUserService{
	@Autowired
	private UserMapper userMapper;
	
	@Transactional(readOnly=false)
	public int save(UserVo user, TransactionLock transactionLock) {
		User record = new User();
		BeanUtils.copyProperties(user, record);
		int i = userMapper.insert(record);
//		i=i/0;
		return i;
	}
	
	@Override
	@Transactional(readOnly=false)
	public int saveOne(UserVo user) {
		int i=0;
		User record=new User();
		BeanUtils.copyProperties(user, record);
		i = userMapper.insert(record);
//		try {
//			testError(i);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return i;
	}
	@Transactional
	public void testError(int i){
		Object o = null;
		o.getClass();
//		i=i/0;
	}
}
