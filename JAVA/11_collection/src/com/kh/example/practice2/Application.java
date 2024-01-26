package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.example.practice2.model.music;
import com.kh.list.model.Person;

public class Application {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Application a = new Application();
		a.mainmenu();
	}

	public void mainmenu() {

		boolean check = true;

		while (check) {
			System.out.println("===== 메인 메뉴 =====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 곡 명 오름차순 정렬");
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력: ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				plusup();
				break;
			case 2:
				plusdown();
				break;
			case 3:
				all();
				break;
			case 4:
				search();
				break;
			case 5:
				delete();
				break;
			case 6:
				fix();
				break;
			case 7:
				up();
				break;
			case 8:
				down();
				break;
			case 9:
				check = false;
				System.out.println("종료");
				break;
			}
		}

	}

	ArrayList<music> list = new ArrayList<music>();

	public void plusup() {

		System.out.println("****** 마지막 위치에 곡 추가 ******");

		System.out.println("곡 명 : ");
		String musicname = sc.nextLine();

		System.out.println("가수 명 : ");
		String singername = sc.nextLine();

		list.add(new music(musicname, singername));

		System.out.println("추가 성공");
	}

	public void plusdown() {

		System.out.println("****** 첫 위치에 곡 추가 ******");

		System.out.println("곡 명 : ");
		String musicname = sc.nextLine();

		System.out.println("가수 명 : ");
		String singername = sc.nextLine();

		list.add(0, new music(musicname, singername));

		System.out.println("추가 성공");

	}

	public void all() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		for (music m : list) {
			System.out.println(m.getSingername() + " - " + m.getMusicname());
		}
	}

	public void search() {
		System.out.println("검색할 곡 명 : ");
		String searchname = sc.nextLine();
		for (music m : list) {
			if (m.getMusicname().contains(searchname)) {
				System.out.println(m.getSingername() + " - " + m.getMusicname() + "를 검색했습니다.");
			}
		}
	}

	public void delete() {

		System.out.println("삭제할 곡 명 : ");
		String searchname = sc.nextLine();

		for (music m : list) {
			if (m.getMusicname().contains(searchname)) {
				int idx = list.indexOf(m);
				music m1 = list.remove(idx);
				System.out.println(m1.getSingername() + " - " + m1.getMusicname() + "를 삭제했습니다.");

			}
		}

	}

	public void fix() {

		System.out.println("검색할 곡 명 : ");
		String searchname = sc.nextLine();
		
		System.out.println("수정할 곡 명 : ");
		String newmusicname = sc.nextLine();

		System.out.println("수정할 가수 명 : ");
		String newsingername = sc.nextLine();
		
		for (music m : list) {
			if (m.getMusicname().contains(searchname)) {			
				
			
				
				System.out.println(m.getSingername() + " - " 
									+ m.getMusicname() + "의 값이 변경 되었습니다.");

			}
		}
		// list.set(3, new Person("오은영", "삼성동", 57));
	}

	public void up() {

	}

	public void down() {

	}

}
