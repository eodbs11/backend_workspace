<%@page import="src.com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty member}">
			<h1>로그인 정보</h1>
			<ul>
				<li>아이디 : ${member.id}</li>
				<li>이름 : ${member.name}</li>
				<li>비밀번호 : ${member.password}</li>
			</ul>
			<a href="/index.jsp">첫 페이지로 이동</a>
		</c:when>
		<c:otherwise>
			<h2>로그인 실패..! 다시 로그인 해주세요</h2>
			<a href="login.html">로그인 페이지로 이동</a>
		</c:otherwise>
	</c:choose>
</body>
</html>