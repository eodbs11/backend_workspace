package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.vo.Member;
import com.mysql.cj.PreparedQuery;

public class MemberDAO {

	
		public MemberDAO() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loading...!");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		}
		
		public Connection getConnect() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost:330/kh", "root" ,"1234");
		}
		
		public void close(PreparedStatement ps, Connection conn) throws SQLException {
			if(ps!=null)ps.close();
			if(conn!=null) conn.close();			
		}
		
		public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
			if(rs!=null)rs.close();
			close(ps, conn);			
		}
		
		public int registerMember(Member vo) throws SQLException{
			Connection conn = getConnect();
			
			String query = "INSERT INTO member VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPassword());
			ps.setString(3, vo.getName());
			
			int result = ps.executeUpdate();
			close(ps, conn)			;
			return result;
		}
}
