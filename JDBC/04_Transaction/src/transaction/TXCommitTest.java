package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TXCommitTest {

	public static void main(String[] args) {
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "1234");
			
			// 3. 쿼리문 + PreparedStatement
			String query1 = "INSERT INTO member VALUES(?, ?, ?)";
			String query2 = "SELECT * FROM member WHERE id=?";
			
			// 트랜잭션 시작...!
			conn.setAutoCommit(false);
			
			PreparedStatement ps1 = conn.prepareStatement(query1);
			ps1.setString(1, "test4");
			ps1.setString(2, "pass4");
			ps1.setString(3, "테스트4");
			ps1.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ps2.setString(1, "test100");
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) { // 회원이 존재하면
				// INSERT 취소...!
				conn.rollback();
				System.out.println("회원이 존재하여 회원 추가 취소!");
			} else { // 회원이 존재하지 않는다면
				conn.commit();
				System.out.println("회원이 존재하지 않으므로 추가!");
			}
			
			// 트랜잭션 처리를 다시 원래대로 돌려놓음
			conn.setAutoCommit(true);
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}