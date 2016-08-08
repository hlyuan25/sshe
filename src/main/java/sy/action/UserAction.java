package sy.action;

import java.util.UUID;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sy.model.Tuser;
import sy.service.UserServiceI;

@ParentPackage("basePackage")
@Namespace("/")
@Action(value="userAction")
public class UserAction {
	
	private UserServiceI userService;
	
	public UserServiceI getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	public void test(){
		System.out.println("程序进入Action!");
	}
	public void test2(){
		Tuser t = new Tuser(UUID.randomUUID().toString(), "永吉", "456");
		userService.save(t);
		
	}
}
