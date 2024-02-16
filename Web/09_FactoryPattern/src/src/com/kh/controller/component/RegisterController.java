package src.com.kh.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.kh.controller.Controller;
import src.com.kh.controller.ModelAndView;
import src.com.kh.model.dao.MemberDAO;
import src.com.kh.model.vo.Member;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		// 1. 폼값 받는다
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");

		// 2. DAO
		MemberDAO dao = new MemberDAO();
		Member member = new Member(id, pwd, name);
		dao.registerMember(member);
		
		return new ModelAndView("index.jsp", true);
	}
	
}
