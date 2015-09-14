package com.devstringx.pmt.web.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping("welcomeUser.htm")
	public ModelAndView welcomeUser(){
		ModelAndView mav=new ModelAndView();
		System.out.println("inside welcome user");

		return mav;
	}

	@RequestMapping(value="verifyUser/{code}.htm")
	@ResponseBody
	public void verifyUser(@PathVariable("code")String code,HttpServletResponse response){
		  
        try {
			response.getWriter().write("we recieved:"+code);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
			
	

}
