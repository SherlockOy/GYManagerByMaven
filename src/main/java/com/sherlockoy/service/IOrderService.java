package com.sherlockoy.service;

import java.util.ArrayList;
import java.util.List;

import com.sherlockoy.po.Item;
import com.sherlockoy.po.Order;
import com.sherlockoy.po.User;

public interface IOrderService {
	// 处理前端传回的Parameters，并解析成对应的场地信息生成一个Order对象
	public ArrayList<Order> processOrders(String[] parameters, String date,
			String subscriber, String item);

	// 提交订单
	public void submitOrders(ArrayList<Order> orders);
}
