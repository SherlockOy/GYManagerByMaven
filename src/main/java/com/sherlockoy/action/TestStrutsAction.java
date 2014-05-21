package com.sherlockoy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sherlockoy.po.User;
import com.sherlockoy.service.IUserService;

public class TestStrutsAction extends ActionSupport {

	ArrayList<User> users = new ArrayList<User>();
	IUserService userService = null;
//	Map<String, User> informations = new HashMap<String, User>();
//	int[] testArray = new int[3];
//	Set<String> userIds;

	public String execute() throws Exception {
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		userService = (IUserService) factory.getBean("userService");

//		for(int i = 0; i<3;i++){
//			users.add("user"+i);
//		}
		
		users = (ArrayList<User>) userService.getAll();

//
//		for (int i = 0; i < users.size(); i++) {
//			String userId = users.get(i).getUserId();
//			informations.put(userId, users.get(i));
//		}
//		userIds = informations.keySet();

		return "DisplayAllUsers";

	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

//	public int[] getTestArray() {
//		return testArray;
//	}
//
//	public void setTestArray(int[] testArray) {
//		this.testArray = testArray;
//	}
}
