package cn.loaol.note02.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.loaol.note02.entity.User;
import cn.loaol.note02.service.UserService;
import cn.loaol.note02.util.JsonResult;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Resource
	UserService uservice;
	@RequestMapping("/login.do")
	@ResponseBody
	public Object login(String name,String password) {
		User user=uservice.login(name, password);
		return new JsonResult(0,"登陆成功！",user);
	}
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object exHandler(Throwable e) {
		String eMsg=e.getMessage();
		String[] eMsgs=eMsg.split("-");
		String[] eMsgs1=eMsg.split("\\.");
		int state=Integer.parseInt(eMsgs1[0]);
		String messge=eMsgs[1];
		return new JsonResult(state,messge,null);
	}
}
