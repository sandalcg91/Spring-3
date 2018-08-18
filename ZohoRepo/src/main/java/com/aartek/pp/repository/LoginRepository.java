package com.aartek.pp.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.pp.model.User;

@Repository
public class LoginRepository {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public String checkLogPass(String email, String password)
	{	
		System.out.println("inside login repo");
		List list = hibernateTemplate.find("from User u where u.email=? and u.password=?", email, password);
		Iterator itr = list.iterator();
		String email1 = null;
		String psw = null;
		String check = null;
		while(itr.hasNext())
		{
			User u = (User)itr.next();
			email1 = u.getEmail();
			psw = u.getPassword();			
		}
		if(email.equals(email1) && password.equals(psw))
		{
			System.out.println(email+" Login Successfull");
			check="valid";
		}
		else
		{
			System.out.println("Invalid EMail and Password");
			check="Not valid";
		}
		System.out.println(check);
		return check;
	}
	
	public void checkLogin(User user)
	{
		System.out.println("Inside Service");
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
	}
}