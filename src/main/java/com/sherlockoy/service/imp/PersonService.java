package com.sherlockoy.service.imp;

import com.sherlockoy.dao.IPersonDao;
import com.sherlockoy.service.IPersonService;

public class PersonService implements IPersonService {

	private IPersonDao personDao = null;

	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}

	public void processSave() {
		// TODO Auto-generated method stub
		System.out.println("-----------from PersonService.processSave()");

		personDao.save();
	}

}
