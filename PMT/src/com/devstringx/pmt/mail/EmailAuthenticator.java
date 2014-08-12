package com.devstringx.pmt.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailAuthenticator  extends Authenticator {

	private String userName;
	private String password;

	public EmailAuthenticator(String userName,String password) {
		this.userName=userName;
		this.password=password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return  new PasswordAuthentication(userName, password);

	}


}
