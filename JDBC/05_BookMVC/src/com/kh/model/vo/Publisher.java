package com.kh.model.vo;

public class Publisher {
	private int pubNo;
	private String pubName;
	private String phone;

	public Publisher() {
	}

	public Publisher(int pubNo, String pubName, String phone) {
		this.pubNo = pubNo;
		this.pubName = pubName;
		this.phone = phone;
	}

	public int getPubNo() {
		return pubNo;
	}

	public void setPubNo(int pubNo) {
		this.pubNo = pubNo;
	}

	public String getPubName() {
		return pubName;
	}

	public void setPubName(String pubName) {
		this.pubName = pubName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Publisher [pubNo=" + pubNo + ", pubName=" + pubName + ", phone=" + phone + "]";
	}

}
