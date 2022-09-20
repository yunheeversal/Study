package org.test.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.test.domain.GuestVO;
import org.test.service.GuestService;

@Controller
@RequestMapping(value = "/sp5-chap09/*")
public class GuestController {
	private static final Logger logger = LoggerFactory.getLogger(GuestController.class);
	
	@Inject
	  private GuestService service;
	
	  @RequestMapping(value = "/hello", method = RequestMethod.GET)
	  public void  hello(@RequestParam("userName") String userName, Model model) throws Exception {
		  
		  model.addAttribute("userName", userName);
	  }

		
		  @RequestMapping(value = "/guest", method = RequestMethod.GET) 
		  public void	guest(Model model) throws Exception {
			  logger.info("show all list........");
			  model.addAttribute("list", service.list());
		  
		  }
		 
	
}
