package com.kh.step3;

import com.kh.step3.model.Calculator;

public class Application {

	
	
	public static void main(String[] args) {

		/*
		 * 변수 호출 방법
		 * - 참조 변수.변수;
		 * 
		 * 매서드 호출 방법
		 * - 참조변수. 메서드명(); // 매개변수가 없는 경우
		 * - 참조변수. 메서드명(값1, 값2, ....); //매개변수가 있는 경우
		 * */
		Calculator c = new Calculator();
		
		c.a = 3;
		c.b = 98;
		
	
		
		System.out.println("더하기 : " + c.add());
		System.out.println("빼기 : " + c.substract());
		System.out.println("곱하기 : " + c.multiply());
		System.out.println("곱하기 2 : " + c.multiply(100, 200));
		System.out.println("나누기 : " + Calculator.divide(c.a, c.b));
		System.out.println("팩토리얼 : " + c.factorial(4));
		System.out.println("팩토리얼 : " + c.factorial2(4));
	}

}

// while