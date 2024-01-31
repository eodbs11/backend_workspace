package com.kh.step2;

public class Application {

	public static void main(String[] args) {

		// 1. Thread 생성
		GoThread go = new GoThread();
		ComeThread come = new ComeThread();
		
		Thread tgo = new Thread(go, "GoThread");
		Thread tcome = new Thread(come, "ComeThread");
		
		// 2. start 호출
		tgo.start();
		tcome.start();
		
	}

}
