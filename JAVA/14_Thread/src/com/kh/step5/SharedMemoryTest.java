package com.kh.step5;

// 스레드들은 공유자원을 서로 공유한다
public class SharedMemoryTest {

	public static void main(String[] args) {

		Calculator cal = new Calculator();

		User1 user1 = new User1();
		user1.setCalculator(cal);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalculator(cal);
		user2.start();

	}

}
