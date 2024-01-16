package com.kh.operator;

import java.util.Scanner;

public class F_Triple {

	Scanner sc = new Scanner(System.in);	
	
	/*
	 * 삼항 연산자
	 * 
	 * 조건식 ? 값1 : 값2;
	 * 
	 * - 조건식에는 주로 비교, 논리 연산자가 사용된다.
	 * - 조건식의 결과가 true 이면 값1을 반환한다.
	 * - 조건식의 결과가 false 이면 값2를 반환한다.
	 * */
	
	public static void main(String[] args) {
		F_Triple f = new F_Triple();
//		f.method1();
//		f.practice3();
//		f.practice4();
		f.practice5();
	}
		
	
	public void method1() {
		// 입력받은 정수가 양수인지 음수인지 판단
		// 양수이다. 음수이다.		
		System.out.print("정수값을 입력해주세요 > ");
		int number = sc.nextInt();
		
		String result = (number > 0) ? "양수이다." : "음수이다.";
		//System.out.println(result);
		
		// 조건식 ? 값1 : 값2;
		
		result = (number > 0) ? "양수이다." : number == 0 ? "0이다." : "음수이다.";
		result = (number > 0) ? "양수이다." : number == 0 ? "음수이다" : "0이다.";
			System.out.println(result);
			
	}

	/*
	 * 실습문제 1	 * 
	 * 사용자한테 두개의 정수값을 입력받아서 두 정수의 곱셈 결과 
	 * 100보다 크거나 같은 경우
	 * 	"결과가 100 이상입니다. " 
	 * 아닌경우 
	 * 	"결과가 100보다 적습니다." 
	 * 출력
	 * 
	 * */
	public void practice3() {	
		
		System.out.print(" 첫 번째 정수값을 입력해주세요 > ");
		int a = sc.nextInt();
		
		System.out.print(" 두 번째 정수값을 입력해주세요 > ");
		int b = sc.nextInt();
		
		int c = a * b;
		
		String d = c >= 100 ? "결과가 100 이상입니다. "  : " 결과가 100보다 적습니다.";
		System.out.print(d);				
		
	}	
	
	/*
	 * 실습문제 2	 * 
	 * 사용자한테 문자를 하나 입력 받아서 입력한 문자가 대문자 이면
	 * "알파벳 대문자이다." 아닌 경우 "알파벳 대문자가 아니다"
	 * 
	 * */
	
	public void practice4() {
		System.out.print("문자를 하나 입력해주세요 > ");
		String input = sc.nextLine();
		char e = input.charAt(0);				
		
		String f = (e>= 'A' && e <= 'Z') ? "알파벳 대문자이다." : "알파벳 대문자가 아니다";
		System.out.print(f);			
		
	}
	
	/*
	 * 실습문제 3
	 * 
	 * 두 정수를 입력 받고 + 또는 -를 입력받아서 계산을 출력
	 * 단, + 또는 - 이외의 문자를 입력하는 경우 "잘못 입력했습니다." 출력
	 * 
	 * */
	
	public void practice5() {
	
		System.out.print("첫 번째 정수값을 입력해주세요 > ");
		int g = Integer.parseInt(sc.nextLine());
		
		System.out.print("두 번째 정수값을 입력해주세요 > ");
		int h = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자를 입력해주세요 (+/-) > ");
		char l = sc.nextLine().charAt(0);	
		
		String k =  l == '+' ? g + "+" + h + " = " + (g + h) 
				: l == '-' ? String.format("%d - %d = %d", g, h, (g - h))
						: "잘못 입력했습니다.";			
		System.out.print(k);
		
		
// 또 다른 방법
		
		if(l == '+' || l == '-') {
			System.out.printf("%d %c %d = %d", g, l, h,
					l=='+' ? (g+h) :(g-h));
		}else {
			System.out.println("잘못 입력하셨습니다");
		}		
	}
}
	
