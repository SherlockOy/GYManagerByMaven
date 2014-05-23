package com.sherlockoy.action;

import java.util.ArrayList;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sherlockoy.po.Field;
import com.sherlockoy.service.IFieldService;

public class FieldAction extends ActionSupport {

	private IFieldService fieldService = null;
	public ArrayList<Field> resultFields = new ArrayList<Field>();
	private String fieldType;
	private String selectedDate;

	public String fieldDisplay() {

		BeanFactory factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		IFieldService fieldService = (IFieldService) factory
				.getBean("fieldService");

		// 获取场地信息
		resultFields = fieldService.getTargetFields(fieldType, selectedDate);
		return "DisplayBadminton";
	}

	public String fieldOrder() {
		return null;
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
