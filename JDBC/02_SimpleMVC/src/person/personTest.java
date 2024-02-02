package person;

import java.sql.SQLException;
import java.util.ArrayList;

public class personTest {

	PersonController pc = new PersonController();

	public static void main(String[] args) {
		personTest pt = new personTest();

		try {

			// 1. 드라이버 연결
			Class.forName("com.mysql.cj.jdbc.Driver");

//			pt.addPerson(111, "김강우", "서울");
//			pt.addPerson(222, "고아라", "제주도");
//			pt.addPerson(333, "강태주", "경기도");

//			pt.updatePerson(111, "제주도");

//			pt.removePerson(333);

			pt.searchAllPerson();

//			pt.searchPerson(111);

		} catch (Exception e) {

		}

	}

	// person 테이블에 추가
	public void addPerson(int id, String name, String address) throws SQLException {
		int result = pc.addPerson(id, name, address);
		if (result == 1) {
			System.out.println(name + "님, 회원가입 완료!");
		}
	}

	// person 테이블에서 데이터 수정
	public void updatePerson(int id, String address) throws SQLException {
		int result = pc.updatePerson(id, address);
		if (result == 1) {
			System.out.println(id + "번 회원님의 회원정보 수정 완료!");
		}

	}

	// person 테이블에서 데이터 삭제
	public void removePerson(int id) throws SQLException {
		int result = pc.removePerson(id);
		if (result == 1) {
			System.out.println(id + "번 회원님의 회원정보 삭제 완료!");
		}

	}

	// person 테이블에서 데이터 전체 보여주기
	public void searchAllPerson() throws SQLException {
		ArrayList<Person> list = new ArrayList<>();
		for (Person p : list) {
			System.out.println(p);
		}

	}

	// person 테이블에서 데이터 한개만 가져오기
	public void searchPerson(int id) throws SQLException {
		Person p = pc.searchPerson(id);
		System.out.println(p);
		
	}

}