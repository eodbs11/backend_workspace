package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {

	public static void main(String[] args) {
				
		VariablePractice v = new VariablePractice();
		v.method1();
		v.method2();	
		v.method3();		
	}
	
	Scanner sc = new Scanner(System.in);
	

	public void method1() {
		
//		int a = 10000;
//		int b = 7000;
//		
//		System.out.print("성인 수 > ");
//		int adult = sc.nextInt();
//		
//		System.out.print("청소년 수 > ");
//		int teen = sc.nextInt();	
//		
//		int c = (adult * a);
//		int d = (teen * b);
//		int e = (c + d);		
//		
//		System.out.println("성인 " + adult +"명 : " + c+ "원\n" + "청소년 " + teen +"명 : " + d + "원\n\n"+ "총 금액 : "+ e +"원");
//		
		
		int adultPrice = 10000;
		int teenPrice = 7000;
		int adultCount = 2;
		int teenCount = 3;
		
		int adultTotal = adultPrice * adultCount;
		int teenTotal = teenPrice * teenCount;
		
		System.out.printf("성인 %d명 : %d원\n", adultCount, adultTotal);
		System.out.printf("청소년 %d명 : %d원\n\n", teenCount, teenTotal);
		System.out.printf("총 금액 : %d원", adultTotal, teenTotal);
	}
	
	public void method2() {
		int sw;
		int x = 5;
		int y = 7;
		int z = 9;
		
		sw = x;
		x = y;
		y = sw;
		
		sw = y;
		y = z;
		z = sw;
		
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("z=" + z);		
	}
	
	public void method3() {					
		System.out.print("문자열을 입력하세요 : ");
		String word = sc.nextLine();
		
		System.out.println("첫번째 문자 : " + word.charAt(0));
		System.out.println("마지막 문자 : " + word.charAt(word.length() -1));		
	} 
}
