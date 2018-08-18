package com.aartek.pp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.pp.model.User;
import com.aartek.pp.service.RegistrationService;
import com.aartek.pp.validator.RegistrationValidator;

@Controller
public class RegistrationController {
	
	private static final Logger log = Logger.getLogger(RegistrationController.class);
	
	@Autowired
	private RegistrationValidator registrationValidator;
	
	@Autowired
	private RegistrationService registrationService;
	
/*	@RequestMapping("/registration")
	public String saveUserDetails(Map<String, Object> map)
	{
		System.out.println("Inside Registration Controller");
		map.put("saveUserMap", new User());
		return "registration";
	}
	
	@RequestMapping(value="/saveUserDeatils", method=RequestMethod.POST)
	public String getUserDetails(@ModelAttribute("saveUserMap") User user, BindingResult result)
	{
//		boolean status = false;
		registrationValidator.validate(user, result);
		
		if(result.hasErrors())
		{
			return "registration";
		}
		System.out.println("Inside REG Controller");
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(user.getMobileNo());
		registrationService.checkRegistration(user);
		return "Hello";
	}
*/	@RequestMapping(value="/registration", method= { RequestMethod.GET, RequestMethod.POST})
	public String saveRegistrationDetails(@ModelAttribute("userMap") User user, BindingResult result, Map<String, Object> map, HttpServletRequest req)
	{
//	 String method = req.getMethod();
		/*if("GET".equals(req.getMethod().toLowerCase()))
		{
			System.out.println("Inside Registration Controller");
			map.put("userMap", new User());
			return "registration";
		}
		else*/ 
		if ("post".equals(req.getMethod().toLowerCase()))
		{
			registrationValidator.validate(user, result);
			if(result.hasErrors())
			{
				return "registration";
			}
			else
			{
			//	log.info("Inside Reg Controller");
				System.out.println("Inside REG Controller");
			/*	System.out.println(user.getFirstname());
				System.out.println(user.getLastname());
				System.out.println(user.getEmail());
				System.out.println(user.getPassword());
				System.out.println(user.getMobileNo());*/
				registrationService.checkRegistration(user);
				return "hello";
			}
		}
		map.put("userMap", user);
		return "registration";
	}
}