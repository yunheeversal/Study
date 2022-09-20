<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<html>
<head>
<style>

/* 테이블 css */
table{
	width: 50%;
	border: 1px solid #444444;
	text-align: center;
}
 th{
    border: 1px solid #444444;

  }
td{
    border: 1px solid #444444;
    text-align: left;
  }
</style>

<title>전자 방명록</title>
</head>
<body style="background-color:#F7F8E0">
	<h1>전자 방명록</h1>

	<table >
		<c:if test="${! empty list}">
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>주소</th>
				<th>개인정보<br/>이용 제공<br/>동의 여부</th>

			</tr>
			<c:forEach items="${list}" var="list">
				<tr>
					<td><c:out value="${list.userName}" /></td>
					<td><c:out value="${list.userAge}" /></td>
					<td><c:out value="${list.address}" /></td>
					<td><input type="checkbox" name="agree"
						<c:if test="${list.agree eq 1}">checked</c:if>></td>
				</tr>
			</c:forEach>
		</c:if>

	</table>


</body>
</html>
