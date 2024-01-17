package com.kh.step5.model;

public class Book {
	
	/*
	 * 캡슐화(Encapsulation)
	 * - 정보은닉 : 외부에서 객체 접근하는데 있어서 정보를 숨기고 
	 * 				객체의 연산을 통해서만 접근이 가능하게 하는 것
	 * - 객체 내 정보손상, 오용을 방지하고, 데이터가 변경되어도 다른객체에 영향을 주지 x
	 * - 독립성이 좋고, 하나의 모듈처럼 사용이 가능
	 * */
	
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	
	
	public Book() {}

	public Book(String title, int price, double discountRate, String author) {
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}

	
	

	// getter, setter
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", discountRate=" + discountRate + ", author=" + author
				+ "]";
	}
	
}
