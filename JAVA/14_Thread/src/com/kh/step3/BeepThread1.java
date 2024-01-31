package com.kh.step3;

import java.awt.Toolkit;

public class BeepThread1 implements Runnable {

	public void run() {

		Toolkit tool = Toolkit.getDefaultToolkit();
		// 경고음 5번 울리는 작업
		for (int i = 0; i < 5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
