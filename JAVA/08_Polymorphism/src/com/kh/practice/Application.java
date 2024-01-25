package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.practice.model.Book;
import com.kh.practice.model.Member;

public class Application {

	Scanner sc = new Scanner(System.in);
	Member m = new Member();

	int num = -1;

	// 책에 대한 정보
	Book[] books = { new Book("맛있는 지중해식 레시피", true), new Book("카페 샌드위치 마스터 클래스", false), new Book("원피스 107", 19),
			new Book("주술회전", 15) };

	// 실행용 메서드
	public static void main(String[] args) {

		Application app = new Application();
		app.mainmenu();

	}

	public void mainmenu() {

		System.out.print("이름 : ");
		m.setName(sc.nextLine()); // setter

		System.out.print("나이 : ");
		m.setAge(Integer.parseInt(sc.nextLine())); // setter

		boolean check = true;

		// 정의되어 있을 때 for문 그렇지 않을 때 while문 값을 매칭 시킬 때 while
		while (check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				myPage();
				break;
			case 2:
				rentBook();
				break;
			case 3:
				check = false;
				break;
			}
		}
	}

	public void myPage() {
		// getter
		System.out.println(m);
	}

	public void rentBook() {
		for (int index = 0; index < books.length; index++)
			System.out.println(index + "번 도서 : " + books[index]);
		System.out.print("대여할 도서 번호 선택 : ");
		num = Integer.parseInt(sc.nextLine());

		Book selectBook = books[num]; // 사용자가 선택한 책 -> 빌릴 책
		// getter를 이용해서 기존 책 리스트를 일단 가지고 와야함
		Book[] newBookList = m.getBookList();

		for (int i = 0; i < m.getBookList().length; i++) { // getter

			if (newBookList[i] == null) {
				// 대여 가능 공간
				if (selectBook.isCoupon()) {
					// -> 새로운 쿠폰 값(setter) = 기존 쿠폰 값(getter) +1
					// setter + getter
					m.setCoupon(m.getCoupon() + 1);
					// 내가 대여한 책의 쿠폰이 true인 경우
				}
				if (m.getAge() >= selectBook.getAccessAge()) {
					// 내 나이가 대여한 책의 나이제한 이상인 경우
					newBookList[i] = books[num];
				}
				break;
			}
		}

		m.setBookList(newBookList);

		if (m.getAge() < selectBook.getAccessAge()) {
			System.out.println("나이 제한으로 대여 불가능입니다.");
		} else {
			System.out.println("성공적으로 대여되었습니다.");
		}
	}
}
