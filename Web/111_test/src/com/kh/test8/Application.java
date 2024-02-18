package com.kh.test8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 스키마 x
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
			
			// query X
			
			String query ="SELECT * FROM employee";
			PreparedStatement st = conn.prepareStatement(query);
			
			ResultSet rs = st.executeQuery(); // SELECT문은 executeQuery();
			
			// rs.next()
			// 언더바 생략되어있음
			while(rs.next()){
				System.out.println(rs.getString("emp_Id") + " / " + rs.getString("emp_Name"));
			}			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
