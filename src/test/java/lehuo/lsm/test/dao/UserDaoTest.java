package lehuo.lsm.test.dao;

import lehuo.lsm.dao.UserDao;
import lehuo.lsm.model.User;

import lehuo.lsm.service.impl.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class UserDaoTest {
	private ClassPathXmlApplicationContext context;
	private UserDao userDao;

    @Resource
    private UserService userService;
	@Before
	public void init() {
		context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        userService = (UserService) context.getBean("userService");
	}

	@Test
	public void testUserInsert() {
		User u = new User("asdasdas", "123", "lsm0622@163.com", 18,'F');
        userService.insert(u);
	}
}