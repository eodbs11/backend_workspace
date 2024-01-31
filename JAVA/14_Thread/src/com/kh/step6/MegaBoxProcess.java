package com.kh.step6;

public class MegaBoxProcess {

	public static void main(String[] args) {
		MegaBoxUser user = new MegaBoxUser();
		
		Thread t1 = new Thread(user, "윤민영");
		Thread t2 = new Thread(user, "정회영");
		
		t1.start();
		t2.start();
		
	}
	
}
