package com.aartek.pp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aartek.pp.model.User;
import com.aartek.pp.service.LoginService;
import com.aartek.pp.validator.LoginValidator;

//Step Number 7=>2.started
@Controller
public class LoginController {
	
	private static final Logger log = Logger.getLogger(LoginController.class.getName());
	
	@Autowired
	private LoginValidator loginValidator;

	@Autowired
	private LoginService loginservice;

	/*@RequestMapping("/login")
	public String showLogin(Map<String,Object> map)
	{
		System.out.println("Inside Controller");
		map.put("userMap", new User());
			return "login";
	}
	
	@RequestMapping(value="/userSignIn",method = RequestMethod.POST)
	public String SingInAction(@ModelAttribute("userMap") User user,BindingResult result)
	{
		lv.validate(user, result);
		if(result.hasErrors())
		{
		    return "login";
		}
		else 
		{
		System.out.println(user.getEmail()+" "+user.getPassword());
		loginservice.CheckServiceLogin(user);
		return "hello";
		}
	}*/
	
	@RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
	public String LogingAction(@ModelAttribute("userMap") User user, BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Map<String, Object> map, Model model) {
		System.out.println("inside Login Controller:Login Action");
	//	log.info("inside Login Controller:Login Action");

		if ("post".equals(request.getMethod().toLowerCase())) {
			loginValidator.validate(user, result);
			if (result.hasErrors()) {
				return "login";
			} else {
				String check = loginservice.checkLogin(user.getEmail(), user.getPassword());
				if (check.equals("valid")) {
					try {
						request.getSession().setAttribute("User", user);
						response.sendRedirect("product.do");
					} catch (Exception e) {
					//	System.out.println("something wrong");
						log.error("something wrong");
					}
				} else {
					return "login";
				}
			}
		}
		// map.put("userMap",user);
		model.addAttribute("userMap", user);
		return "login";
	}
}