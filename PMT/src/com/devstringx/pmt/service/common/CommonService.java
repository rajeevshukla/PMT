package com.devstringx.pmt.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.devstringx.pmt.mail.PmtEmailService;

@Service
public class CommonService {

	
	@Qualifier("pmtEmailService")
	@Autowired
	PmtEmailService emailService;
	
	
	 public void registerNewUser(String userName,String emailId){

		 System.out.println("registering..");
		 emailService.sendRegistrationEmail(emailId, userName);
	 
	 }
	
	
	
}
