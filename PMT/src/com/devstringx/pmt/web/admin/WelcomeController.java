package com.devstringx.pmt.web.admin;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;

@Controller
public class WelcomeController {

	
	@PostConstruct
	public void bootLoader(){
		System.out.println("this method is called.");
	}
}
