package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int count = 0;

	private String name;
	private String addr;

	public void init(ServletConfig config) throws ServletException {
		name = config.getInitParameter("name");
		addr = config.getInitParameter("addr");

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();

		pw.println("<h2>이름 : " + name + "</h2>");
		pw.println("<h2>주소 : " + addr + "</h2>");
		pw.println("<a href='config.jsp?name=" + name + "&count=" + ++count + "'>config.jsp로 이동</a>");

		pw.close();
	}

}
