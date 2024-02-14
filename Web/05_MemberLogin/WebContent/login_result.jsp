<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>

	<from action="/LoginServlet" method="">
		// 로그인 : 아이디, 비밀번호 입력 받아서
		// -> LoginServlet / post 방식
		<label>아이디 : <input type="text" name="id"></label><br> <label>비밀번호
				: <input type="password" name="pwd">
			</label><br> <label>이름 : <input type="text" name="name"></label><br>
			<input type="submit" value="회원가입">
	</from>
</body>
</html>