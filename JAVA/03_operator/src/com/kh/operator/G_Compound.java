package com.kh.operator;

public class G_Compound {

	/*
	 * 복합 대입 연산자
	 * - 산술연산자와 대입연산자를 결합한 형태
	 * - 연산처리 속도가 빨라짐
	 * 
	 * +=, -=, *=, /=, %=
	 * 
	 * a = a + 3; => a += 3;
	 * a = a - 3; => a -= 3;
	 * a = a * 3; => a *= 3;
	 * a = a / 3; => a /= 3;
	 * a = a % 3; => a %= 3;
	 * 
	 * ++a; or a++; => a = a + 1; => a += 1;
	 * --a; or a-- => a = a - 1; => a -=1;
	 * 
	 * */
	
	public static void main(String[] args) {
		
		int number = 12;
		
		number += 3; // number = number + 3
		System.out.println(number); // 15
		
		number -= 5; // number = number - 5
		System.out.println(number); // 10
		
		number *= 6; // number = number * 6
		System.out.println(number); // 60
		
		number /= 3; // number = number /3
		System.out.println(number); // 20
		
		String str = "Hello";
		str += " Java!";
		System.out.println(str); // Hello Java!
	}

}
