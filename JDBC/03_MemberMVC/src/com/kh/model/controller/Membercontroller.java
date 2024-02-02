package com.kh.model.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

public class Membercontroller {

	public static void main(String[] args) {
		try {
			// 1. 드라이버 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 고정적인 반복 - DB 연결, 자원 반납 -> 공통적인 메서드 정의.. 메서드마다 호출해서 사용!

	// DB 연결

	public Connection getConnect() throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
		return conn;
	}

	// 자원 반납
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	public boolean signUp(Member m) {
		// 회원가입 기능 구현!
		// -> member 테이블에 데이터 추가 (INSERT)
		// --> 로그인 기능 구현이 먼저 되어야 함
		// 로그인 결과 값이 null이 아닌 경우만 구현 그게 아닐 떄는 false만 리턴
		return false;
	}

	public String login(String id, String password) {
		// 로그인 기능 구현!
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기 (select)
		return null;
	}

	public boolean changePassword(String id, String oldPw, String newPw) {
		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 해당 UPDATE문 구현!
		// -> member 테이블에서 id로 새로운 패스워드로 변경(UPDATE)
		return false;
	}

	public void changeName(String id, String changeName) {
		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경 (UPDATE)
	}

}
