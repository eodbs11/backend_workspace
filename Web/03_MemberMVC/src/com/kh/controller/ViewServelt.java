package com.kh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/view")
public class ViewServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		// 1. DAO 리턴 받기
		// dao.showAllMember() : ArrayList<Member> <-- list로 담아서
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;
		try {
			list = dao.showAllMember();
		} catch (Exception e) {
			
		}		
		
		// 2. 바인딩 : list 전체
		request.setAttribute("list", list);
		
		// 3. 네비게이션 : view.jsp
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
