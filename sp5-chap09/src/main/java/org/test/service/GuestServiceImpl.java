package org.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.domain.GuestVO;
import org.test.mapper.GuestMapper;

@Service

public class GuestServiceImpl implements GuestService {

	@Autowired
	private GuestMapper mapper;
	
	/*
	@Override
	public GuestVO read(String userName) throws Exception {
		return mapper.read(userName);
	}
	*/

	@Override
	public List<GuestVO> list() throws Exception {
		return mapper.list();
	}

}
