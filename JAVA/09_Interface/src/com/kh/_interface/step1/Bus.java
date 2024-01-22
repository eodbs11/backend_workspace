package com.kh._interface.step1;


public class Bus implements Vehicle{

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}

	
	public void checkFare() {
		System.out.println("승차요금을 채크합니다.");
	}


	@Override
	public void turn() {
		System.out.println("버스가 돕니다.");
	}
}
