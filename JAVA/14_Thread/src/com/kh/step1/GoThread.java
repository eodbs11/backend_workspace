package com.kh.step1;

public class GoThread extends Thread{

	public GoThread(String name) {
		super(name);
	}
	
	// 스레드가 작동하는 부분
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1000); // 지정된 시간동안 스레드를 멈추게 한다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String name = Thread.currentThread().getName();
			System.out.println("Currenthread :: " + name + ", " + i);
		}
	}
	
}
