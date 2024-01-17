package com.kh.example.practice1.model;

public class Member {

	public String memberId;
	public String memberPwd;
	public String memberName;
	public String phone;
	public String email;
	public int age;
	public char gender;
	
	public void changeName(String name) {
		memberName = name;
	}
	
	public void printName() {
		System.out.println(memberName);
	}
	
	
}


/*
 * changeName(name:String):void
 * printName():void * 
 * 
 */