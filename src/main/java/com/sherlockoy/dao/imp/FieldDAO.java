package com.sherlockoy.dao.imp;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sherlockoy.dao.IFieldDAO;
import com.sherlockoy.po.Field;

public class FieldDAO implements IFieldDAO {

	SessionFactory sessionFactory = null;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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
				.createQuery("from Field where fieldType = :fieldType and date = :date");
		query.setString("fieldType", fieldType);
		query.setString("date", date);
		ArrayList<Field> list = (ArrayList<Field>) query.list();
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

	public Field getFieldByRules(String fieldType, String date, String fieldNum) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from Field where fieldType = :fieldType and date = :date and fieldNum = :fieldNum");
		query.setString("fieldType", fieldType);
		query.setString("date", date);
		query.setString("fieldNum", fieldNum);
		ArrayList<Field> list = (ArrayList<Field>) query.list();
		if (list.size() > 0) {
			return list.get(0);
		} else
			return null;
	}

	// public static void main(String[] args) {
	// for (int i = 1; i <= 31; i++) {
	// for (int j = 1; j <= 4; j++) {
	// Field field = new Field();
	// field.setFieldNum(String.valueOf(j));
	// field.setFieldType("badminton");
	// field.setDate("2014-5-" + i);
	// field.setTimeSec1(1);
	// field.setTimeSec2(1);
	// field.setTimeSec3(1);
	// field.setTimeSec4(1);
	// field.setTimeSec5(1);
	// field.setTimeSec6(1);
	// field.setTimeSec7(1);
	// field.setTimeSec8(1);
	//
	// FieldDAO fieldDAO = new FieldDAO();
	// fieldDAO.addField(field);
	// }
	// }
	// }
}
