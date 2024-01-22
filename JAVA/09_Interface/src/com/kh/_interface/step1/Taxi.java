package com.kh._interface.step1;

public class Taxi implements Vehicle{

	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}
	
	@Override
	public void turn() {
		System.out.println("택시가 달립니다.");
	}
	
}
