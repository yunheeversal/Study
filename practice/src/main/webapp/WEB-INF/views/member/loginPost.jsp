<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	 <h3>환영합니다. ${member.userName}(${member.userId}). </h3>
	 <a href="/member/login">로그 아웃</a> 
	 <br/>
	 <a href="/member/modify?userId=${member.userId}">회원 정보 변경</a>
	
</body>
</html>

