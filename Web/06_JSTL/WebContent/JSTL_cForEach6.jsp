<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[]arr = {"삼계탕", "순두부찌개", "설렁탕", "김치찌개", "곰탕", "두루치기"};
		request.setAttribute("arr", arr);
	%>
	
	<%-- request.getRequestDispatcher("JST_cForEach_view.jsp")
						.forward(request, response); --%>
	<jsp:forward page="JSTL_cForEach6_view.jsp"/>
</body>
</html>