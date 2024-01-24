package com.kh.practice.model;

public class Book {
	
	private String title;
	private boolean coupon;
	private int accessAge;
	
	public Book(String title, boolean coupon) {
		this.title = title;
		this.coupon = coupon;		
	}
	
	public Book(String title, int accessAge) {
		this.title = title;
		this.accessAge = accessAge;		
	}

	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	// boolean만 is
	public boolean isCoupon() {
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", coupon=" + coupon + ", accessAge=" + accessAge + "]";
	}
	
}
