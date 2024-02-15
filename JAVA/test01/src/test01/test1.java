package test01;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("문자열을 입력해 주세요 : ");
			String str = sc.nextLine();			
			if(str.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println(str.length() + "글자 입니다.");
			}
		}		
	}

}
