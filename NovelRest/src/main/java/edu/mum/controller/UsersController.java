package edu.mum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.service.UserService;
import edu.mum.domain.User;

@RestController
@CrossOrigin
@RequestMapping({"/users"})
public class UsersController {
	
	@Autowired
	private UserService  memberService;

	@RequestMapping
	public List<User>  findAll( ) {
		List<User> memberList = memberService.findAll();
		return  memberList;
 
	}
	
  	@RequestMapping("/{id}")
	public User getMemberById(@PathVariable("id") Long id) {
		return   memberService.findOne(id);
 
	}
	   
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewMemberForm(@RequestBody User memberToBeAdded) {
		memberService.save(memberToBeAdded);
 
	}
	
 
}
