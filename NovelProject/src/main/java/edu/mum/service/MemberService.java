package edu.mum.service;

import java.util.List;

import edu.mum.domain.Member;

public interface MemberService {

	public void save(Member member);

	public void update(Member member);

	public Member saveFull(Member member);

	public List<Member> findAll();

	public Member findByMemberNumber(Integer userId);

	public Member findOne(Long id);

	public Member findOneFull(Long id);

	public Member findByUserName(String uname);

}
