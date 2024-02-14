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
		int sum =0;
		for(int i=0; i<=50; i++){
			sum += i;
		}		
		request.setAttribute("result", sum);
		session.setAttribute("result", "session");
		request.getRequestDispatcher("EL1_view.jsp").forward(request, response);
	%>
</body>
</html>