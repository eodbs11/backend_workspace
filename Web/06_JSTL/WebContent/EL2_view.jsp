<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. jsp 기본 태그로 받아오기</h2>
	<%=request.getParameter("id")%>

	<h2>2. EL로 받아오기</h2>
	- ${param.id}

	<h2>1. jsp 기본 태그로 받아오기</h2>
	<%
	String[] menus = request.getParameterValues("menu");
	for(String menu : menus) {
	%>
		- <%= menu %>
	
	<% } %>
	
	<h2>2. EL로 받아오기</h2>
	- ${paramValues.menu[0]}<br>
	- ${paramValues.menu[1]}<br>
	- ${paramValues.menu[2]}<br>
	

</body>
</html>