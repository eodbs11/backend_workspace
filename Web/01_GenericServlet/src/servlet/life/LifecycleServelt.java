package servlet.life;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifecycleServelt")
public class LifecycleServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifecycleServelt() {
		System.out.println("LifecycleServlet 생성자 호출..");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출..");
	}

	public void destroy() {
		System.out.println("destroy 호출..");
	}

	// 1. service에 구현
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("service 호출..");
//	}

	// 2. doGet에 구현
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet 호출..");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost 호출..");
		doGet(request,response);
	}

}
