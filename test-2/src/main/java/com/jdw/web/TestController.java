package com.jdw.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.domain.vo.UserInfoVo;
import com.hd.interfaces.IUserInfoService;
import com.v5ent.distribut.util.UUIDUtils;

@Controller
public class TestController {
	@Autowired
	private  IUserInfoService userInfoService;
    @RequestMapping("/")
    @ResponseBody
   public String home() {
    	UserInfoVo userInfo=new UserInfoVo();
    	userInfo.setId(UUID.nameUUIDFromBytes("jdw".getBytes()).toString());
    	userInfo.setUserId(UUIDUtils.generateStringUuid());
    	userInfo.setInfo("standalone mode info");
    	this.userInfoService.save(userInfo,null);
        return "Hello World! I'm userinfo from test2";
    }

}
