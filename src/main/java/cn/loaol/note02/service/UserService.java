package cn.loaol.note02.service;

import cn.loaol.note02.entity.User;

public interface UserService {
	User login(String name,String password);
	int regist(String name,String nick,String password,String comfirm);
}
