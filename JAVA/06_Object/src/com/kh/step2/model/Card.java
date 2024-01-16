package com.kh.step2.model;

public class Card {
	
	/*
	 * 변수의 종류
	 * 1. 지역변수(local variable)
	 * 		- 메서드 내에 선언되며, 메서드의 종료와 함께 소멸
	 * 		- 조건문, 반복문 블럭{} 내에 선언된 지역변수는 블럭을 벗어나면 소멸
	 * 
	 * 2. 인스턴스 변수(instance variable) (인스턴스 = 객체)
	 * 	- 각 인스턴스의 개별적인 저장공간
	 *  - 인스턴스 생성 후, '참조변수.인스턴스변수명'으로 접근
	 *  - 인스턴스를 생성할 때 생성되고, 참조변수가 없을 때 가비지컬렉터에 의해 자동제거 
	 *  
	 *  3. 클래스변수(class variable) -> static
	 *  	- 같은 클래스의 모든 인스턴스들이 공유하는 변수
	 *  	- 인스턴스 생성없이 올라갈 때 생성되고, 프로그램이 종료될 때 소멸
	 * */
	
	// 인스턴스 변수
	public int number;// 숫자
	public String kind; // 모양
	
	// 클래스 변수
	public static int width = 100; // 폭
	public static int height = 250; // 높이
	
	// 클래스 변수
}
