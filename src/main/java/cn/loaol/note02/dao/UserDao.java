package cn.loaol.note02.dao;

import cn.loaol.note02.entity.User;

public interface UserDao {
	User findUserByName(String name);
	int addUser(User user);
}
