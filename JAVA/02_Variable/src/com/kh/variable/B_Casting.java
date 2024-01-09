package com.kh.variable;

public class B_Casting {

		/*
		 * 형 변환(Casting)
		 * - 값의 타입을 다른 타입으로 변환하는 것
		 * - boolean을 제외한 7개의 기본형은 서로 형변환이 가능함
		 * */
	
	public static void main(String[] args) {
		
		B_Casting b = new B_Casting();
		//b.autoCasting();
		b.casting();
	}
	
	/*
	 * 자동 형 변환(묵시적 형 변환)
	 * - 자동으로 형 변환이 이루어지기 때문에 따로 형 변환하지 않아도 된다.
	 * */
	
	public void autoCasting() {
		byte b = 10; // 1byte
		short s = b; // 2byte : byte -> short 자동 형 변환
		int i = s;  // 4byte : short -> int
		long l = i; // 8byte : int -> long
		
		// 실수
		float f = 1; // 4byte
		double d = f; // 8byte : float -> double
		
		d = i; // int -> double
		f = l; // long(8) -> float(4) => 표현가능한 수의 범위가 더 크기 때문에
		
		double result = 12 + 3.3;
		System.out.println(result); // 15.3
		int result2 = b + s; // byte, short 타입의 데이터는 연산시 무조건 int 타입으로 변환
		System.out.println(result2); // 20
		long result3 = 30 + 30; // 30 + 30 = 60, 60을 long 타입으로 형 변환 (60L)
		System.out.println(result3);
		long result4 = 30 + 30L; // 30L + 30L = 60L
		System.out.println(result4); 
	}
	/*
	 *  강제 형 변환 (명시적 형 변환)
	 *  
	 *  (자료형) 데이터;
	 *  
	 *  - 범위가 큰 크기의 자료형의 데이터를 
	 *    작은 크기의 자료형으로 변환하려고 할 때 사용
	 *  - 강제 형 변환의 경우 데이터의 손실이 발생할 수 있다.
	 *  
	 * */
	
	public void casting() {
		double d = 4.12345678904567890; // 15자리
		System.out.println(d);
		
		float f = (float)d; // 6자리
		System.out.println(f); // 4.123457
		
		int i = (int)f;
		System.out.println(i); // 4
		
		int sum = (int)(i + d); // 4.0 + 4.12345678904567890 = 8.12345678904567890
		System.out.println(sum); // 8
		
		int sum2 = i + (int) d; // 4 + 4 = 8
		System.out.println(sum2); // 8
		
		int number = 128;
		byte bNumber = (byte) number;
		
		System.out.println(bNumber); // -127
		
		// char <-> int : 각 문자들마다 고유한 숫자가 지정되어 있기 때문에 (유니코드, 아스키코드)
		// 쌍방향으로 형변환 가능
		// char는 음수값 저장 불가 => 값의 범위가 0 ~ 65535
		
		int num = /*(int)*/ 'A'; // 아스키 코드
		System.out.println(num); // A -> 65
		
		char ch = 52143;
		System.out.println(ch); // 52143 -> 쮯
	}
}
