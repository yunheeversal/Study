package org.yuni.mapper;

import java.util.Date;

import org.yuni.domain.MemberVO;
import org.yuni.dto.LoginDTO;

public interface MemberMapper {
	public MemberVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String userId, String sessionId, Date next);

	public void create(MemberVO member) throws Exception;

	public void update(MemberVO member) throws Exception;

	public MemberVO selectOne(String userId) throws Exception;
}
