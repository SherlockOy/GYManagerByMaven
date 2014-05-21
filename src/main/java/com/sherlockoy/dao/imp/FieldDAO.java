package com.sherlockoy.dao.imp;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sherlockoy.dao.IFieldDAO;
import com.sherlockoy.po.Field;

public class FieldDAO implements IFieldDAO {

	SessionFactory sessionFactory = null;

	public void addField(Field field) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = this.sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(field);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		session.close();
	}

	public void deleteField(Field field) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(field);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		session.close();
	}

	public ArrayList<Field> getField(String fieldType, String date) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Field where fieldType = ? and date = ?");
		query.setString(0, fieldType);
		query.setString(1, date);
		ArrayList<Field> list = (ArrayList) query.list();
		if (list.size() > 0) {
			return list;
		} else
			return null;
	}

	public void updateField(Field field) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(field);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
