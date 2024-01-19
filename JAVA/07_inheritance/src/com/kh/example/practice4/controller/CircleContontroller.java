package com.kh.example.practice4.controller;

import com.kh.example.practice4.model.Circle;

public class CircleContontroller {
	
	private Circle c = new Circle();	
	
	// String이 반환타입 void아니면 return으로 
	public String calcArea(int x, int y, int radius) {
		// 넓이 : PI * 반지름 * 반지름
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c + " / 넓이 : " + (Math.PI * radius * radius);		
	}
	
	public String calcCircum(int x, int y, int radius) {
		//둘레 : PI * 반지름 * 2
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		return c +  "둘레 : " + (Math.PI * radius *2);
	}	
}
