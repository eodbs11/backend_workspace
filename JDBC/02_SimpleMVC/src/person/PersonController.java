package person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonController {

	public PersonController() {
		try {
			// 1. 드라이버 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
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

	public int addPerson(int id, String name, String address) throws SQLException {

		// 2. DB 연결
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "INSERT INTO person VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);

		int result = ps.executeUpdate();

		// 5. 자원 반납
		closeAll(ps, conn);

		return result;

	}

	public int updatePerson(int id, String address) throws SQLException {

		// 2. DB 연결
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "UPDATE person SET address = ? WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setString(1, address);
		ps.setInt(2, id);

		int result = ps.executeUpdate();

		// 5. 자원 반납
		closeAll(ps, conn);

		return result;

	}

	public int removePerson(int id) throws SQLException {

		// 2. DB 연결
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement
		String query = "DELETE FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setInt(1, id);

		int result = ps.executeUpdate();

		// 5. 자원 반납
		closeAll(ps, conn);

		return result;
	}

	public ArrayList<Person> searchAllPerson() throws SQLException {

		// 2. DB 연결
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement

		String query = "SELECT * FROM kh.person";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ResultSet rs = ps.executeQuery();
		ArrayList<Person> list = new ArrayList<>();
		// 있을때까지
		while (rs.next()) {
			// 생성자 방식
//			list.add(new Person(rs.getInt("id"),
//								rs.getString("name"), 
//								rs.getString("address")));

			// setter 방식
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setAddress(rs.getString("address"));
			list.add(person);
		}

		// 5. 자원 반납
		closeAll(rs, ps, conn);
		return list;

	}

	public Person searchPerson(int id) throws SQLException {

		// 2. DB 연결
		Connection conn = getConnect();

		// 3. 쿼리문 -> PreparedStatement

		String query = "SELECT * FROM person WHERE id = ?";
		PreparedStatement ps = conn.prepareStatement(query);

		// 4. 쿼리문 실행
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		// 한번 만 실행 하기 때문에 if로

		Person person = null;

		if (rs.next()) {

			person = new Person(rs.getInt("id"), 
								rs.getString("name"),
								rs.getString("address"));

		}
		// 5. 자원 반납
		closeAll(rs, ps, conn);
		
		return person;

	}
}
