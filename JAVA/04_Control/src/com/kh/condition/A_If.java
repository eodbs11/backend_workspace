package com.kh.condition;

import java.util.Scanner;

public class A_If {

	Scanner sc = new Scanner(System.in);

	/*
	 * if문
	 * 
	 * if(조건식){ 조건식이 참(true)일 때 실행 }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리 연산자를 주로 사용
	 */

	public void method1() {
		System.out.print("성적을 입력하세요. > ");
//		int a =sc.nextInt();
//		
//		if(a>=60) {
//			System.out.println("합격입니다");
//		}		
		
		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		
		int score = Integer.parseInt(sc.nextLine());
		
		if(score>=60) {
			System.out.println("합격입니다");
		}	
		
		if(score>=60) {
			System.out.println("합격입니다");
			System.out.println("축하합니다");
		}
	}

	/*
	 * 
	 * if-else문
	 * 
	 * if(조건식){ 조건식이 참(true)일 떄 실행 }else { 조건식이 거짓(false)일떄 실행 }
	 * 
	 * }
	 */

		public void method2(){
			
			System.out.print("성적을 입력하세요. > ");			
			int score = Integer.parseInt(sc.nextLine());
						
			if(score>=60) {
				System.out.println("합격입니다");
				
			}else {
				System.out.println("불합격합니다");
			}
			// 삼항 연산자
			String result = (score >= 60 ? "합격입니다" : "불합격입니다");}
		

	public static void main(String[] args) {

		A_If a = new A_If();
		a.method1();
		a.method2();
		a.method3();
		a.method4();
		a.method5();
		a.method6();
		a.method7();
	}

	public void method3(){		
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 본인이 아니다 를 출력
		System.out.print("이름을 입력하세요. > ");
		String name =sc.nextLine();		
		
			System.out.println("name의 주소값 : " + System.identityHashCode(name));	
			System.out.println("본인이름의 주소값 : " + System.identityHashCode("정대윤"));
			System.out.println(name == "정대윤"); // false
			// String -> 참조형 변수 (클래스 변수)는 주소값을 저장
			System.out.println(name.equals("정대윤")); //true
		
			if (name.equals("정대윤")){
				System.out.println("본인입니다.");			
			}else {
				System.out.println("본인이 아닙니다.");
			}	
	}
	
	public void method4(){
		
		// 입력받은 숫자가 0보다 크면 "양수", 0이면 "0이다", 작으면 "음수" 출력
		System.out.print("숫자를 입력하세요. > ");
		int n = Integer.parseInt(sc.nextLine());
		if (n > 0){
			System.out.println("양수");			
		}else if (n < 0){
			System.out.println("음수");
		}else {
			System.out.println("0이다");
		}	
	}	

	/*
	 * 사용자에게 점수(0~100)를 입력 받아서 점수별로 등급을 정리 - 90이상 A - 90 미만 80이상 B - 80미만 70이상 C -
	 * 70미만 60이상 D - 60미만 F *
	 */

//	
	public void method5() {
		System.out.print("점수를 입력하세요. > ");
		int n = Integer.parseInt(sc.nextLine());
		String grade = "";
		if (n >= 90) {
			grade = "A";
		} else if ( n >= 80) {
			grade = "B";
		} else if (n >= 70) {
			grade = "C";
		} else if (n >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		System.out.printf(grade);
	}

	/*
	 * 세정수를 입력했을때 짝수만 출력
	 * 
	 * num1 > 3 num2 > 4 num3 > 6
	 * 
	 * 4 6
	 * 
	 */

	public void method6() {
		System.out.print("정수를 입력하세요. > ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("정수를 입력하세요. > ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("정수를 입력하세요. > ");
		int num3 = Integer.parseInt(sc.nextLine());
		if (num1 % 2 == 0) {
			System.out.println(num1);
		}
		if (num2 % 2 == 0) {
			System.out.println(num2);
		}
		if (num3 % 2 == 0) {
			System.out.println(num3);
		}

	}

	/*
	 * 
	 * 정수 1개를 입력했을떄 음(minus)/양(plus)/0(zero), 짝(even)/홀 (odd) 출력
	 * 
	 * 정수 입력 > -3 minus odd
	 */

	public void method7() {
		System.out.print("정수를 입력하세요. > ");
		int num = Integer.parseInt(sc.nextLine());
		if (num > 0) {
			System.out.println("plus");
		} else if (num == 0) {
			System.out.println("zero");
		} else if (num < 0) {
			System.out.println("minus");
		}
		if (num / 2 == 0) {
			System.out.println("even");
		}
		if (num / 2 != 0) {
			System.out.println("odd");
		}

	}

}
