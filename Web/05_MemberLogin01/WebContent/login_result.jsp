<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 완료</h1>
	<%
	String name = (String) request.getAttribute("name");
	%>
	<h1><%=name%>님, 환영합니다!
	</h1>
</body>
</html>