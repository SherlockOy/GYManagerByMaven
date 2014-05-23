package com.sherlockoy.action;

import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sherlockoy.po.User;
import com.sherlockoy.service.IUserService;
import com.sherlockoy.service.imp.UserService;

public class RegisterAction extends ActionSupport {

	private String userId;
	private String userName;
	private String passWord;
	private String email;
	private User user = new User();
	private IUserService userService = null;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = (UserService) userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {

		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (IUserService) factory.getBean("userService");
		
		if (userService.isUserExist(userName)) {
			return "USEREXIST";
		} else {
			if (userName == null || passWord == null) {
				return "NOTVOID";
			} else {
				user.setUserName(userName);
				user.setEmail(email);
				user.setPassWord(passWord);

				if (userService.registerUser(user)) {
					User userInfo = userService.getUserInfo(userName);
					Map session = ActionContext.getContext().getSession();
					session.put("userInfo", userInfo);
					return "RegisterDone";
				}
				return "RegisterError";
			}
		}
	}
}
