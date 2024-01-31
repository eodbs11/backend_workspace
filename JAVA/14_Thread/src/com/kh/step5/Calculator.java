package com.kh.step5;

/*
 * 동기화(Synchronized)
 * - 스레드가 사용중인 객체의 작업이 끝날때 까지 사용중인 객체에 잠금을 걸어서
 * 	 다른 스레드가 접근할 수 없도록
 * - 동기화 메서드가 객체 내에 여러개 있을 경우 스레드가 이들중 하나를 실행하면
 * 	 다른 스레드는 해당 메서드는 물론이고 객체 내의 다른 동기화 메서드도 실행할 수 없다
 * */

public class Calculator {

	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized  void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}

}
