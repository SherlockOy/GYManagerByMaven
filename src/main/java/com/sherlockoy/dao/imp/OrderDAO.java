package com.sherlockoy.dao.imp;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sherlockoy.dao.IOrderDAO;
import com.sherlockoy.po.Order;

public class OrderDAO implements IOrderDAO {

	// private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	private SessionFactory sessionFactory = null;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void createOrder(Order order) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = this.sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(order);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		session.close();
		
		
	}

	public void deleteOrder(Order toDelete) {
		// TODO Auto-generated method stub

	}

	public void updateOrder(Order newOrder) {
		// TODO Auto-generated method stub

	}

}
