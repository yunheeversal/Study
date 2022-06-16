package member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class GuestbookHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		return "/WEB-INF/view/guestbook/list.jsp";
		// 이 페이지로 포워딩 한다. 
	}

}
