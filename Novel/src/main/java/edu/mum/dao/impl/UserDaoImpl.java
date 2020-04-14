package edu.mum.dao.impl;

import java.util.List;
import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class);
	}

	public User findByUserNumber(Integer number) {

		Query query = entityManager.createQuery("select m from User m  where m.userNumber =:number");
		return (User) query.setParameter("number", number).getSingleResult();

	}

	public List<User> findAllJoinFetch() {
		Query query = entityManager.createQuery("SELECT DISTINCT m FROM User AS m JOIN FETCH m.addresses AS a");
		return (List<User>) query.getResultList();

	}

//	public List<User> findByGraph() {
//
//		EntityGraph graph = entityManager.getEntityGraph("graph.User.addresses");
//
//		return (List<User>) this.findAll("javax.persistence.fetchgraph", graph);
//
//	}

}