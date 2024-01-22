package com.kh._interface;

import com.kh._interface.step1.Bus;
import com.kh._interface.step1.Taxi;
import com.kh._interface.step1.Vehicle;
import com.kh._interface.step2.Audio;
import com.kh._interface.step2.Tv;

/*
 * 인터페이스(interface)
 * 
 * [접근제어자] interface 인터페이스명 {...}
 * 
 * - 인터페이스는 개발 코드와 객체가 서로 통신하는 접점 역할을 한다.
 * - 인터페이스에서 변수는 무조건 상수이다.
 * - 인터페이스에서 메서드는 무조건 추상메서드이다.
 * - 객체가 구현해야하는 기능이 있을 때 인터페이스에 추상메서드를 추가해서
 * 	 객체가 기능을 구형하도록 만들 수 있다.
 * - 인터페이스를 구현하려면 implements 키워드를 사용한다.
 * - 인터페이스는 다중 상속(구현)을 허용한다.
 * - 추상 클래스 보다 더 강한 규칙성, 강제성을 가진 것이 인터페이스다.
 * 
 * 추상클래스와 인터페이스
 * 공통점
 * 
 * - 객체 생성 안 되나, 참조 변수로는 사용이 가능하다 (즉, 다형성 적용)
 * - 상속(구현)하는 클래스에서 추상 매서드를 재정의하도록 강제한다.
 * 
 *  차이점
 *  - 추상클래스는 abstract 키워드로 클래스가 정의되어 있고, 클래스내에 변수, 메서드 생성
 *  - 인터페이스는 interface 키워드로 정의되어 있고 인터페이스 내에 변수, 메서드 생성 불가능
 *  
 *  extends와 implements
 *  - 클래스 간의 상속 관계일 때 : 자식 클래스명 extends 부모 클래스명
 *  - 클래스와 인터페이스의 구현 관계일 때 : 구현 클래스명 implements 인터페이스명, 인터페이스명 ...
 *  - 인터페이스 간의 상속 관계일 때 : 인터페이스명 extends 인터페이스명, 인터페이스명 ...  
 * */

public class Application {
	public static void main(String[] args) {
		// Vehicle v = new Vehicle(); <-- 인터페이스는 객체 생성 x
		Vehicle bus = new Bus();
		Vehicle taxi = new Taxi();

		bus.run();
		taxi.run();
		
		System.out.println();
		
		Tv tv = new Tv();
		tv.turnOn();
		tv.setVolume(-1);
		tv.turnOff();
		
		Audio audio = new Audio();
		audio.search("melon.com");
		audio.setVolume(-1);
		audio.turnOff();
	}
	
	/*추상 설계도 : 미완성 설계도, 인터페이스 : 기본설계도 */
	/* 예전 - 폭포수 vs 요즘 - 애자일 */
	
	
}
