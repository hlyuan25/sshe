package sy.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ActionContext;
@Action
public class UserAction {
	private String username;
	
	public String detail(){
		username = "张三";
		
		List list = new ArrayList();
		for(int i = 0; i<10; i++){
			User user = new User();
			user.setUsername("user"+i);
			list.add(user);
		}
		ActionContext.getContext().put("users", list);
		
		User u = new User();
		u.setUsername("赵毅");
		ActionContext.getContext().getValueStack().push(u);
		
		return "detail";
	}
}
