package com.kh.step3;

public class BeepApplication {

	public static void main(String[] args) {

		// 1. Thread 생성
		BeepThread1 b1 = new BeepThread1();
		BeepThread2 b2 = new BeepThread2();
		
		Thread tb1 = new Thread(b1, "BeepThread");
		Thread tb2 = new Thread(b2, "BeepThread2");
		
		// 2. start 호출
		tb1.start();
		tb2.start();
		
	}

}
