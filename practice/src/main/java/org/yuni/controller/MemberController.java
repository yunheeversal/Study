package org.yuni.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yuni.domain.MemberVO;
import org.yuni.dto.LoginDTO;
import org.yuni.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Inject
	private MemberService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		logger.info("// /member/login");
		
		

		//model.addAttribute("list", list);
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	  public String loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		MemberVO memberVO = service.login(dto);
		if (memberVO == null) {
			return "redirect:/member/login";
		}
		model.addAttribute("member", memberVO);
		return "/member/loginPost";
	  }
	
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	  public String logout(HttpServletRequest request, 
	      HttpServletResponse response, HttpSession session, RedirectAttributes rttr) throws Exception {

	    Object obj = session.getAttribute("login");

	    if (obj != null) {
	      MemberVO vo = (MemberVO) obj;

	      session.removeAttribute("login");
	      session.invalidate();
			
	    }
	    
	    return "redirect:/member/logout";
	  }
	 
	 
	 @RequestMapping(value = "/modify", method = RequestMethod.GET)
		public void modify(@RequestParam("userId") String userId, Model model) throws Exception {
		 MemberVO memberVO = service.selectOne(userId);
			model.addAttribute("vo", memberVO);
		}

		@RequestMapping(value = "/modify", method = RequestMethod.POST)
		public String modify(MemberVO vo, RedirectAttributes rttr) throws Exception {
			service.update(vo);
			rttr.addFlashAttribute("vo", vo);
			
			return "redirect:/member/loginPost";
		}

		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public void register() {

		}

		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public String register(MemberVO member) throws Exception {
			service.create(member);
			return "redirect:/member/login";
		}
		
		
	 
}
