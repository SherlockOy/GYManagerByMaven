package com.sherlockoy.dao;

import com.sherlockoy.po.Order;

public interface IOrderDAO {
	
	public void createOrder(Order toSubmit);

	public void deleteOrder(Order toDelete);

	public void updateOrder(Order newOrder);
}
