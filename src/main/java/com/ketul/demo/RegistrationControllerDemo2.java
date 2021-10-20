package com.ketul.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegistrationControllerDemo2 {

	@RequestMapping("reg1")
	public void getDetails(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Pattern p;
		Matcher m;
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String no  = req.getParameter("no");
		
		res.setContentType("text/html");
		
		
		PrintWriter pw = res.getWriter();
		
		if(name != "" && email != "" && no != "") {
			if(name.length() > 5)
				pw.println("<h1> Your name is " + name + "</h1><br/>");
			else
				pw.println("<p style = 'color : red'>Please enter your name with length 5</p>");
			
			p = Pattern.compile("[a-zA-Z][a-zA-Z0-9_.]*@[a-zA-Z0-9]*([.][a-zA-Z]+)+");
			m = p.matcher(email);
			if(m.find())
				pw.println("<h1> Your email is " + email + "</h1><br/>");
			else
				pw.println("<p style = 'color : red'>Please enter a valid email</p>");
				
			
			p = Pattern.compile("[7-9][0-9]{9}");
			m = p.matcher(no);
			
			if(m.find())
				pw.println("<h1> Your no is " + no + "</h1><br/>");
			else
				pw.println("<p style = 'color : red'>Please enter a valid number</p>");
		}
		
		else if(name == "")
			pw.println("<p style = 'color : red'>Please enter your name</p>");
		
		else if(email == "") 
			pw.println("<p style = 'color : red'>Please enter your email</p>");
		
		else if(no == "") 
			pw.println("<p style = 'color : red'>Please enter your number</p>");

		
	}
	
}
