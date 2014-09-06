package com.devstringx.pmt.mail;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.devstringx.pmt.utils.ApplicationUtilities;


public class PmtEmailService {

	private JavaMailSenderImpl mailSender;
	private VelocityEngine velocityEngine;

	public JavaMailSenderImpl getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	
	
	public void sendRegistrationEmail(String emailId,String userName){
		
		String templateLocation="template/registrationTemplate.vm";
		if(ApplicationUtilities.isEmailServiceEnabled()) {
			//logger.info("Sending end session email....");
			
			
			String verficationURL=ApplicationUtilities.getCustomProperty("serverBaseURL", null)+"user/verifyUser/"+ApplicationUtilities.getHashValue(userName)+ApplicationUtilities.getHashValue(emailId)+".htm";
			try {
				Map<String, Object> model=new HashMap<String, Object>();
				model.put("verficationURL", verficationURL);
                model.put("userName", userName);
            				final String text=   VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateLocation, "UTF-8", model);
                    MimeMessagePreparator messagePreparator=prepareMessageForEmail(text, "Welcome to defect management system ", emailId);

				
					this.mailSender.send(messagePreparator);
				//	logger.info("Email: end session details sent successfully");
			}catch(Throwable e){
				e.printStackTrace();
               //TabkidsException.logStackTraceToFile("Error in sending end session mail ", e);
 			}
		}else {
			System.out.println("Email service disabled");
		}
		
	}
	
public MimeMessagePreparator prepareMessageForEmail(final String emailText,final String emailSubject ,final String mailTo){
		
		MimeMessagePreparator messagePreparator=new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage arg0) throws Exception {

				MimeMessageHelper messageHelper=new MimeMessageHelper(arg0);
				messageHelper.setFrom(ApplicationUtilities.getCustomProperty("mail.from", "Defect@team"));
				messageHelper.setTo(mailTo);
				messageHelper.setText(emailText,true);
				messageHelper.setSubject(emailSubject);
			}
		};
		
		return messagePreparator;
	}

	

}
