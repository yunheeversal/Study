package filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

// HttpServletRequestWrapper을 상속 받은 클래스
// 필터가 요청(request)을 변경해서 그 결과를 저장하는 래퍼이다.
public class NullParameterRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String[]> parameterMap = null;
    // {"id":"hong","name":"홍길동","member":"user"} 

    public NullParameterRequestWrapper(HttpServletRequest request) {
        super(request);
        parameterMap = 
                new HashMap<String, String[]>(request.getParameterMap());
                // 객체를 HashMap으로 만들고, getParameterMap은 키와 값으로 즉 map으로 만들어 주는 메서드
    }

    public void checkNull(String[] parameterNames) {
        for (int i = 0; i < parameterNames.length; i++) {// id, name 두 번 돌림
            if (!parameterMap.containsKey(parameterNames[i])) { //id가 map에 있냐, name이 map에 있냐.
                String[] values = new String[] { "N/A" }; // 없으면 values에 공백을 집어 넣음.
                parameterMap.put(parameterNames[i], values); // name에 값이 없어도 자동으로 추가됨. 
            }
        }
    }

    @Override
    public String getParameter(String name) {
        String[] values = getParameterValues(name);
        if (values != null && values.length > 0)
            return values[0];
        return null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(parameterMap.keySet());
    }

    @Override
    public String[] getParameterValues(String name) {
        return (String[]) parameterMap.get(name);
    }

}
