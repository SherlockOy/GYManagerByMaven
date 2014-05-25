package com.sherlockoy.service.imp;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import com.sherlockoy.dao.IFieldDAO;
import com.sherlockoy.dao.IOrderDAO;
import com.sherlockoy.po.Field;
import com.sherlockoy.po.Order;
import com.sherlockoy.service.IOrderService;

public class OrderService implements IOrderService {

	private IOrderDAO orderDAO = null;
	private IFieldDAO fieldDAO = null;

	@Transactional
	public ArrayList<Order> processOrders(String[] parameters, String date,
			String subscriber, String item) {
		// TODO Auto-generated method stub
		ArrayList<Order> orders = new ArrayList<Order>();
		int length = parameters.length;
		for (int i = 0; i < length; i++) {

			// 获取数组元素，对每个元素进行解析，分解为场地号和选中的场地时间段
			String fieldNum = parameters[i].substring(0, 1);
			String timeSectionChoosen = parameters[i].substring(1, 2);

			// 取得Swticher
			char switcher = timeSectionChoosen.charAt(0);
			String timeSection = "";

			//根据要求获取场地对象
			Field field = new Field();
			field = fieldDAO.getFieldByRules(item, date, fieldNum);

			//按规则解析参数，不同字母代表不同的时间段，对所获得的field对象进行更新
			switch (switcher) {
			case 'a':
				field.setTimeSec1(0);
				timeSection = "timeSec1";
				break;
			case 'b':
				field.setTimeSec2(0);
				timeSection = "timeSec2";
				break;
			case 'c':
				field.setTimeSec3(0);
				timeSection = "timeSec3";
				break;
			case 'd':
				field.setTimeSec4(0);
				timeSection = "timeSec4";
				break;
			case 'e':
				field.setTimeSec5(0);
				timeSection = "timeSec5";
				break;
			case 'f':
				field.setTimeSec6(0);
				timeSection = "timeSec6";
				break;
			case 'g':
				field.setTimeSec7(0);
				timeSection = "timeSec7";
				break;
			case 'h':
				field.setTimeSec8(0);
				timeSection = "timeSec8";
				break;
			default:
				break;
			}

			// 处理完成之后将数据库中场地数据进行修改，然后存入list
			fieldDAO.updateField(field);
			orders.add(buildOrder(subscriber, date, item, timeSection));

		}
		return orders;
	}

	@Transactional
	// 调用OrderService和FieldService对处理好的orders
	public void submitOrders(ArrayList<Order> orders) {
		// TODO Auto-generated method stub
		for(int i = 0; i < orders.size();i++){
			orderDAO.createOrder(orders.get(i));
		}
	}

	public Order buildOrder(String subscriber, String date, String item,
			String timeSection) {

		//各种Set
		Order order = new Order();
		order.setSubscriber(subscriber);
		order.setDate(date);
		order.setItem(item);
		order.setTimeSection(timeSection);

		return order;
	}

	
	//getters and setters
	public IOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(IOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public IFieldDAO getFieldDAO() {
		return fieldDAO;
	}

	public void setFieldDAO(IFieldDAO fieldDAO) {
		this.fieldDAO = fieldDAO;
	}

}
