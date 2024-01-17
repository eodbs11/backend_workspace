package com.kh.example.practice2.controller;

import java.util.Scanner;

import com.kh.example.practice2.model.Snack;

public class SnackController {
	
	Scanner sc = new Scanner(System.in);
	
	private Snack s = new Snack();
	
	public String saveData( String kind, String name, String flavor, 
							int numOf, int price) {
		
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		System.out.println("서버 시작!");
		
		System.out.println(kind + ", " + name + ", "+ flavor + ", "
							+ numOf + ", " + price);
		
		return "저장 완료되었습니다.";
		
	}
	public String confirmData() {
		
		return s.getKind() + "(" + s.getName() + " - " + s.getFlavor() + ") " 
				+ s.getNumOf() + "개 " + s.getPrice() + "원";
	}
}
