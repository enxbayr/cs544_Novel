package edu.mum.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityGraph;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Member;

@SuppressWarnings("unchecked")
@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao {

	public MemberDaoImpl() {
		super.setDaoType(Member.class);
	}

	public Member findByUserNumber(Integer number) {

		Query query = entityManager.createQuery("select m from User m  where m.userNumber =:number");
		return (Member) query.setParameter("number", number).getSingleResult();

	}

	public List<Member> findAllJoinFetch() {
		Query query = entityManager.createQuery("SELECT DISTINCT m FROM User AS m JOIN FETCH m.addresses AS a");
		return (List<Member>) query.getResultList();

	}

	public List<Member> findByGraph() {

		EntityGraph graph = entityManager.getEntityGraph("graph.User.addresses");

		return (List<Member>) this.findAll("javax.persistence.fetchgraph", graph);

	}

	@Override
	public Member findByUserName(String uname) {

		Query query = entityManager.createQuery("select m from User m , CREDENTIALS c  where c.username =:userName");
		return (Member) query.setParameter("userName", uname).getSingleResult();

	}

}