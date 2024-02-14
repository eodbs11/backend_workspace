package src.com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.kh.model.dao.MemberDAO;
import src.com.kh.model.vo.Member;

@WebServlet("/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 폼값받는다
		String id = request.getParameter("id");
		// 2. DAO
		MemberDAO dao = new MemberDAO();
		try {
			Member member = dao.findMember(id);
			if(member!=null) {
				// 3. 바인딩
				request.setAttribute("member", member);
				request.getRequestDispatcher("views/find_ok.jsp").forward(request, response);
			}else {
				response.sendRedirect("views/find_fail.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
