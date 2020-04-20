package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.MemberDao;
import edu.mum.domain.Member;
import edu.mum.service.AddressService;
import edu.mum.service.MemberService;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Autowired
	UserCredentialsService credentialsService;

	@Autowired
	AddressService addressService;

	public void save(Member member) {
		memberDao.save(member);
	}

	public void update(Member member) {
		memberDao.save(member);
	}

	public List<Member> findAll() {
		return (List<Member>) memberDao.findAll();
	}

	public Member findOne(Long id) {
		return memberDao.findOne(id);
	}

	public Member findOneFull(Long id) {
		Member member = this.findOne(id);

//// OR 		"SELECT p FROM User m JOIN FETCH m.userCredentials WHERE m.id = (:id)"
		member.getUserCredentials();

		return member;
	}

	@Override
	public Member findByMemberNumber(Integer memberId) {
		return memberDao.findByUserNumber(memberId);
	}

	@Override
	public Member findByUserName(String uname) {
		return memberDao.findByUserName(uname);
	}
}
