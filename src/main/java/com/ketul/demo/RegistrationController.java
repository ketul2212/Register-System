package com.ketul.demo;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
	
	@RequestMapping("home")
	public String getName(HttpServletRequest req) {
		
		
		String name = req.getParameter("name");
		System.out.println("Hi " + name);
		
		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		
		return "home.jsp";
		
	}
	
}
