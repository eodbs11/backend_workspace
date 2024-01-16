package com.kh.operator;

import java.util.Scanner;

public class E_Logical {

	Scanner sc = new Scanner(System.in);

	/*
	 * 논리연산자 - 두개의 논리값을 연산해주는 연산자 - 논리연산한 결과마저 논리값
	 * 
	 * 논리값 && 논리값 (and) : 왼쪽, 오른쪽 둘 다 true일 경우만 결과값이 true
	 */

	public static void main(String[] args) {
		E_Logical e = new E_Logical();
		e.method1();
		e.method2();
		e.practice();
	}

	public void method1()
	{
		// 사용자가 입력한 정수 값이 1부터 100 사이의 값인지 확인

		System.out.print("정수값을 입력해주세요 > ");
		int number = sc.nextInt();
		boolean result = 1 <= number && number <= 100;

		System.out.print("%d는 1부터 100사이의 값인가요? : %b ");
	}

	public void method2()
	{
		// 사용자가 입력한 정수 값이 1부터 100 사이의 값인지 확인

		int number = 10;
		boolean result = false; // boolean의 초기값 기본은 false
		// --> 변수들 초기화 부터 지정하고자 할 때

		// && 연산자를 기준으로 앞에서 이미 false이기 떄문에 굳이 뒤쪽의 연산은 수행하지 않는다.
		result = (number < 5) && (++number > 0);

		System.out.println(result);
		System.out.println(number);

		// ||
		// true || true = true
		// false || true = true
		// true || false = true
		// false || false = false
		result = (number < 20) || (++number > 0);

		System.out.println(result);
		System.out.println(number);

		// 예시 -> 로그인
	}

	/*
	 * 실습문제
	 * 
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기 A ~ Z : 65 ~ 9, a ~ z : 97 ~ 122
	 * 
	 */

	public void practice() {

		Scanner sc = new Scanner(System.in);

		char ch = '\u0000';
		boolean result = false;

		System.out.print("문자를 입력해주세요 > ");
		ch = sc.nextLine().charAt(0);

		result = ('A' <= ch && ch <= 'z') || ('a' <= ch && ch <= 'z');
		System.out.print("문자를 입력해주세요 > ");

	}
}
