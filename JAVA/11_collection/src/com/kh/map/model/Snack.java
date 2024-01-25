package com.kh.map.model;

public class Snack {
	private String flavor;
	private int calorie;

	public Snack() {
	}

	public Snack(String flavor, int calorie) {
		this.flavor = flavor;
		this.calorie = calorie;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	@Override
	public String toString() {
		return "Snack [flavor=" + flavor + ", calorie=" + calorie + "]";
	}

}
