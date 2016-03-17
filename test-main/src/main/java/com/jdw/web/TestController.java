package com.jdw.web;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.domain.vo.TicketVo;
import com.hd.domain.vo.UserInfoVo;
import com.hd.domain.vo.UserVo;
import com.hd.interfaces.ITicketService;
import com.hd.interfaces.IUserInfoService;
import com.hd.interfaces.IUserService;
import com.v5ent.distribut.entities.TransactionException;
import com.v5ent.distribut.entities.TransactionHandler;
import com.v5ent.distribut.entities.TransactionLock;
import com.v5ent.distribut.transaction.DistributTransactionManager;
import com.v5ent.distribut.util.UUIDUtils;

@Controller
public class TestController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Autowired
	private ITicketService ticketService;

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		//第一步：获取分布式事务管理者，所有服务调用由其统一发起
		DistributTransactionManager transactionManager = DistributTransactionManager
				.getDistributTransactionManager();
		
		final String userId = UUIDUtils.generateStringUuid();
		//第二步：添加分布式服务到管理器中
		try {
			transactionManager.pushTransactionHandler(new TransactionHandler() {//分布式服务调用1
				@Override
				public Object execute(TransactionLock transactionLock) {
					UserVo user = new UserVo();
					user.setId(userId);
					user.setUsername("~~~~~~测试用户~~~~~~");
					return userService.save(user, transactionLock);
				}
			}).pushTransactionHandler(new TransactionHandler() {//分布式服务调用2
				@Override
				public Object execute(TransactionLock transactionLock) {
					UserInfoVo userInfoVo = new UserInfoVo();
					userInfoVo.setId(UUID.randomUUID().toString());
					userInfoVo.setUserId(userId);
					userInfoVo.setInfo("~~~~~~测试信息~~~~~~");
					return userInfoService.save(userInfoVo, transactionLock);
				}
			}).pushTransactionHandler(new TransactionHandler() {//本地服务调用3
				@Override
				public Object execute(TransactionLock transactionLock) {
					TicketVo ticketVo = new TicketVo();
					ticketVo.setId(UUIDUtils.generateStringUuid());
					ticketVo.setUserId(userId);
					ticketVo.setCreateTime(new Date());
					return ticketService.save(ticketVo, transactionLock);
				}
			}).startTransaction();//调用startTransaction方法执行
		} catch (TransactionException e) {//捕获多线程抛出异常
			return e.getMessage();
		}

		return "Hello World!";
	}

}
