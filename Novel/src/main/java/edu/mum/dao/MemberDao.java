package edu.mum.dao;

import java.util.List;
import java.util.Set;

import edu.mum.domain.User;

public interface MemberDao extends GenericDao<User> {
      
	public User findByMemberNumber(Integer number);
	public List<User> findAllJoinFetch();
	public List<User> findByGraph();
	}
