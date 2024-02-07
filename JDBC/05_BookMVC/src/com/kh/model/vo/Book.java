package com.kh.model.vo;

// VO(Value Object)
// : 한 개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체

public class Book {
	private int bkNo;
	private String bkTitle;
	private String bkAuthor;
	private int bkPrice;

	private Publisher publisher;

	public Book() {
	}

	public Book(int bkNo, String bkTitle, String bkAuthor, int bkPrice, Publisher publisher) {
		this.bkNo = bkNo;
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
		this.bkPrice = bkPrice;
		this.publisher = publisher;
	}

	public Book(String bkTitle, String bkAuthor) {
		this.bkTitle = bkTitle;
		this.bkAuthor = bkAuthor;
	}

	public int getBkNo() {
		return bkNo;
	}

	public void setBkNo(int bkNo) {
		this.bkNo = bkNo;
	}

	public String getBkTitle() {
		return bkTitle;
	}

	public void setBkTitle(String bkTitle) {
		this.bkTitle = bkTitle;
	}

	public String getBkAuthor() {
		return bkAuthor;
	}

	public void setBkAuthor(String bkAuthor) {
		this.bkAuthor = bkAuthor;
	}

	public int getBkPrice() {
		return bkPrice;
	}

	public void setBkPrice(int bkPrice) {
		this.bkPrice = bkPrice;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bkNo=" + bkNo + ", bkTitle=" + bkTitle + ", bkAuthor=" + bkAuthor + ", bkPrice=" + bkPrice
				+ ", publisher=" + publisher + "]";
	}

}