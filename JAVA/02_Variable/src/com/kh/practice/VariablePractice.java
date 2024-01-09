// 클래스 이름 : com.kh.pratice.VariablePractice
// FQCN(Fully Qu

package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {

	public static void main(String[] args) {
				
		VariablePractice v = new VariablePractice();
//		v.method1();
		v.method2();	
	}
	
//
//	public void method1() {
//		
//		int a = 10000;
//		int b = 7000;
//		
//		Scanner sc = new Scanner(System.in);
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
//	}
	
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
 
}
