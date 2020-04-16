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

	@Autowired
	private MemberService memberService;

	@Autowired
	private UserCredentialsDao credentialsDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		DAOUser user = userDao.findByUsername(username);
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				new ArrayList<>());
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredentials user = credentialsDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public UserCredentials save(UserDTO user) {

		UserCredentials newUser = new UserCredentials();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));

		Address adr = new Address();
		adr.setBuildingNumber(user.getBuildingNumber());
		adr.setRoomNumber(user.getRoomNumber());

		Member newMember = new Member();
		newMember.setFirstName(user.getFirstName());
		newMember.setLastName(user.getLastName());
		newMember.setEmail(user.getEmail());
		newMember.setMemberNumber(user.getMemberNumber());
		newMember.setUserCredentials(newUser);
		newMember.setAddress(adr);

		memberService.saveFull(newMember);

		return newUser;

	}

//	public DAOUser save(UserDTO user) {
//		DAOUser newUser = new DAOUser();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		return userDao.save(newUser);
//	}
}