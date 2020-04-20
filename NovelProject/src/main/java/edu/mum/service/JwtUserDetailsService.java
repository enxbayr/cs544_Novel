package edu.mum.service;

import java.util.ArrayList;

import edu.mum.dao.UserCredentialsDao;
import edu.mum.domain.Address;
import edu.mum.domain.Member;
import edu.mum.domain.UserCredentials;
import edu.mum.domain.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private MemberService memberService;

	@Autowired
	private UserCredentialsDao credentialsDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

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
		newUser.setUserRole(UserRole.valueOf(user.getRole()));
		

		Member newMember = new Member();
		newMember.setFirstName(user.getFirstName());
		newMember.setLastName(user.getLastName());
		newMember.setEmail(user.getEmail());
		newMember.setMemberNumber(user.getMemberNumber());
		newMember.setUserCredentials(newUser);

		if (user.getBuildingNumber() != null) {
			Address adr = new Address();
			adr.setBuildingNumber(user.getBuildingNumber());
			adr.setRoomNumber(user.getRoomNumber());
			newMember.setAddress(adr);
		}

		memberService.save(newMember);
		return newUser;
	}
}