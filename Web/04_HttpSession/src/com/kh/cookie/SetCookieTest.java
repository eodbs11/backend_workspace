package com.kh.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetCookieTest")
public class SetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 요청이 들어왔을 때
		 * 1. 쿠키 생성
		 * 2. 생성한 쿠키를 웹 브라우저로 보냄
		 * */
		// 1. 쿠키 생성
		Date now = new Date();
		Cookie c1 = new Cookie("time", Long.toString(now.getTime()));
		Cookie c2 = new Cookie("id", "test");
		
		// 2. 쿠키의 유효시간을 지정
		c1.setMaxAge(20); // 20초
		c2.setMaxAge(60*60*24); // 하루
		
		// 3. 쿠키 전송
		response.addCookie(c1);
		response.addCookie(c2);
		
		// 4. 페이지 이동
		response.sendRedirect("GetCookieTest");
	}

}
