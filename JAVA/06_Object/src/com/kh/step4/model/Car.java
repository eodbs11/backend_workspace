package com.kh.step4.model;

public class Car {
	/*
	 * 접근제어자(access modifier)
	 * - 클래스, 변수, 메서드, 생성자에 사용되어 외부로부터 접근을 제한
	 * 
	 * [+] public : 접근 제한이 전혀 없음
	 * [#] protected : 같은 패키지 내에서, 
	 * 				그리고 다른 패키지의 자손 클래스에서 접근 가능
	 * []default : 같은 패키지 내에서만 접근이 가능
	 * [-]private : 같은 클래스 내에서만 접근이 가능
	 * 
	 * * 접근제어자를 사용하는 이유
	 * - 외부로부터 데이터를 보호하기 위해서
	 * - 외부에서는 불필요하고, 내부적으로만 사용되는 부분을 감추기 위해서
	 * */
	private String color; //색상
	private String gearType; // 자동 or 수동
	private int door; // 문의 개수
	
	/*
	 * 생성자
	 * - 객체가 생성될 때마다 호출되는 '인스턴스 초기화 매서드'
	 * - 변수의 초기화 또는 객체 생성시 수행할 작업에 사용
	 * 
	 * 클래스명(타입 변수명, 타입 변수명, ...){
	 * 		//객체 생성 시 수행될 코드
	 *      /주로 변수의 초기화 코드 작성
	 * }
	 * 
	 * * 생성자 작성시 주의!
	 * - 반드시 생성자명은 클래스명과 동일(대/소문자 구분)
	 * - 반환형이 존재하지 않음 --> 만약 반환형을 쓰게 되면 메서드로 인식
	 * 
	 * 기본생성자(default constructor)
	 * - 매개변수가 없는 생성자
	 * - 클래스에 생성자가 하나도 없으면 컴파일러가 기본 생성자를 추가
	 * - 생성자가 하나라도 있으면 컴파일러는 기본 생성자를 추가하지 않음
	 * */
	// 생성자 오버로딩!
	
	public Car() {}
	
	public Car(String color, String gearType, int door) {
		// this : 자신을 가리키는 참조변수. 객체 주소가 저장되어있음
		//        모든 인스턴스 메서드에 지역변수로 숨겨진 채 존재
		// this.color = color;
		// this.gearType = gearType;
		this(color, gearType);
		this.door = door;
	}
	
	public Car(String color, String gearType) {
		this.color = color;
		this.gearType = gearType;		
	}

	// 오버라이딩 : 부모 클래스의 메서드를 자식 클래스에서 다시 재정의
	/*
	public String toString() {
		return "색상 : " + color +", 변속기 : " + gearType + ", 문의개수 : " + door;
	}
	*/
	
	@Override
	public String toString() {
		return "Car [color=" + color + ", gearType=" + gearType + ", door=" + door + "]";
	}
	

	
	
}