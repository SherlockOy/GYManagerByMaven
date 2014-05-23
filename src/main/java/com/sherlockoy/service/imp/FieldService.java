package com.sherlockoy.service.imp;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.sherlockoy.dao.IFieldDAO;
import com.sherlockoy.dao.imp.FieldDAO;
import com.sherlockoy.po.Field;
import com.sherlockoy.service.IFieldService;

public class FieldService implements IFieldService {

	private IFieldDAO fieldDAO = null;

	public FieldService() {
	}

	@Resource(name = "fieldDAO")
	public void setFieldDAO(FieldDAO fieldDAO) {
		this.fieldDAO = fieldDAO;
	}

	public void addField(Field field) {
		// TODO Auto-generated method stub

	}

	@Transactional
	public ArrayList<Field> getTargetFields(String fieldType, String date) {
		// TODO Auto-generated method stub

		ArrayList<Field> targetFields = fieldDAO.getField(fieldType, date);
		if (targetFields == null)
			return null;
		else
			return targetFields;
	}

	public void deleteField(Field field) {
		// TODO Auto-generated method stub

	}

}
