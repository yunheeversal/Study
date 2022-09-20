package org.test.mapper;

import java.util.List;

import org.test.domain.GuestVO;

public interface GuestMapper {

	/*
	  public GuestVO read(String userName) throws Exception;
	  */
	  public List<GuestVO> list() throws Exception;
}
