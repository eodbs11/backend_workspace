package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.Rent;

public class RentDAO {

	public RentDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234");
	}

	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		close(ps, conn);
	}

	// 1. 책 대여
	public int rentBook(int bkNo, int memberNo) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO tb_rent(member_no, bk_no) VALUES(?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, memberNo);
		ps.setInt(2, bkNo);
		int result = ps.executeUpdate();
		close(ps, conn);
		return result;
	}

	// 2. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(int no) throws SQLException {
		Connection conn = getConnect();
		String query = "SELECT * FROM tb_rent JOIN tb_book USING(bk_no) WHERE member_no=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		ResultSet rs = ps.executeQuery();
		ArrayList<Rent> list = new ArrayList<>();
		while (rs.next()) {
			Rent rent = new Rent();
			rent.setRentNo(rs.getInt("rent_no"));
			rent.setRentDate(rs.getDate("rent_date"));
			rent.setBook(new Book(rs.getString("bk_title"), rs.getString("bk_author")));
			list.add(rent);
		}
		return list;
	}

	// 3. 대여 취소
	public int deleteRent(int no) throws SQLException {
		Connection conn = getConnect();
		String query = "DELETE FROM tb_rent WHERE rent_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		int result = ps.executeUpdate();
		close(ps, conn);
		return result;
	}
	
}
