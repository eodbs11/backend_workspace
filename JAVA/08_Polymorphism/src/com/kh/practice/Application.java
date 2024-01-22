package com.kh.practice;

import java.util.Scanner;

import com.kh.practice.controller.LibaryController;
import com.kh.practice.model.Member;

public class Application {

	Scanner sc = new Scanner(System.in);
	LibaryController lc = new LibaryController();
	
	public static void main(String[] args) {

		Application app = new Application();
		
		boolean check = true;
		while(check) {
			int select = app.mainMenu();
			switch(select) {
			case 1:
				app.myPage();
				break;
			case 2:
				app.bookShare();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
		
	}
	
	//메인메뉴
	public int mainMenu() {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.println("메뉴 번호 : ");
		return Integer.parseInt(sc.nextLine());	
			
	}
	
	public int myPage() {
		 Member printAll() {
				return member;
		 }
		return Integer.parseInt(sc.nextLine());	
			
	}
	
	public int bookShare() {
		System.out.println("==== 메뉴 ====");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 대여하기");
		System.out.println("3. 프로그램 종료하기");
		System.out.println("메뉴 번호 : ");
		return Integer.parseInt(sc.nextLine());	
			
	}
	
}
