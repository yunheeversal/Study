package org.yuni.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yuni.domain.BoardVO;
import org.yuni.mapper.BoardMapper;
import org.yuni.domain.Criteria;
import org.yuni.domain.SearchCriteria;

@Service
//@Configuration
//@MapperScan("org.yuni.mapper")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;

	
	 @Override
	  public void create(BoardVO vo) throws Exception {
	    boardMapper.create(vo);
	  }

	  @Override
	  public BoardVO read(Integer bno) throws Exception {
	    return boardMapper.read(bno);
	  }

	  @Override
	  public void update(BoardVO vo) throws Exception {
	    boardMapper.update(vo);
	  }

	  @Override
	  public void delete(Integer bno) throws Exception {
	    boardMapper.delete(bno);
	  }

	  @Override
	  public List<BoardVO> listAll() throws Exception {
	    return boardMapper.listAll();
	  }

	  @Override
	  public List<BoardVO> listPage(int page) throws Exception {

	    if (page <= 0) {
	      page = 1;
	    }

	    page = (page - 1) * 10;

	    return boardMapper.listPage(page);
	  }

	  @Override
	  public List<BoardVO> listCriteria(Criteria cri) throws Exception {

	    return boardMapper.listCriteria(cri);
	  }

	  @Override
	  public int countPaging(Criteria cri) throws Exception {

	    return boardMapper.countPaging(cri);
	  }

	  @Override
	  public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {

	    return boardMapper.listSearch(cri);
	  }

	  @Override
	  public int listSearchCount(SearchCriteria cri) throws Exception {

	    return boardMapper.listSearchCount(cri);
	  }

	  @Override
	  public void updateReplyCnt(Integer bno, int amount) throws Exception {

			/*
			 * Map<String, Object> paramMap = new HashMap<String, Object>();
			 * 
			 * paramMap.put("bno", bno); paramMap.put("amount", amount);
			 */

	    boardMapper.updateReplyCnt(bno, amount);
	  }

	  @Override
	  public void updateViewCnt(Integer bno) throws Exception {
	    
	    boardMapper.updateViewCnt(bno);
	    
	  }


	  @Override
	  public void addAttach(String fullName) throws Exception {
	    
	    boardMapper.addAttach(fullName);
	    
	  }
	  
	  @Override
	  public List<String> getAttach(Integer bno) throws Exception {
	    
	    return boardMapper.getAttach(bno);
	  }
	 

	  @Override
	  public void deleteAttach(Integer bno) throws Exception {

	    boardMapper.deleteAttach(bno);
	    
	  }

	  @Override
	  public void replaceAttach(String fullName, Integer bno) throws Exception {
			/*
			 * Map<String, Object> paramMap = new HashMap<String, Object>();
			 * 
			 * paramMap.put("bno", bno); paramMap.put("fullName", fullName);
			 */
	    
	    boardMapper.replaceAttach(fullName, bno);
	    
	  }
	

}
