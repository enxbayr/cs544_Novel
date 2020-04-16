package edu.mum.utils;

import org.springframework.web.client.RestTemplate;

import edu.mum.domain.MailUser;

public class MailSender {

	public static void mailSender(MailUser user) {
		
		RestTemplate restTemplate = new RestTemplate();

		final String uri = "http://localhost:8085/RestfulMailApi/sendmail";

		MailUser reciever = restTemplate.postForObject(uri, user, MailUser.class);
		System.out.println("Email has been sent to: " + reciever.getFirstName());
	}
}
