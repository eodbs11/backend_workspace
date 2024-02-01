package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {

		try {

			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));

			// 1. 드라이버 로딩

			Class.forName(ServerInfo.DRIVER_NAME);

			// 2. 디비 연결
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);

			// 3. 쿼리 준비 - DELETE
			String query = p.getProperty("delete");
			PreparedStatement ps = conn.prepareStatement(query);

			// 4. 쿼리문 실행

			ps.setInt(1, 900);

			System.out.println(ps.executeUpdate() + "명 삭제!");

		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");

		}
	}
}
