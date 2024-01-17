package com.kh.step3.model;

public class Calculator {

	
	/*
	 * 메서드(method)
	 * - 작업을 수행하기 위한 명령문의 집합
	 * - 어떤 값을 입력받아서 처리하고 그 결과를 돌려준다.
	 * - 단, 입력받는 값이 없을 수도 있고, 결과를 돌려주지 않을 수도 있음.
	 * - 하나의 메서드는 한가지 기능만 수행하도록 작성하는 것을 권고
	 * 
	 * 리턴 타입 메서드이름(타입 변수명, 타입 변수명, ...) { <-- 여기가 입력 받는 곳!
	 * 			// 메서드 호출시 수행도리 코드
	 * 			return 결과값; <-- 출력하는 곳!
	 * 
	 * }
	 * 
	 * return 문
	 * - 메서드에서 return문을 만나면 종료
	 * - 반환값이 없는(void)경우 return문만 사용!
	 * - 반환값이 있는 경우 return문 뒤에 반환값을 지정해야 함
	 * 
	 * 
	 * */
	
	public int a, b;
	
	public int add() {
		return a + b;
	}
	
	// 두 수의 차를 구하는 기능 : substract
	public int substract() {
		return a - b;
	}
	
	// 오버로딩!!
	public int multiply() {
		return a * b;
	}
	
	public String multiply(int a) {
		return "a * b";
	}
	
	
	// 두 수의 곱을 구하는 기능 : multiply
	public int multiply(int a, int b) {
		return a * b;
	}
	
	/*
	 * 1. 인스턴스 메서드
	 * 	- 인스턴스 생성 후, '참조변수.메서드명()'호출
	 * 	- 인스턴스 변수나 인스턴스 메서드와 관련된 직업을 하는 메서드
	 * 
	 * 2. 클래스 메서드 (static 메서드)
	 * 	- 객체 생성 없이 '클래스명.메서드명()' 호출
	 * 	- 인스턴스 변수나 인스턴스 메서드와 관련없는 작업을 하는 메서드
	 * */
	
	// 두 수의 몫과 나머지를 구하는 기능 : divide
	// 결과값 : 몫은 3, 나머지는 2
	
	public static String divide(int a, int b) {
		return "몫은 " + quotient(a, b) + ", 나머지는 " + remainder(a, b);
	}
	
	// 두 수의 몫을 구하는 기능 : quotient
	public static int quotient(int a, int b) {
		return a / b;
	}
	
	// 두 수의 나머지를 구하는 기능 : remainder
	public static int remainder(int a, int b) {
		return a % b;
	}
	
	/*
	 * 팩토리얼
	 * 1! = 1
	 * 2! = 2 * 1 = 2
	 * 
	 * */
	
	public int factorial(int n) {
		int result = 1;
		
		// 반복문
		for(int i = n; i>0; i--) {
			result *=i;
		}
		return result;
	}
	
	/*
	 *  재귀 함수(Recursion Function)
	 *  - 메서드내에서 자기자신을 반복적으로 호출
	 *  - 반복문으로 바꿀수 있으며 때떄로 반복문보다 성능이 나쁠 수도 있음
	 *  - 이해하면 간결한 코드 작성이 가능
	 * */
	public int factorial2(int n) {
		int result = 1;
		
		if(n!=1)result = n *  factorial2(n-1);
		
		return result;
	}
	
}
