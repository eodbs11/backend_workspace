package com.kh.step3;

public class BeepThread extends Thread {

	public void run() {
		// 띵띵띵띵띵을 5번 출력하는 작업
		for (int i = 0; i < 5; i++) {
			System.out.println("띵~");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}