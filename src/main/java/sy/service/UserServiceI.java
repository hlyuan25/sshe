package sy.service;

import sy.model.DataGrid;
import sy.model.Tuser;
import sy.pageModel.User;

public interface UserServiceI {
	
	public User save(User user);
	
	public User login(User user);

	public DataGrid datagrid(User user);

	public void remove(String ids);
	
	public User edit(User user);
}
