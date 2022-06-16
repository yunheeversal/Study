package jdbc;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

// servlet 클래스: http 통신을 할 수 있는 클래스
public class MySQLDriverLoader extends HttpServlet {

	//log 하면 자동으로 실행???
    public void init(ServletConfig config) throws ServletException {
        try {
        	// JDBC 드라이버를 메모리에 로딩한다. 
            Class.forName("com.mysql.jdbc.Driver");
        } catch(Exception ex) {
            throw new ServletException(ex);
        }
    }
}
