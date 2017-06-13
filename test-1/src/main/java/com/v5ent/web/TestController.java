package com.v5ent.web;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hd.domain.vo.UserVo;
import com.hd.interfaces.IUserService;

@Controller
public class TestController {
	@Autowired
	private  IUserService userService;
    @RequestMapping("/")
    @ResponseBody
   public String home() {
    	UserVo user=new UserVo();
    	user.setId(UUID.randomUUID().toString());
    	user.setUsername("standalone mode");
    	this.userService.saveOne(user);
        return "Hello World! I'm user from test1";
    }

}
