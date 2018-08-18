package com.aartek.pp.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.pp.model.User;

@Repository
public class RegistrationRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void checkRegistration(User user)
	{		
		hibernateTemplate.save(user);
		
		System.out.println("Inside REG Repo");
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getMobileNo());
	}
	
	public String checkEmailId(String email)
	{
		List<User> list = hibernateTemplate.find("from User u where u.email=?",email);
		Iterator itr = list.iterator();
		while(itr.hasNext())
		{
			User u = (User)itr.next();
			email = u.getEmail();
		}
		return "email";
	}
}
