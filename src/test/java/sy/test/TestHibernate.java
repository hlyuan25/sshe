package sy.test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sy.dao.UserDaoI;
import sy.model.Tuser;
import sy.service.UserServiceI;

public class TestHibernate {

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","spring-hibernate.xml"});
		UserServiceI userService = (UserServiceI) ac.getBean("userService");
		Tuser t = new Tuser();
		t.setId(UUID.randomUUID().toString());
		t.setName("海龙");
		t.setPwd("123456");
		t.setCreatedatetime(new Date());
		userService.save(t);
	}
}
