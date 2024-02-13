package com.kh.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Member;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 폼값 받아온다
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// DAO 생략.. 로그인 성공했다 가정!
		
		Member member = new Member(id, password, "테스트");
		
		// HttpSession
		// 1) 세션을 하나 받아온다
		HttpSession session = request.getSession();
		
		// 2) 세션에 바인딩
		session.setAttribute("info", member);
		
		// 2. 네비게이션
		response.sendRedirect("ProductServlet");
	}

}
