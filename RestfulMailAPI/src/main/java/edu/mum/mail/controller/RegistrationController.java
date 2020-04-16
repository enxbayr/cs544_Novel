package edu.mum.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.mail.model.MailUser;
import edu.mum.mail.service.MailService;

@RestController
public class RegistrationController {

	@Autowired
	private MailService notificationService;

	@RequestMapping("/sendmail")
	public void send(@RequestBody MailUser user) {

		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
	}
}
