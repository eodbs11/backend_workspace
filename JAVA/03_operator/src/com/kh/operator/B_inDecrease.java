package com.kh.operator;

public class B_inDecrease {
	
	/*
	 * 증감 연산자
	 * 
	 * (증감연산자) 데이터; 또는 데이터(증감연산자);
	 * 
	 * - 값을 1 증가시키거나 1 감소시키는 연산자
	 * - ++ : 값 1 증가
	 * - -- : 값 1 감소
	 * - (증감연산자)값 : 전위 연산으로 먼저 증감 연산을 수행하고 다른 연산을 수행
	 * - 값(증감연산자) : 후위 연산으로 먼저 다른 연산을 수행하고 증감 연산을 수행
	 * */
	
	
	public static void main(String[] args) {
		
		B_inDecrease b = new B_inDecrease();
//		b.method1();
		b.method2();
		
	}
	
	public void method1() {
		
		int number = 10;
		
		// 전위 연산자 테스트
		System.out.println("1회 수행 후 값 : " + ++number); // 11
		System.out.println("2회 수행 후 값 : " + ++number); // 12
		System.out.println("전위 연산자 적용 후 : " + number); // 12
		
		// 후위 연산자 테스트
		System.out.println("1회 수행 후 값 : " + number++); // 12
		System.out.println("2회 수행 후 값 : " + number++); // 13
		System.out.println("후위 연산자 적용 후 : " + number); // 14
		
	}
	
	public void method2() {
		int number = 20;
		int result = number++ * 3;
		
		System.out.println("number : " + number); // 21
		System.out.println("result : " + result); // 60
		
		int number1 = 10;
		int number2 = 20;
		int number3 = 30;
		
		System.out.println(number1++); //10
		System.out.println((++number1) + (number2++)); // 32
		System.out.println((number1++) + (--number2) + (--number3)); // 12+20+29= 61
		
		System.out.println("number1 ;" +number1); //
		System.out.println("number2 ;" +number2); //
		System.out.println("number3 ;" +number3); //
	}
	
}
