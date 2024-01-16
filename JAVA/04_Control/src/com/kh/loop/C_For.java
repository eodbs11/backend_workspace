package com.kh.loop;

import java.util.Scanner;

public class C_For {

	Scanner sc = new Scanner(System.in);

	/*
	 * for문
	 * 
	 * for(초기식; 조건식; 증감식){
	 * 				실행코드
	 * }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문 
	 * - 초기식 : 반복문이 수행될 때 단 한 번만 실행, 반복문 안에서 사용할 변수를 선언하고 초기값을 대입 
	 * - 조건식 : 결과가 true이면 실행코드를 실행, false이면 실행하지 않고 반복문을 빠져나감 
	 * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자를 사용 	 * 
	 * 
	 */

	// 1 ~ 5 출력
	public void method1() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}

	// 1~5 반대로 출력
	public void method2() {
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}

	// 1~10 사이의 홀수만 출력
	// 1
	// 3
	// 5
	// 7
	// 9
	public void method3() {
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i);
		}
	}

	/*
	 * continue문
	 * 
	 * - continue문은 반복문 안에서 사용 
	 * - 반복문 안에서 continue를 만나면 "현재 구문" 종료 
	 * - 반복문을 빠져나가는건 아님!
	 *    다음 반복을 계속해서 수행
	 * 
	 */

	// 1~10사이의 짝수만 출력
	public void method4() {
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) continue;
			System.out.println(i);
		}
	}

	// 1~10까지의 합계
	public void method5() {
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}

	// 1부터 사용자가 입력한 수까지의 합계
	public void method6() {
		System.out.print("숫자를 입력하세요");
		int num1 = sc.nextInt();
		for (int i = 1; i <= num1; i++) {
			System.out.println(i);
		}
	}

	// 1부터 랜덤값까지의 합꼐

	/*
	 * java.lang.Math 클래스에서 제공하는 random() 메서드 
	 * 호출할 떄마다 매번 다른 랜덤값을 얻어낼수 있음
	 */
	public void method7() {
		double random = Math.random(); // 0.0 <= random < 1.0
		random = Math.random() * 10; // 0.0 <= random < 10.0
		random = Math.random() * 10 + 1; // 1.0 <= random < 11.0
		
		int num = (int) random;  // 1 ~10 까지의 랜덤값
		int sum = 0;
		
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println(sum);
	}

	/*
	 * 사용자한테 입력받은 문자열을 세로로 출력 사용자 입력 > Hello 
	 * H => str.charAt(0) 
	 * e 
	 * l 
	 * l 
	 * 0 => str.charAt(str.length() -1)
	 */

	public void method8() {
		System.out.print("사용자 입력 > ");
		String str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}

		/*
		 * 향상된 for문 for(데이터 타입 변수 : 배열) { 변수 : 배열의 값을 하나씩 가지고 옴 }
		 */

		/*
		 * 문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것이 문자열
		 * 
		 * - String. charAt(int index) : 인덱스에 있는 문자를 char 형식으로 반환 
		 * - String.toCharArray()
		 * : 모든 문자가 들어있는 char[] 형식의 데이터를 반환  
		 * -- [] 배열 형식
		 */
		for (char ch : str.toCharArray()) {
			System.out.println(ch);
		}
	}

	public void method9() {
		for (int i = 1; i <= 9; i++) {
			System.out.println("2 X " + i + " = " + 2 * i);
		}
	}

	// 중첩 for문
	// 2 ~ 9
	public void method10() {
		for (int i = 1; i <= 9; i++) {
			for (int i1 = 1; i1 <= 9; i1++) {
				System.out.println(i + " X " + i1 + " = " + i * i1);
			}
		}
	}

	/*
	 * 
	 * ***** 
	 * ***** 
	 * ***** 
	 * ***** 
	 * *****
	 * 
	 */
	public void method11() {
		for (int i = 1; i < 5; i++){
			for (int i1 = 1; i1 <= 5; i1++) {
			System.out.printf("*");
			}
			System.out.println("");
		}
	}

	/*
	 * 1*** 
	 * *2** 
	 * **3* 
	 * ***4
	 * 
	 */
	public void method12() {
		for (int i = 0; i < 4; i++){
			for (int i1 = 0; i1 < 4; i1++) {
				if(i==i1) System.out.print(i+1);
				else System.out.printf("*");
			}
			System.out.println();
		}
	}

	/*
	 * 
	 * * i=0, j=0
	 * ** 
	 * *** 
	 * **** 
	 * ***** i=4, j=0, j=1, j=2, j=3, j=4
	 * 
	 */
	public void method13() {
		for (int i = 0; i < 5; i++){
			for (int i1 = 0; i1 <= i; i1++) {
			System.out.printf("*");
			}
			System.out.println("");
		}
	}
	/*
	 *  	
	 *     * 
	 *    ** 
	 *   *** 
	 *  **** 
	 * *****
	 * 
	 */

	public void method14() {
		for (int i = 0; i <4; i++){
			for (int i1 = 1; i1 <= i; i1--) {
			System.out.printf("*");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		C_For c = new C_For();
		c.method1();
		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
//		c.method11();
//		c.method12();
//		c.method13();
//		c.method14();

	}

}
