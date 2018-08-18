package com.aartek.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.pp.model.User;
import com.aartek.pp.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;

	public void checkRegistration(User user)
	{
		System.out.println("Inside REG Service");
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getMobileNo());
		registrationRepository.checkRegistration(user);
	}
}
