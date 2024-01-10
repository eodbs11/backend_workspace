package com.kh.practice;

import java.util.Scanner;

public class CastingPractice {

	public static void main(String[] args) {

		CastingPractice c = new CastingPractice();
		c.method1();
		c.method2();			
	}

	Scanner sc = new Scanner(System.in);
	
	public void method1() {
		
		System.out.print("문자 : ");
		int word = sc.nextInt();
		String word1 = sc.nextLine();
		
		System.out.println( word1 + " unicode : " + word );
		System.out.println( (word1 + 1) + " unicode : " + (word + 1));	
	}
	
	public void method2() {
		
		System.out.print("국어 점수 > ");
		int ko = sc.nextInt();
		
		System.out.print("영어 점수 > ");
		int en = sc.nextInt();
		
		System.out.print("수학 점수 > ");
		int m = sc.nextInt();
		
		int a = ko + en + m ;
		double b = a/3.0;
		
		System.out.println("국어 : " + ko + "\n영어 : " + en + "\n수학 : " + m  + "\n총점 : "+ a + "\n평균 : " + String.format("%.2f", b));
	}
}

