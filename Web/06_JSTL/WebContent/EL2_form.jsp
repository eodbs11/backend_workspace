<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Form 값을 EL로 받아오기</h1>
	<form>
		<p>ID : <input type="text" name="id"></p>
		<h2>좋아하는 메뉴</h2>
		<input type ="checkbox" name="menu" value="pasta">파스타
		<input type ="checkbox" name="menu" value="curry">카레
		<input type ="checkbox" name="menu" value="noodle">국수
		
		<p><input type ="submit" value="데이터 전송"></p>
	</form>
</body>
</html>