package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Member;

public interface MemberDao extends GenericDao<Member> {

	public Member findByUserNumber(Integer number);

	public List<Member> findAllJoinFetch();

	public List<Member> findByGraph();

}
