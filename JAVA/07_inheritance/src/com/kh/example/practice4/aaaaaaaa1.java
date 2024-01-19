package com.kh.example.practice4;

import java.util.Scanner;
import com.kh.example.practice4.controller.CircleContontroller;
import com.kh.example.practice4.controller.RectangleController;

// view
public class Application {	
	
	Scanner sc = new Scanner(System.in);
	CircleContontroller cc = new CircleContontroller();
	RectangleController rc = new RectangleController();

	public static void main(String[] args) {
		
		Application app = new Application();
		
		boolean check = true;
		while(check) {
			void select = app.mainMenu();
			switch(select) {
			case 1:
				app.circleMenu();
				break;
			case 2:
				app.rectangleMenu();
				break;		
			case 9:
				System.out.println("끝내기");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}	
		
			int select1 = app.circleMenu();
			switch(select1) {
			case 1:
				app.calcCicum();
				break;
			case 2:
				app.calcCircleArea();
				break;		
			case 9:
				System.out.println("메인으로");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}		
		
			int select2 = app.rectangleMenu();
			switch(select2) {
			case 1:
				app.calcPerimeter();
				break;
			case 2:
				app.calcRectArea();
				break;		
			case 9:
				System.out.println("끝내기");
				check = false;
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}

	public void mainMenu() {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");			
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");		
		Integer.parseInt(sc.nextLine());
	}
	
	public void circleMenu() {
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");			
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");		
		Integer.parseInt(sc.nextLine());
	}
	
	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");			
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");		
		Integer.parseInt(sc.nextLine());
	}
	
	public void calcCicum() {
		System.out.println("x 좌표 : ");
		int num1 =sc.nextInt();
		System.out.println("y 좌표 : ");
		int num2 =sc.nextInt();
		System.out.println("반지름 : ");
		int num3 =sc.nextInt();
		
	}
	
	public void calcCircleArea() {
		System.out.println("x 좌표 : ");
		int num1 =sc.nextInt();
		System.out.println("y 좌표 : ");
		int num2 =sc.nextInt();
		System.out.println("반지름 : ");		
		int num3 =sc.nextInt();
	}
	
	public void calcPerimeter() {
		System.out.println("x 좌표 : ");
		int num1 =sc.nextInt();
		System.out.println("y 좌표 : ");	
		int num2 =sc.nextInt();
		System.out.println("반지름 : ");		
		int num3 =sc.nextInt();
	}
	
	public void calcRectArea() {
		System.out.println("x 좌표 : ");
		int num1 =sc.nextInt();
		System.out.println("y 좌표 : ");
		int num2 =sc.nextInt();
		System.out.println("반지름 : ");		
		int num3 =sc.nextInt();
	}

}
