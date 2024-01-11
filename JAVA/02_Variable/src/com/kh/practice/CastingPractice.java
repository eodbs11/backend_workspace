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
		char w = sc.nextLine().charAt(0);
		int w1 = (int) w;
		int w2 = w + 1;
		char w3 = ((char)(w+1));

		System.out.println(w + " unicode : " + w1);
		System.out.println(w3 + " unicode : " + w2);
	}

	public void method2() {

		System.out.print("국어 점수 > ");
		int ko = sc.nextInt();

		System.out.print("영어 점수 > ");
		int en = sc.nextInt();

		System.out.print("수학 점수 > ");
		int m = sc.nextInt();

		int a = ko + en + m;
		double b = a / 3.0;

		System.out.println(
				"국어 : " + ko + "\n영어 : " + en + "\n수학 : " + m + "\n총점 : " + a + "\n평균 : " + String.format("%.2f", b));
	}
}
