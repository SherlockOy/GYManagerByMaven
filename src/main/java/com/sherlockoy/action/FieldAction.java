package com.sherlockoy.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.web.context.request.WebRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sherlockoy.po.Field;
import com.sherlockoy.po.Order;
import com.sherlockoy.po.User;
import com.sherlockoy.service.IFieldService;
import com.sherlockoy.service.IOrderService;

public class FieldAction extends ActionSupport {

	private IFieldService fieldService = null;
	public ArrayList<Field> resultFields = new ArrayList<Field>();
	private String fieldType;
	private String selectedDate;

	private HttpServletRequest request = ServletActionContext.getRequest();

	public String fieldDisplay() {

		BeanFactory factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		IFieldService fieldService = (IFieldService) factory
				.getBean("fieldService");

		// 获取场地信息
		resultFields = fieldService.getTargetFields(fieldType, selectedDate);

		Map session = ActionContext.getContext().getSession();
		session.put("date", selectedDate);
		session.put("fieldType", fieldType);

		if (fieldType.equals("badminton"))
			return "DisplayBadminton";
		else if (fieldType.equals("pingpong"))
			return "DisplayPingPong";
		else if (fieldType.equals("tennis"))
			return "DisplayTennis";
		else
			return "DisplayError";
	}

	public String fieldOrder() {

		// 获取session对象
		Map session = ActionContext.getContext().getSession();

		// 获取orderService实例对象
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		IOrderService orderService = (IOrderService) factory
				.getBean("orderService");

		// 获取所需要的各种对象
		String date = (String) session.get("date");
		User userInfo = (User) session.get("userInfo");
		String fieldType = (String) session.get("fieldType");
		String userName = userInfo.getUserName();
		// 获取orders对象
		String[] parameters = new String[32];
		parameters = request.getParameterValues("order");

		// 初始化ArrayList
		ArrayList<Order> orders = new ArrayList<Order>();

		// 订场的业务逻辑
		orders = orderService.processOrders(parameters, date, userName,
				fieldType);
		orderService.submitOrders(orders);

		// 准备调用display()
		this.selectedDate = date;
		this.fieldType = fieldType;

		// 调用display()，进入现实场地
		return fieldDisplay();
	}

	public IFieldService getFieldService() {
		return fieldService;
	}

	public void setFieldService(IFieldService fieldService) {
		this.fieldService = fieldService;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}

}
