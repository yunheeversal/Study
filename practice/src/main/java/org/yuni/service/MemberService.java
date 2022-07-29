package org.yuni.service;

import java.util.Date;
import java.util.List;

import org.yuni.domain.MemberVO;
import org.yuni.dto.LoginDTO;

public interface MemberService {
	public MemberVO login(LoginDTO dto) throws Exception;

	public void keepLogin(String userId, String sessionId, Date next) throws Exception;

	public void create(MemberVO member) throws Exception;

	public void update(MemberVO member) throws Exception;

	public MemberVO selectOne(String userId) throws Exception;

}
