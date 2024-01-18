package com.kh.composite.model;

/*
 * 클래스 간의 관계 : 상속 vs 포함
 * 	- 상속관계 : ~은 ~이다. (is - a)
 *  - 포함관계 : ~은 ~을 가지고 있다. (has - a)
 *  - 자바는 단일 상속만 허용(C++는 다중 상속 허용)
 *  - 클래스 간의 관계를 많이 맺을수록 재사용을 높이고 관리하기 쉽게 한다.
 * */

public class Customer {
	
	protected String name; // 고객이름
	protected String grade; // 고객등급
	protected int bonusPoint; // 보너스포인트
	protected double bonusRatio; // 보너스 적립 비율
	
	Product product; // 포함 관계
	
	public Customer() {	
		System.out.println("기본 생성자로 만듦!");
	}	
	
	public Customer(String name) {
		this.name = name;
		this.grade = "SILVER";		
		this.bonusRatio = 0.01;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public int getBonusPoint() {
		return bonusPoint;
	}
	
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	public double getBonusRatio() {
		return bonusRatio;
	}
	
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", grade=" + grade + ", bonusPoint=" + bonusPoint + ", bonusRatio="
				+ bonusRatio + "]";
	}	
	@Override // < -- 어노테이션! '이 매서드는 재정의 된 매서드이다.' 라고 명확히 알려주는 역할
	public boolean equals(Object obj) {
		Customer c =(Customer) obj; //다형성
		return this.name == c.name;
	}
	
	public int calcPrice(int price) {
		this.bonusPoint += price * bonusRatio;//보너스 포인트 계산
		return price;
		
	}
	
}
