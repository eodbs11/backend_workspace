package com.kh.practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class D_CheckedException {

	/*
	 * CheckedException
	 * - Exception을 상속하고 있는 예외들을 checkedException이라 한다.
	 * - 컴파일 시 예외 처리 코드가 있는지 검사하는 예외
	 * - 예외 처리(try~catch, throws)가 되어 있지 않으면 컴파일 에러를 발생
	 * - 조건문이나 소스코드 수정으로는 해결이 되지 않는다.
	 * - 주로 외부에 매개체와 입출력이 일어날 때 발생한다.
	 * */
	
	public static void main(String[] args) {
		try {
			new D_CheckedException().method1();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void method1() throws IOException {
		throw new IOException();
		
	}
	
	// 여기서 다룰 코드는 뒤에 나옵니다 (IO) -> 파일 입출력
	public void method2() {
		
		try {
			FileInputStream fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
