package cn.loaol.note02.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.loaol.note02.service.UserService;
import cn.loaol.note02.util.JsonResult;

@Controller
@RequestMapping("user")
public class RegController {
	@Resource
	UserService uservice;
	@RequestMapping("/reg.do")
	@ResponseBody
	public Object reg(String name,String nick,String password,String confirm) {
		int rs=uservice.regist(name, nick, password, confirm);
		if(rs==1)
		return new JsonResult(0,"注册成功",null);
		return -1;
	}
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object exHandler(Throwable e) {
		String[]msg=e.getMessage().split("\\.");
		String[]msg1=e.getMessage().split("-");
		return new JsonResult(Integer.parseInt(msg[0]), msg1[1], null);
	}
}
