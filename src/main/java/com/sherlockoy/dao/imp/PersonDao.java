package com.sherlockoy.dao.imp;

import com.sherlockoy.dao.IPersonDao;

public class PersonDao implements IPersonDao {

	private String tag = "injected";

	public void save() {
		// TODO Auto-generated method stub
		System.out.println("-----------from PersonDao.save()");
	}

}
