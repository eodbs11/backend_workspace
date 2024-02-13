package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/Search")
public class Searchservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 폼 값 받는다
		String name = request.getParameter("name");

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = null;
		try {
			member = dao.searchMember(name);
		} catch (Exception e) {

		}

		// 2. 바인딩
		request.setAttribute("info", member);

		// 3. 네비게이션(만약에 멤버 정보가 없으면..이라는 것 추가!)
		if (member != null) {
			request.getRequestDispatcher("search.jsp").forward(request, response);
		} else {
			response.sendRedirect("fail.jsp");
		}
	}

}
