package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional
public class UserServiceImpl implements edu.mum.service.UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	UserCredentialsService credentialsService;

	public void save(User user) {
		userDao.save(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void saveFull(User user) {
		credentialsService.save(user.getUserCredentials());
		userDao.save(user);
	}

	public List<User> findAll() {
		List<User> userList = (List<User>) userDao.findAll();
		return userList;
	}

	public List<User> findAllAddress() {
		List<User> userList = (List<User>) userDao.findAll();
		for (User user : userList)
			user.getAddresses().size();

		return userList;
	}

	public User findOne(Long id) {
		return userDao.findOne(id);
	}

	public User findOneFull(Long id) {
		User user = this.findOne(id);

// OR 		"SELECT p FROM User m JOIN FETCH m.userCredentials WHERE m.id = (:id)"
		user.getUserCredentials();

		return user;
	}

	public List<User> findAllJoinFetch() {
		return userDao.findAllJoinFetch();
	}

	/*
	 * @Override public List<User> findByGraph() { return userDao.findByGraph(); }
	 */

	@Override
	public User findByUserNumber(Integer userId) {
		return userDao.findByUserNumber(userId);
	}

}
