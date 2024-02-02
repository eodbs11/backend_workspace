package com.kh;

import java.util.Scanner;

import com.kh.model.controller.Membercontroller;

public class Application {

	Membercontroller mc = new Membercontroller();

	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Application app = new Application();
		app.mainMenu();

		try {
			// 1. 드라이버 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {

		}
	}

	public void mainMenu() {
		System.out.println("===== KH 사이트 =====");

		boolean check = true;
		while (check) {
			System.out.println("****** 메인메뉴 ******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				signUp();
				break;
			case 2:
				login();
				break;
			case 9:
				// "프로그램 종료" 출력 후 반복문 종료
				check = false;
				System.out.println("프로그램 종료.");
				break;
			}
		}
	}

	public void signUp() {

		System.out.println();
		String id = sc.nextLine();

		System.out.println();
		String password = sc.nextLine();

		System.out.println();
		String name = sc.nextLine();

//		public void signUp(String id, String password, String name) throws SQLException {
//			int result = pc.addUser(id, password, name);
//			if (result == 1) {
//				System.out.println(name + "님, 회원가입 완료!");
//			}
//		}

		// 아이디, 비밀번호, 이름을 사용자에게 입력 받아
		// MemberControll의 signUp 메서드 반환 결과에 따라
		// true면 "성공적으로 회원가입 완료 하였습니다." 출력
		// false면 "중복된 아이디 입니다 다시 입력해주세요." 출력
	}

	public void login() {

		System.out.println();
		String id = sc.nextLine();

		System.out.println();
		String password = sc.nextLine();
		// 아이디 비밀번호를 사용자에게 입력받아
		// MemberController의 login 메서드 반환 결과를 이름으로 받고
		// 이름이 null이 아니면 "~~님, 환영합니다! 출력
		// --> login 성공 성공했다면 memberMenu 호출
		// null이면 "틀린 아이디 또는 비밀번호 입니다. 다시 입력해주세요." 출력
	}

	public void memberMenu() {
		boolean check = true;
		while (check) {
			System.out.println("****** 회원 메뉴 ******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 번호 입력 : ");

			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				changePassword();
				break;

			case 2:
				changeName();
				break;

			case 3:
				// 로그아웃 처리 -> 프로그램 종료처럼 하시면 됩니다.
				check = false;
				System.out.println("프로그램 종료. 로그아웃 됩니다.");
				break;
			}
		}

	}

	public void changePassword() {

		System.out.println();
		String id = sc.nextLine();

		System.out.println();
		String oldPw = sc.nextLine();

		System.out.println();
		String newPw = sc.nextLine();
		// 아이디, 현재 비밀번호, 새로운 비밀번호를 사용자에게 입력받아
		// MemberController의 changePassword 메서드 반환 결과에 따라
		// true면 "비밀번호 변경에 성공했습니다." 출력
		// false면 "비밀번호 변경에 실패했습니다. 다시 입력해 주세요." 출력
	}

	public void changeName() {

		System.out.println();
		String id = sc.nextLine();

		System.out.println();
		String password = sc.nextLine();

		// 아이디, 비밀번호를 사용자에게 입력받아
		// 사용자가 맞는지 확인 후 - MemberController의 login 메서드 활용
		// 이름이 null이 아니면
		// --> "현재 설정된 이름 : ooo" 출력
		// --> 변경할 이름을 사용자하넽 입력받아
		// MemberController의 changeName 메서드로 이름 변경
		// 이름이 null이면 "이름 변경에 실패했습니다. 다시 입력해주세요." 출력

	}

}
