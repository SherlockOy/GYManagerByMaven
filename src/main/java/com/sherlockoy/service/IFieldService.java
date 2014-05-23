package com.sherlockoy.service;

import java.util.ArrayList;

import com.sherlockoy.po.Field;

public interface IFieldService {
	// 添加场地
	public void addField(Field field);

	// 返回一组ArrayList类型的场地对象
	public ArrayList<Field> getTargetFields(String FieldType, String date);

	// 删除场地
	public void deleteField(Field field);

}
