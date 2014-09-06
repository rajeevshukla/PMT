package com.devstringx.pmt.utils;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devstringx.pmt.mail.PmtEmailService;

@Component
public class BootLoader {

	@Autowired
	PmtEmailService pmtEmailService;

	
	@PostConstruct
	public void init(){

		System.out.println("Loading properties..");
		try {
			ApplicationMaps.PMT_PROPERTIES.load(this.getClass().getResourceAsStream("/config.properties"));

			System.out.println(ApplicationMaps.PMT_PROPERTIES);
			System.out.println("Sending email to user");
			//	pmtEmailService.sendRegistrationEmail("mail2rajeevshukla@gmail.com", "Rajeev Shukla");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
