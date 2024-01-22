package com.kh._abstract.step2;

/*
 * 추상 클래스 용도
 * 
 * 1. 여러 종류의 피자를 만들 때
 * 		피자로서의 공통적인 부분(변수, 메서드)은 부모가 가진 성질을 자식에게 그대로 물려주고
 * 2. 반면 서로 다른 피자가 만들어지는 결정적인 부분은 추상 메서드로 자식에게 물려주어서
 * 		자식이 본인에 맞도록 직접 구현하도록 한다.
 * */

public abstract class Pizza {
	protected int price;
	protected String brand;
	public Pizza() {
	}
	public Pizza(int price, String brand) {
		this.price = price;
		this.brand = brand;
	}
	
	public void makePizza() {
		System.out.println(brand + " " + price + "원");
		dough();
		topping();
		bake();
		cut();
		box();
		System.out.println();
	}
	
	public void dough() {	
		System.out.println("피자 반죽과 함께 도우를 빚다");
	}
	
	public abstract void topping(); 
	
	
	public void bake() {	
		System.out.println("피자를 180도에서 10분간 구워낸다");
	}
	
	public void cut() {	
		System.out.println("피자를 8등분으로 자른다");
	}
	
	public void box() {	
		System.out.println("피자를 포장한다");
	}
}
