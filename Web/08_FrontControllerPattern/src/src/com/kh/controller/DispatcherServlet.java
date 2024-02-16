package src.com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.com.kh.model.dao.MemberDAO;
import src.com.kh.model.vo.Member;

@WebServlet("/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청이 어디에서 들어오는 요청인지 구분할 command 값 같이 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		
			try {
				if (command.equals("register")) {
				path = register(request, response);
			} else if(command.equals("login")) {
				path = login(request, response);
			} else if(command.equals("search")) {
				path = search(request, response);
			} else if(command.equals("allshow")) {
				path = allshow(request, response);
			} else if(command.equals("logout")) {
				path = logout(request, response);
			}
				
				catch (SQLException e) {
			
				
			}
				
				

			}
	}

	// 네비게이션
	request.getRequestDispatcher(path).forward(request,response);

	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 폼값 받는다
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DAO
		MemberDAO dao = new MemberDAO();try
		{
			Member member = dao.login(id, password);

			// 3. 바인딩 - session
			HttpSession session = request.getSession();
			session.setAttribute("member", member);

			// 4. 네비게이션
			return "index.jsp";
		}catch(
		SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	protected String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		// 1. 폼값 받는다
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, pwd, name);

		dao.registerMember(member);

		return "index.jsp";
	}

	
}
}
}


