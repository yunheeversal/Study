package filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class NullParameterFilter implements Filter {

    private String[] parameterNames = null;

    @Override
    public void init(FilterConfig config) throws ServletException {
        String names = config.getInitParameter("parameterNames");// "id,name"
        StringTokenizer st = new StringTokenizer(names, ", "); // ,로 나눔.
        parameterNames = new String[st.countTokens()]; // String배열 2개가 됨.

        for (int i = 0; st.hasMoreTokens(); i++) {
            parameterNames[i] = st.nextToken(); 
            // parameterNames[0]="id",parameterNames[1]="name"
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        NullParameterRequestWrapper requestWrapper = 
            new NullParameterRequestWrapper((HttpServletRequest) request);
        requestWrapper.checkNull(parameterNames);
        // parameterNames: id와 name이 들어 있는 String 배열 
        // null인지 아닌지 체크.... null이면 공백이 values로 들어가게..

        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {
    }
}