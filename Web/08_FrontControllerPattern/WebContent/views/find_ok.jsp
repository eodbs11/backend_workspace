<%@page import="src.com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 검색 결과</h1>
	<form action ="FindMemberServlet" method="post">
	<input type = "hidden" name = "command" value= "Find">
	<ul>
		<li>아이디 : ${member.id}</li>
		<li>이름 : ${member.name}</li>
		<li>비밀번호 : ${member.password}</li>
	</ul>
	<a href="index.jsp">첫 페이지로 이동</a>
	
	</form>
</body>
</html>