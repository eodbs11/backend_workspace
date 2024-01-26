package com.kh.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_String {

	public static void main(String[] args) {

		A_String a = new A_String();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
	}

	/*
	 * String 클래스 - 불변의 클래스(객체를 생성하면 변경 X) - 변경이 적고 읽기가 많은 경우에 사용하는 것이 좋다 - new 없이도
	 * 객체를 생성할 수 있는 유일한 객체
	 */

	public void method1() {
		// 문자열 리터럴과 new 연산자로 생성된 문자열 비교
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");

		System.out.println("str1 == str2 : " + (str1 == str2)); // false
		System.out.println("str1 == str3 : " + (str1 == str3)); // false
		System.out.println("str3 == str4 : " + (str3 == str4)); // false

//		System.out.println("str1.equals(str2) : " + (str1.equals str2))); //false
//		System.out.println("str1.equals(str3) : " + (str1.equals str3))); //false
//		System.out.println("str3.equals(str4) : " + (str3.equals str4))); //false

		// String 클래스에서 제공하는 메서드

	}

	public void method2() {
		String str = "Hello, java!";

		// 1. charAt(int index):char
		// -전달받은 index 위치의
		char ch = str.charAt(3);
		System.out.println("ch : " + ch);

		// 2. concat(String str) : String
		// - 전달받은 문자열과 원본 문자열을 하나로 합친 새로운 문자열을 생성해서
		String str2 = str.concat("!!!!!!");
		str2 = str + "!!!!!!";
		System.out.println("str2 : " + str2);

		// 3. substring(int beginIndex) : String
		// - 문자열의 beginIndex 위치에서부터 끝까지의 문자열을 새로 생성해서 리턴
		// substring(int beginIndex, int endIndex) : String
		// - 문자열의 beginIndex 위치에서부터 endIndex-1까지
		String str3 = str.substring(6);
		String str4 = str.substring(2, 7);
		System.out.println("str3 : " + str3);
		System.out.println("str4 : " + str4);

		// 4. indexOf(String str) : int
		// - 전달받은 str의 시작 인덱스를 리턴 (포함되어 있지 않으면 -1)
		int index = str.indexOf("!");
		System.out.println("index : " + index); // 11

		int index2 = str.indexOf("Java");
		System.out.println("index2 : " + index2); // 7

		int index3 = str.indexOf("?");
		System.out.println("index3 : " + index3); // -1

		// 5.replace(char oldChar, char newChar) : String
		// -문자열에서 old문자를 new문자로 변경된 새로운 문자열을 생성해서 리턴
		String str5 = str.replace('l', 'c');
		System.out.println("str5 : " + str5);

		// 6. toUpperCase() / toLowerCase() : String
		// - 문자열을 모두 대/소문자로 변경한 새로운 문자열을 생성해서 리턴
		String str6 = str.toUpperCase();
		String str7 = str.toLowerCase();

		System.out.println("str6 : " + str6);
		System.out.println("str7 : " + str7);

		// 7. trim() : String
		// - 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성해서 리턴

		String str8 = "        Hello,     Java!          ";
		System.out.println("trim 전 : " + str8);
		String str9 = str8.trim();
		System.out.println("trim 후 : " + str9);

		// 8. toCharArray() : char[]
		// - 문자열의 문자들을 문자 배열에 담아서 해당 배열의 주소값 리턴
		char[] arr = str.toCharArray();
		ArrayList<char[]> arrList = new ArrayList<>(Arrays.asList(arr));
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));

		// 9. valueOf(문자 배열) : String
		// - 문자열로 변경해서 리턴
		String str10 = String.valueOf(arr);
		System.out.println("str10 : " + str10);

		System.out.println("str : " + str);
	}
	/*
	 * StringBuilder & StringBuffer - 가변의 클래스 : String 클래스와 달리 내부의 문자열을 수정할 수 있다. -
	 * 16개의 문자를 저장할 수 있는 버퍼가 미리 생성되고 문자가 저장됨에 따라 자동 증가 - StringBuilder : 동기화 X -> 단일
	 * 스레드 환경 권장 - StringBuffer : 동기화 O -> 멀티 스레드 환경에서 권장
	 */

	public void method3() {
		StringBuilder sb = new StringBuilder("Hello, ");

		// 1. append(String str) : StringBuilder
		// - 기존 문자열 뒤에 문자열 추가
		sb.append("World!");
		System.out.println(sb);

		// 2. insert(int offset, String str) : StringBuilder
		// - 문자열의 offset 위치부터 전달받은 문자열 추가
		sb.insert(1, "eeeee");
		System.out.println(sb);

		// 3. delete(int start, int end) : StringBuilder
		// -start에서 end-1까지의 인덱스에 해당하는 문자열 삭제
		sb.delete(1, 6);
		System.out.println(sb);

		// 4. reverse() : StringBuilder
		// - 문자열의 순서를 역으로 바꾼다.
		sb.reverse();
		System.out.println(sb);

		// 메서드 체이닝 : 메서드를 이어서 쓸 수 있다!
		StringBuilder sb2 = new StringBuilder("Java Program");
		sb2.delete(5, 12).insert(5, "API").reverse();
		System.out.println(sb2); // IPA avaJ
	}

	/*
	 * StringTokenizer - java.util 패키지에서 제공하는 클래스 - 객체 생성 시 생성자로 전달받은 문자열을 구분자를 이용하여
	 * 분리 - 분리된 최소 단위를 토큰이라고 부른다
	 */

	public void method4() {

		String str = "HTML, CSS, JavaScript, MySQL, Java, JDBC, Servlet, JSP, JQuery";

		// 1. String 클래스의 split 메서드를 이용
		// spilt(String regex) :
		// - 입력받은 구분자로 문자열을 분리해서 문자열의 배열로 담아서 리턴
		String[] strArr = str.split(",");
		System.out.println("과목 개수 : " + strArr.length);
		for (String s : strArr) {
			System.out.println(s);
		}

		// StringTokenizer 객체 이용
		StringTokenizer st = new StringTokenizer(str, ",");
		String[] resultArray = new String[st.countTokens()];
		int i = 0;		
		
		// countTokens : 꺼내지 않고 남아있는 토큰의 수를 확인
		System.out.println("과목 개수 : " + st.countTokens());		
		
		System.out.println(st.hasMoreTokens()); // true
		System.out.println(st.nextToken()); // HTML
		// hasMoreTokens : 남아 있는 토큰이 있는지 확인
		// nextToken : 토큰을 하나씩 꺼내옴
		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
			resultArray[i] = st.nextToken();
			i++;
		}
		System.out.println("array : " + Arrays.toString(resultArray));
		
		System.out.println("꺼내고 남은 과목 개수 : " + st.countTokens());
	}
}
