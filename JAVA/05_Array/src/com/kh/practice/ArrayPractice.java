package com.kh.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	Scanner sc = new Scanner(System.in);

	/*
	 * 길이가 5인 배열을 선언하고 과일 5개로 초기화 한 후 본인이 좋아하는 과일 하나를 출력하세요. (과일 5개는 뭐든지~)
	 * 
	 */
	public void method1() {

		String[] arr1 = { "바나나", "사과", "키위", "청포도", "배" };
		int num = (int) (Math.random() * 5);

		ArrayList<String> fruitList = new ArrayList<>(Arrays.asList(arr1));
//		 fruitList.add("바나나");
//		 fruitList.add("사과");
//		 fruitList.add("키위");
//		 fruitList.add("청포도");
//		 fruitList.add("배");
		System.out.println(fruitList);
		System.out.println(fruitList.get(num));
	}

	/*
	 * 사용자에게 배열의 길이와 배열의 크기 만큼 사용자한테 입력 받은 값으로 초기화 한 후 각 입력 받은 값이 잘 들어갔는지 출력 후 저장된
	 * 값들의 합을 출력하세요.
	 * 
	 * 정수 : 5 배열 0번째 인덱스에 넣을 값 : 4 배열 1번째 인덱스에 넣을 값 : -4 배열 2번째 인덱스에 넣을 값 : 3 배열 3번째
	 * 인덱스에 넣을 값 : -3 배열 4번째 인덱스에 넣을 값 : 2 [4, -4, 3, -3, 2] 2
	 */
	public void method2() {

//		System.out.println("정수 : ");
//		int num = sc.nextInt();
//		int[] arr = new int[num];
//		
//		int sum = 0;
//		ArrayList<Integer> arrList = new ArrayList<>();
//		for(int i=0; i<num; i++) {
//			System.out.println("배열" + i +"번째 인덱스에 넣을 값 : ");
//			arr[i] = sc.nextInt();
//			sum +=arr[i];
//		}

//		System.out.println(Arrays.toString(arr));
//		System.out.println(sum);

	}

	/*
	 * 음식 메뉴는 자유롭게! 개수도 자유롭게! 배열 사용해서 사용자가 입력한 값이 배열에 있으면 "배달 가능", 없으면 "배달 불가능"을
	 * 출력하세요.
	 * 
	 */
	public void method3() {
		String[] menu = { "초밥", "후토마끼", "닭볶음탕", "등갈비김치찌개", "치킨" };
		System.out.println("주문하실 메뉴를 골라주세요 : ");
		String select = sc.nextLine();
//		for (int i = 0; i<menu.length) {
//			if (select.equals (menu[i])) {				
//				System.out.println("배달 가능");
//			else if ( i == menu.length-1){
//				System.out.println("배달 불가능");
//			}
//			}
		ArrayList<String> menuList = new ArrayList<>(Arrays.asList(menu));

		boolean check = false;
		for (String food : menuList) {
			if (select.equals(food)) {
				check = true;
			}
		}
		System.out.println(check ? "배달 가능" : "배달 불가능");
	}

	/*
	 * 
	 * 사용자에게 주민등록번호를 입력받아 성별자리 이후부터 *로 가리고 출력하세요. 단, 원본 배열은 건드리지 않고!
	 * 
	 * 주민등록번호 : 123456-1234567 123456-1******
	 * 
	 */
	public void method4() {

		System.out.println("주민등록번호 : ");
		String no = sc.nextLine();

		char[] charNo = no.toCharArray();
		String[]strNo = no.split("");
		ArrayList<String> noList = new ArrayList<>(Arrays.asList(strNo));
		for (int i = 0; i < noList.size(); i++)	{
			if (i <= 7) {
				System.out.println(noList.get(i));
			} else {
				System.out.println("*");
			}
		}

	}

	/*
	 * 사용자가 입력한 단어를 거꾸로 뒤집어서 출력하세요.
	 * 
	 * 단어 입력 : programming gnimmargorp
	 * 
	 */
	public void method5() {
		System.out.print("단어 입력 : ");
		String word = sc.nextLine();

		String reverse = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			reverse = reverse + word.charAt(i);
		}

		System.out.println(reverse);
	}

	public static void main(String[] args) {
		ArrayPractice a = new ArrayPractice();

//		a.method1();
//    	a.method2();
//		a.method3();
//    	a.method4();
    	a.method5();
	}
}
