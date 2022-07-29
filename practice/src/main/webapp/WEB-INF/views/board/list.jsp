<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table{
	width: 50%;
	border-top: 1px solid blue;
	border-collapse: collapse;

}

th, td{
	border-bottom: 1px solid blue;
	border-left: 1px solid blue;
	padding: 10px;
	text-align: center;
}
th:first-child, td:first-child{
	border-left:none;
}

table{
	background-color: #e3f2fd;
}

</style>

<title>게시판</title>
</head>
<body>
	<h1>게시판</h1>

	<table >
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>조회</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.num}</td>
					<td>${item.name}</td>
					<td>${item.title}</td>
					<td>${item.readCount}</td>
					<td>${item.writeDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>
