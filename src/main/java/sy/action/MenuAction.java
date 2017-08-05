package sy.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import sy.pageModel.Menu;
import sy.service.MenuServiceI;

import com.opensymphony.xwork2.ModelDriven;

@Action(value = "menuAction")
public class MenuAction extends BaseAction implements ModelDriven<Menu> {

	private MenuServiceI menuService;

	private Menu menu = new Menu();

	@Override
	public Menu getModel() {
		// TODO Auto-generated method stub
		return menu;
	}

	public MenuServiceI getMenuService() {
		return menuService;
	}

	@Autowired
	public void setMenuService(MenuServiceI menuService) {
		this.menuService = menuService;
	}

	public void getTree(){
		List<Menu> l = menuService.getTreeNode(menu.getId());
		super.writeJson(l);
	}
	public void getAllTreeNode() {
		List<Menu> l = menuService.geAllTreeNode();
		super.writeJson(l);
	}
}
