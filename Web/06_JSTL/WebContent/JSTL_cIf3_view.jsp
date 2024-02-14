<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.num== '1' }">
		<h2>1값이 들어왔습니다</h2>
	</c:if>
	<c:if test="${param.num== '1' }">
		<h2>1값이 들어오지 않았습니다</h2>
	</c:if>

</body>
</html>