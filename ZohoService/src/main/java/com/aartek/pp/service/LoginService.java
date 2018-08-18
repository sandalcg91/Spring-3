package com.aartek.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.pp.model.User;
import com.aartek.pp.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	public String checkLogin(String email, String password)
	{
		System.out.println("Inside Service");
		String check = loginRepository.checkLogPass(email, password);
		if(check.equals("valid"))
		{
			System.out.println(check);
			return check;
		}
		else
		{
			System.out.println(check);
			return check;
		}
	}
}