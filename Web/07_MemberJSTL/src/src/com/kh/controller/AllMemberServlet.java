package src.com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.kh.model.dao.MemberDAO;
import src.com.kh.model.vo.Member;

@WebServlet("/AllMemberServlet")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 2. DAO
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;
		
		try {
			list = dao.allShowMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 3. 바인딩
		request.setAttribute("list", list);
		
		// 4. 내비게이션
		request.getRequestDispatcher("views/allshow.jsp").forward(request, response);
	}

}
