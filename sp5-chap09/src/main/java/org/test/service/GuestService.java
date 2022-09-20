package org.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.test.domain.GuestVO;
@Service
public interface GuestService {
	
	/*
	  public GuestVO read(String userName) throws Exception;
	  */
	
	  public List<GuestVO> list() throws Exception;
}
