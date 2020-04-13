package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.MemberDao;
import edu.mum.domain.User;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class MemberServiceImpl implements edu.mum.service.MemberService {
	
 	@Autowired
	private MemberDao memberDao;

 	@Autowired
 	UserCredentialsService credentialsService;

    public void save( User member) {  		
		memberDao.save(member);
	}
	
    public void update( User member) {  		
		memberDao.update(member);
	}
	
    @Override
   	public void saveFull( User member) {  		
  		credentialsService.save(member.getUserCredentials());
  		memberDao.save(member);
	}
  	
	public List<User> findAll() {
		List<User>  memberList = (List<User>)memberDao.findAll();
 		return memberList;
	}

	public List<User> findAllAddress() {
		List<User>  memberList = (List<User>)memberDao.findAll();
		for (User member : memberList) member.getAddresses().size();
		 
		return memberList;
	}

	public User findByMemberNumber(Integer memberId) {
		return memberDao.findByMemberNumber(memberId);
	}
 
	public User findOne(Long id) {
		return memberDao.findOne(id);
	}
	
	public User findOneFull(Long id) {
		User member = this.findOne(id);
		
// OR 		"SELECT p FROM Member m JOIN FETCH m.userCredentials WHERE m.id = (:id)"
		member.getUserCredentials();
		
		return  member;
	}
	
	public List<User> findAllJoinFetch() {
		return memberDao.findAllJoinFetch();
	}
	
 	@Override
	public List<User> findByGraph() {
		return  memberDao.findByGraph();
	}

}
