package edu.mum.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

	@RequestMapping("/user/me")
	public Principal user(Principal principal) {
		System.out.println(principal);
		return principal;
	}
}
