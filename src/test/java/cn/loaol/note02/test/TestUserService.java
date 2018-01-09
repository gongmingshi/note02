package cn.loaol.note02.test;

import org.junit.Test;

import cn.loaol.note02.entity.User;
import cn.loaol.note02.service.UserService;

public class TestUserService extends BaseTest {
	@Test
	public void testLogin() {
		UserService service=ctx.getBean("userService", UserService.class);
		User user=service.login("demo", "123456");
		System.out.println(user);
	}
}
