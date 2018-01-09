package cn.loaol.note02.test;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import cn.loaol.note02.dao.UserDao;
import cn.loaol.note02.entity.User;

public class TestUserDao extends BaseTest {
	
	@Test
	public void testfindUserByName() {
		UserDao dao=ctx.getBean("userDao", UserDao.class);
		User user=dao.findUserByName("demo");
		System.out.println(user);
	}
	
	@Test
	public void testaddUser() {
		UserDao dao=ctx.getBean("userDao", UserDao.class);
		String salt="gongmingshi";
		String password=DigestUtils.md2Hex(salt+"cyq");
		User user=new User(UUID.randomUUID().toString(),"cyq",password,"","cyq");
		int rs=dao.addUser(user);
		System.out.println(rs);
	}
}
