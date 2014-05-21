package com.sherlockoy.dao;

import java.util.ArrayList;

import com.sherlockoy.po.Field;

public interface IFieldDAO {

	// 添加场地
	public void addField(Field field);

	// 删除场地
	public void deleteField(Field field);

	// 获取场地
	public ArrayList<Field> getField(String fieldType, String date);

	// 更新场地
	public void updateField(Field field);
}
