package org.yuni.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yuni.domain.BoardVO;
import org.yuni.domain.PageMaker;
import org.yuni.domain.SearchCriteria;
import org.yuni.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	// 게시물 목록 확인
	@RequestMapping(value = "/list")
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		   logger.info(cri.toString());

		    // model.addAttribute("list", service.listCriteria(cri));
		    model.addAttribute("list", service.listSearch(cri));

		    PageMaker pageMaker = new PageMaker();
		    pageMaker.setCri(cri);

		    // pageMaker.setTotalCount(service.listCountCriteria(cri));
		    pageMaker.setTotalCount(service.listSearchCount(cri));

		    model.addAttribute("pageMaker", pageMaker);
		
	}
	
	// 특정 번호의 게시물을 조회
	 @RequestMapping(value = "/readPage", method = RequestMethod.GET)
	  public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model)
	      throws Exception {

	    model.addAttribute(service.read(bno));
	  }

	 // 게시물 삭제
	  @RequestMapping(value = "/removePage", method = RequestMethod.POST)
	  public String remove(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

	    service.delete(bno);

	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addAttribute("searchType", cri.getSearchType());
	    rttr.addAttribute("keyword", cri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/board/list";
	  }

	  // 게시물 수정 화면으로 이동
	  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	  public void modifyPagingGET(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

	    model.addAttribute(service.read(bno));
	  }

	  // 게시물 수정
	  @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	  public String modifyPagingPOST(BoardVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

	    logger.info(cri.toString());
	    service.update(board);

	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addAttribute("searchType", cri.getSearchType());
	    rttr.addAttribute("keyword", cri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    logger.info(rttr.toString());

	    return "redirect:/board/list";
	  }

	  // 게시물 등록 페이지 
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public void registGET() throws Exception {

	    logger.info("regist get ...........");
	  }

	  // 게시물 실제로 등록
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

	    logger.info("regist post ...........");
	    logger.info(board.toString());

	    service.create(board);

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    return "redirect:/board/list";
	  }
	  
	  
	  @RequestMapping("/getAttach/{bno}")
	  @ResponseBody
	  public List<String> getAttach(@PathVariable("bno")Integer bno)throws Exception{
	    
	    return service.getAttach(bno);
	  }  
	
	

}
