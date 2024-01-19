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
		app.mainMenu();
		
	}

	public void mainMenu() {
		boolean check = true;
		while(check) {
		System.out.println("===== 메뉴 =====");
		System.out.println("1. 원");
		System.out.println("2. 사각형");			
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");		
		switch(Integer.parseInt(sc.nextLine())) {
		case 1: 
			circleMenu();
			break;			
		case 2: 
			rectangleMenu();
			break;	
		case 9:			
			check = false;
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	
	public void circleMenu() {
		System.out.println("===== 원 메뉴 =====");
		System.out.println("1. 원 둘레");
		System.out.println("2. 원 넓이");			
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");		
		switch(Integer.parseInt(sc.nextLine())) {
		case 1: 
			calcCicum();
			break;
		case 2: 
			calcCircleArea();
			break;	
		case 9: 
			mainMenu();
			break;	
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
	}
	
	public void rectangleMenu() {
		System.out.println("===== 사각형 메뉴 =====");
		System.out.println("1. 사각형 둘레");
		System.out.println("2. 사각형 넓이");			
		System.out.println("9. 메인으로");
		System.out.print("메뉴 번호 : ");		
		switch(Integer.parseInt(sc.nextLine())) {
		case 1: 
			calcPerimeter();
			break;
		case 2: 
			calcRectArea();
			break;	
		case 9: 
			mainMenu();
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
	}	
	
	public void calcCicum() {
		System.out.println("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.println("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		System.out.println("반지름 : ");
		int radius = Integer.parseInt(sc.nextLine());
		
		System.out.println(cc.calcCircum(x, y, radius));
		
	}
	
	public void calcCircleArea() {
		System.out.println("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.println("y 좌표 : ");
		int y = Integer.parseInt(sc.nextLine());
		System.out.println("반지름 : ");		
		int radius = Integer.parseInt(sc.nextLine());
		
		System.out.println(cc.calcArea(x, y, radius));
	}
	
	public void calcPerimeter() {
		System.out.println("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.println("y 좌표 : ");	
		int y = Integer.parseInt(sc.nextLine());
		System.out.println("높이 : ");	
		int height = Integer.parseInt(sc.nextLine());
		System.out.println("너비 : ");	
		int width = Integer.parseInt(sc.nextLine());
		
		System.out.println(rc.calcPerimeter(x, y, height, width));

	}
	
	public void calcRectArea() {
		System.out.println("x 좌표 : ");
		int x = Integer.parseInt(sc.nextLine());
		System.out.println("y 좌표 : ");	
		int y = Integer.parseInt(sc.nextLine());
		System.out.println("높이 : ");	
		int height = Integer.parseInt(sc.nextLine());
		System.out.println("너비 : ");	
		int width = Integer.parseInt(sc.nextLine());
		
		System.out.println(rc.calcRectArea(x, y, height, width));
	}
}


