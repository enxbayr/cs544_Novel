package edu.mum.service;

import java.util.List;

import edu.mum.domain.User;

public interface UserService {

	public void save(User user);

	public void update(User user);

	public void saveFull(User user);

	public List<User> findAll();

	public List<User> findAllAddress();

	public User findByUserNumber(Integer userId);

	public User findOne(Long id);

	public User findOneFull(Long id);

	public List<User> findAllJoinFetch();

	public List<User> findByGraph();

}
