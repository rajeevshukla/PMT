package com.devstringx.pmt.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
	
	
	@RequestMapping(value="login.htm")
	public ModelAndView getLoginPage(){
		ModelAndView  mav=new  ModelAndView("security/login");
		
		
		return mav;
	}
	
	
	@RequestMapping(value="getRegisterPage.htm")
	public ModelAndView getRegisterPage(){
		ModelAndView  mav=new  ModelAndView("security/registerPage");
	
		
		return mav;
	}
	

}
