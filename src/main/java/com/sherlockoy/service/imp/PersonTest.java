package com.sherlockoy.service.imp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sherlockoy.service.IPersonService;
import com.sherlockoy.service.IUserService;

public class PersonTest {

	private BeanFactory factory = null;

	@Before
	public void before() {
		factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testSpring() {
		IUserService userService = (IUserService) factory
				.getBean("userService");
		System.out.println(userService.toString());
	}

//	public void test(String args) {
//
//		IPersonService personService = (IPersonService) factory
//				.getBean("personService");
//		personService.processSave();
//	}
}
