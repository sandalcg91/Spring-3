package com.aartek.pp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
				session.invalidate();
		request.getSession().setAttribute("UserMsg", "Session Invalidate");
		return "redirect:/login.do";
	}
}