<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=request.getParameter("addr")%>에 사는
		<%=request.getParameter("age")%>세인
		<%=request.getParameter("name")%>가입 완료! </h1>
</body>
</html>