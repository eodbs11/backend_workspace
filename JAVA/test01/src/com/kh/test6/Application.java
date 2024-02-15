package com.kh.test6;

import java.util.Scanner;

public class Application {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Application app = new Application();
		app.mainmenu();
	}

	public void mainmenu() {

		boolean check = true;
		
		while(check) {
			System.out.println("=== 음식 메뉴 리스트 ===");
			System.out.println("1. 음식 추가");
			System.out.println("2. 음식 정보");
			System.out.println("3. 음식 삭제");
			System.out.println("4. 프로그램 종료");
			System.out.println("번호 선택 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num){			
				case1(): 
					foodadd();
					break;
				case2(): 
					foodinfo();
					break;
				case3(): 
					fooddelete();
					break;
				case4():
					check = false;
					break;
			}	
			
		}
	}


	public void foodadd() {
		System.out.println("번호 선택");
		System.out.println("추가할 음식 입력 : ");
		System.out.println("칼로리 입력 : ");
		System.out.println("음식 정보가 추가 되었습니다.");
	}

	public void foodinfo() {
		System.out.println();
	}

	public void fooddelete() {
		System.out.println("삭제하고 싶은 음식 선택 :");
	}

}
