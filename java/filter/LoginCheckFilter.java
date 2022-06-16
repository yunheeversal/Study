package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("authUser") == null) {
			HttpServletResponse response = (HttpServletResponse)res;
			response.sendRedirect(request.getContextPath() + "/login.do"); // 세션이 없으면 로그인해라.
		} else {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	
	
	/*
	 * @Override public void init(FilterConfig config) throws ServletException { }
	 * 
	 * @Override public void doFilter(ServletRequest request, ServletResponse
	 * response, FilterChain chain) throws IOException, ServletException {
	 * HttpServletRequest req = (HttpServletRequest) request; HttpSession session =
	 * req.getSession(false);
	 * 
	 * boolean login = false; if (session != null) { if
	 * (session.getAttribute("MEMBER") != null) { // 세션에 member라는 attribute가 있냐
	 * login = true; } } if (login) { //login이 true가 되면 아래와 같이 실행 하라.
	 * chain.doFilter(request, response); } else { //RequestDispatcher dispatcher =
	 * request.getRequestDispatcher("/login.do"); //dispatcher.forward(request,
	 * response); HttpServletResponse res = (HttpServletResponse) response;
	 * res.sendRedirect(req.getContextPath()+"/login.do"); } }
	 * 
	 * @Override public void destroy() { }
	 */
}