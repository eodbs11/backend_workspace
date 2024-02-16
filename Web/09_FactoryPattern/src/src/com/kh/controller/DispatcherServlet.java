package src.com.kh.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;

import src.com.kh.model.dao.MemberDAO;
import src.com.kh.model.vo.Member;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// hidden값으로 들어온 요청을 받지 않고,
		// 들어온 요청의 주소를 직접 인식 시킨다.
		String requestURI = request.getRequestURI();
		System.out.println("RequestURI :: " + request.getRequestURI());
		
		String[] requestURIList = requestURI.split("/");
		System.out.println("RequestURIList :: " + Arrays.toString(requestURIList));
		
		// 사용자가 어떤 기능을 요구하는지 받는 주문서
		String command = requestURIList[requestURIList.length -1];		
		
		// 주문한 것에 따라 기능이 들어간 컨트롤러 생성
		Controller controller = HandlerMapping handle = HandlerMapping.getInstance().createController(command);
		try {		
			// 각 컴포넌트의 비즈니스 로직 실행!
			ModelAndView mv = controller.handle(request, response);
			
			if(mv!=null) {
				if(mv.isRedirect()) {
					response.sendRedirect(mv.getPath());
				}else {
					request.getRequestDispatcher(mv.getPath()).forward(request, response);
				}
			}
		}catch(Exception e){}
		
		// 요청이 어디에서 들어오는 요청인지 구분할 command 값 같이 받는다.
       
		
		
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

	protected void service1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 폼값 받는다
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		try {
			Member member = dao.login(id, password);

			// 3. 바인딩 - session
			HttpSession session = request.getSession();
			session.setAttribute("member", member);

			// 4. 네비게이션
			return "index.jsp";
		} catch (SQLException e) {
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
	
	protected String register(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
	}
	

}}
