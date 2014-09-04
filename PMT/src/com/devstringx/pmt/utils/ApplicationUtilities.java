package com.devstringx.pmt.utils;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class ApplicationUtilities {


	public boolean checkIfEmailIsValid(String emailId){
		
		return false;
	}
	
	public boolean checkIfMobileNumberIsValid(String mobileNumber){
		
		return false;
	}
	
	public static String getHashValue(String param) {
		ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);
		return passwordEncoder.encodePassword(param, null);
	}

	
}
