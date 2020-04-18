package edu.mum.service;

import java.util.ArrayList;

import edu.mum.dao.MemberDao;
import edu.mum.dao.UserCredentialsDao;
import edu.mum.dao.UserDao;
import edu.mum.domain.Address;
import edu.mum.domain.Member;
import edu.mum.domain.UserCredentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.model.DAOUser;
import edu.mum.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {

//	@Autowired
//	private UserDao userDao;

//	@Autowired
//	private MemberService memberService;

	@Autowired
	private UserDao credentialsDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = credentialsDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserCredentials user = credentialsDao.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				new ArrayList<>());
//	}

	

	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return credentialsDao.save(newUser);
	}
}