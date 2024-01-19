package com.kh.array.practice2;

import java.util.Scanner;

import com.kh.array.practice2.controller.MemberController;
import com.kh.array.practice2.model.Member;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}

	public void mainMenu() {

		/*
		 * 회원 수가 최대 3명이 등록 가능 3명 모두 등록 되면 "회원수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다."와 함께
		 * "1. 새 회원 등록"하지못하게 -> 화면상 안보이게만 처리해도 됩니다.
		 * 
		 * 1번인 경우 -> insertMember() 2번인 경우 -> updateMember() 3번인 경우 -> printAll() 9번인 경우
		 * -> 프로그램 종료 그외의 경우 잘못입력하셨습니다. 다시 입력해주세요
		 */

		boolean check = true;
		while (check) {
			if (mc.count < 3) {
				System.out.println("최대 등록 가능한 회원 수는 3명입니다");
				System.out.println("현재 등록된 회원 수는 " + mc.count + "명입니다.");
				System.out.println("1. 새 회원 등록");
				System.out.println("2. 회원 정보 수정");
				System.out.println("3. 전체 회원 정보 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					if(mc.count < 3)insertMember();
					break;
				case 2:
					updateMember();
					break;
				case 3:
					printAll();
					break;
				case 9:
					check = false;
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				}
			} else {
				System.out.println("최대 등록 가능한 회원 수는 3명입니다");
				System.out.println("현재 등록된 회원 수는 " + mc.count + "명입니다.");
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
				System.out.println("2. 회원 정보 수정");
				System.out.println("3. 전체 회원 정보 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 2:
					updateMember();
					break;
				case 3:
					printAll();
					break;
				case 9:
					check = false;
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				}
			}
		}
	}

	public void insertMember() {
		/*
		 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우 "중복된 아이디입니다. 다시 입력해주세요." 출력 후 다시 아이디 입력부터
		 * 나올 수 있게 처리
		 */

		System.out.println("아이디 : ");
		String id = sc.nextLine();

		if (mc.checkId(id) != -1) {
			System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
		} else{

			System.out.println("이름 : ");
			String name = sc.nextLine();

			System.out.println("비밀번호 : ");
			String password = sc.nextLine();

			System.out.println("이메일 : ");
			String email = sc.nextLine();

			System.out.println("성별(M/F) : ");
			char gender = sc.nextLine().charAt(0);

			System.out.println("나이 : ");
			int age = Integer.parseInt(sc.nextLine());

			Member m = new Member(id, name, password, email, gender, age);
			mc.insertmember(m);
		}
	}

	public void updateMember() {
		/*
		 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우 "회원 정보가 없습니다." 출력 후 다시 메인 화면으로
		 */

		System.out.println("수정할 회원의 아이디 : ");
		String id = sc.nextLine();		

		if (mc.checkId(id) == -1) {			
			System.out.println("회원 정보가 없습니다.");
			return;
		} else {
			System.out.println("수정할 이름 : ");
			String name = sc.nextLine();
			

			System.out.println("수정할 이메일 : ");
			String email = sc.nextLine();
			

			System.out.println("수정할 비밀번호 : ");
			String password = sc.nextLine();
			
			mc.updatemember(id, name, email, password);
		}
	}

	public void printAll() {
		/*
		 * 전체 회원 정보 출력
		 * */
		
		Member[] mArr = mc.printAll();
		for(Member m : mArr) {
			if(m!=null) System.out.println(m);
		}
	}

}
