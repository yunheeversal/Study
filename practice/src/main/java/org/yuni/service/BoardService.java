package org.yuni.service;

import java.util.List;

import org.yuni.domain.BoardVO;

public interface BoardService {
	List<BoardVO> selectBoardList() throws Exception;
}
