package com.kh.practice.model;

public class Member {

	private String name; // 이름
	private int age; // 나이
	private int cookCoupon; // 요리쿠폰 개수
	private Book book;// 대여중인 책 1권 -- 포함관계
	
	public Member() {
	}
	
	public Member(String name, int age, int cookCoupon, Book book) {
		this.name = name;
		this.age = age;
		this.cookCoupon = cookCoupon;
		this.book = book;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCookCoupon() {
		return cookCoupon;
	}

	public void setCookCoupon(int cookCoupon) {
		this.cookCoupon = cookCoupon;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", cookCoupon=" + cookCoupon + ", book=" + book + "]";
	}
	
	
	
}


