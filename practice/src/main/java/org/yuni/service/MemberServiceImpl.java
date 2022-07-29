package org.yuni.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yuni.domain.MemberVO;
import org.yuni.dto.LoginDTO;
import org.yuni.mapper.MemberMapper;

@Service
//@Configuration
//@MapperScan("org.yuni.mapper")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		
		return memberMapper.login(dto);
	}
	
	  @Override
	  public void keepLogin(String userId, String sessionId, Date next)
	      throws Exception {
	    
		  memberMapper.keepLogin(userId, sessionId, next);
	    
	  }

	@Override
	public void create(MemberVO member) throws Exception {
		memberMapper.create(member);
		
	}

	@Override
	public void update(MemberVO member) throws Exception {
		memberMapper.update(member);
		
	}

	@Override
	public MemberVO selectOne(String userId) throws Exception {
		
		return memberMapper.selectOne(userId);
	}
	  
	  

}
