package org.yuni.mapper;

import java.util.List;

import org.yuni.domain.BoardVO;

public interface BoardMapper {
	List<BoardVO> selectBoardList() throws Exception;
}
