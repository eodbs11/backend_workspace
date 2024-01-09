package com.kh.variable;

public class C_printf {

	public static void main(String[] args) {

		// System.out.println(출력하고자하는값); -- 출력 후 줄바꿈 발생함
		// System.out.print(출력하고자하는값); - 출력만 함 (줄바꿈 발생 x)
		System.out.println("Hello"); 
		System.out.print("Hello\n");
		System.out.println("Hello"); 
		
		System.out.println("---------------------------------");
		
		// System.out.printf("출력하고자하는형식(포맷)", 출력하고자하는값, 값, ...)
		// 출력하고자하는 값들이 제시한 형식에 맞춰서 출력만 진행
		
		/*
		 * 포맷으로 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능)
		 * 
		 * */
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20% 띄어쓰기 인식함 %로 인식하려면 %뒤에 한번 더 써줘야함 안 그러면 포맷으로 인식
		System.out.println(iNum1 + "% " + iNum2 + "%");
		System.out.printf("%d%% %d%%", iNum1, iNum2);
		System.out.println();
		System.out.println("---------------------------------");
		
		System.out.printf("%5d\n", iNum1); // 5칸 공간 확보 후 양수 오른쪽 정렬
		System.out.printf("%-5d\n", -iNum2); // 음수는 왼쪽 정렬 양수는 오른쪽 정렬
		System.out.printf("%5d\n", 300);
		
		System.out.println("---------------------------------");
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		
		System.out.printf("%f\t%f", dNum1, dNum2); // 무조건 소수점 아래 6번쨰 자리까지 표현
		System.out.printf("%.3f\t%.2f\n", dNum1, dNum2);
		
		System.out.println("---------------------------------");
		
		char ch = 'a';
		String str = "Hello";
		System.out.printf("%c %10s %s\n", ch, str, ch, str); // a      Hello a
		System.out.printf("%C %S", ch, str); // A Hello --> 대문자로만 출력

	}
	

}
