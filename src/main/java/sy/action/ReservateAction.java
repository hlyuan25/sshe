package sy.action;

import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.ModelDriven;

import sy.pageModel.Order;
import sy.service.ReservateServiceI;
import sy.util.Json;

@Action(value="reservateAction")
public class ReservateAction extends BaseAction implements ModelDriven<Order>{
	private ReservateServiceI reservateService;
	
	private Order order = new Order();
	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	public void reservate(Order order){
		Json j = new Json();
		try {
			reservateService.save(order);
			j.setSuccess(true);
			j.setMsg("注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("注册失败");
		}
		super.writeJson(j);
	}
	
}
