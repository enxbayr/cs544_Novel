package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.service.UserCredentialsService;
import edu.mum.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

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
		return (List<User>) userDao.findAll();
	}

	public User findByUserNumber(Integer userId) {
		return userDao.findByUserNumber(userId);
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

	@Override
	public List<User> findByGraph() {
		return userDao.findByGraph();
	}

}
