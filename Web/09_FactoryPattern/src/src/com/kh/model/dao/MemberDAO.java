package src.com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import src.com.kh.model.vo.Member;


public class MemberDAO {

	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");	
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		close(ps, conn);
	}
	// DAO 개발할 때 중요한 건 
	// 매개변수(파라미터) 뭘 가지고 오는지, 리턴타입 결과 출력이 어떤게 필요한지
	
	// 회원가입
	public int registerMember(Member member) throws SQLException {
		Connection conn = getConnect();
		
		String query = "INSERT INTO member VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, member.getId());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getName());
		
		int result = ps.executeUpdate();
		close(ps, conn);
		
		return result;
	}
	
	// 로그인
	public Member login(String id, String password) throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM member WHERE id=? AND password=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		Member member = null;
		
		if(rs.next()) {
			member = new Member(rs.getString("id"), 
					rs.getString("password"), 
					rs.getString("name"));
		}
		
		close(rs, ps, conn);
		
		return member;
	}
	
	// 회원검색
	public Member findMember(String id) throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM member WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		Member member = null;
		
		if(rs.next()) {
			member = new Member(rs.getString("id"), 
					rs.getString("password"), 
					rs.getString("name"));
		}
		
		close(rs, ps, conn);
		
		return member;
	}
	
	// 전체회원보기
	public ArrayList<Member> allShowMember() throws SQLException {
		Connection conn = getConnect();
		
		String query = "SELECT * FROM member";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Member> list = new ArrayList<>();
		
		while(rs.next()) {
			list.add(new Member(rs.getString("id"), 
					rs.getString("password"), 
					rs.getString("name")));
		}
		
		return list;
	}
	
	
	
	

}