package cn.loaol.note02.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.loaol.note02.dao.UserDao;
import cn.loaol.note02.entity.User;
import cn.loaol.note02.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	UserDao udao;
	
	@Value("#{db.salt}")
	private String salt;
	
	public User login(String name, String password) {
		if(name==null||name.trim().isEmpty()) throw new ApplicationExection("1.1-账号为空");
		if(password==null||password.trim().isEmpty()) throw new ApplicationExection("2.1-密码为空");		
		User user=udao.findUserByName(name);
		if(user==null) throw new ApplicationExection("1.2-账号不正确");
		String pwd=DigestUtils.md2Hex(salt+password);
		if(!pwd.equals(user.getPassword())) throw new ApplicationExection("2.2-密码不正确");
		return user;
	}
	
	public int regist(String name, String nick, String password, String confirm) {
		if(name==null||name.trim().isEmpty()) throw new ApplicationExection("1.1-账号为空");
		if(password==null||password.trim().isEmpty()) throw new ApplicationExection("2.1-密码为空");
		if(confirm==null||confirm.trim().isEmpty()) throw new ApplicationExection("3.1-验证密码为空");
		if(!password.equals(confirm)) throw new ApplicationExection("3.2-验证密码不一至");
		User user=udao.findUserByName(name);
		if(user!=null) throw new ApplicationExection("1.2-账号已存在");
		user=new User();
		user.setId(UUID.randomUUID().toString());
		user.setName(name);
		user.setNick(nick);
		String pwd=DigestUtils.md2Hex(salt+password);
		user.setPassword(pwd);
		int rs=udao.addUser(user);
		if(rs!=1) throw new RuntimeException("增加失败！");
		return rs;
	}
	
}
