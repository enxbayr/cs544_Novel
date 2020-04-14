package edu.mum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.service.UserService;
import edu.mum.domain.User;

@RestController
@RequestMapping({ "/users" })
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("")
	public List<User> findAll() {
		List<User> userList = userService.findAll();
		return userList;

	}

	@RequestMapping("addresses")
	public List<User> findAllAddress() {
		List<User> userList = userService.findAllAddress();
		return userList;

	}

	@RequestMapping("/{id}")
	public User getMemberById(@PathVariable("id") Long id) {
		return userService.findOne(id);

	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewMemberForm(@RequestBody User memberToBeAdded) {
		userService.save(memberToBeAdded);

	}

}
