package sy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import sy.model.DataGrid;
import sy.pageModel.User;
import sy.service.UserServiceI;
import sy.util.Json;

import com.opensymphony.xwork2.ModelDriven;

@Namespace("/")
@Action(value = "userAction")
public class UserAction extends BaseAction implements ModelDriven<User> {

	private UserServiceI userService;
	private User user = new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	public void reg() {
		Json j = new Json();
		try {
			userService.save(user);
			j.setSuccess(true);
			j.setMsg("注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("注册失败");
		}
		super.writeJson(j);
	}

	public void login() {
		Json j = new Json();
		User u = userService.login(user);
		if (u != null) {
			j.setSuccess(true);
			j.setMsg("登录成功");
		} else{
			j.setMsg("登录失败");
		}
			
		super.writeJson(j);
	}
	public void datagrid(){
		DataGrid dg = userService.datagrid(user);
		super.writeJson(dg);
	}
	public void add() {
		Json j = new Json();
		try {
			User u = userService.save(user);
			j.setSuccess(true);
			j.setMsg("添加成功");
			j.setObj(u);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("添加失败");
		}
		super.writeJson(j);
	}
	public void remove(){
		userService.remove(user.getIds());
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功！");
		super.writeJson(j);
	}
	public void edit(){
		Json j = new Json();
		User u = userService.edit(user);
		j.setSuccess(true);
		j.setMsg("编辑成功！");
		j.setObj(u);
		
		super.writeJson(j);
	}
}
