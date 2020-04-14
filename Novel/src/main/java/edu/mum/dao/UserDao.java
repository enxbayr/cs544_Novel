package edu.mum.dao;

import java.util.List;

import edu.mum.domain.User;

public interface UserDao extends GenericDao<User> {

	public User findByUserNumber(Integer number);

	public List<User> findAllJoinFetch();

	// public List<User> findByGraph();
}
