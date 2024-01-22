package com.kh._interface.step2;

public interface Volume {

	// 인터페이스 구성요소 = 상수 + 추상 메서드
	
	//인터페이스에서 멤버변수는 무조건 상수!
	/*public static final*/int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 인터페이스에서 메서드는 무조건 추상 메서드
	/*public abstract*/void setVolume(int volume);
	
}
