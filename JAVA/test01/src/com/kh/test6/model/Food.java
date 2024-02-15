package com.kh.test6.model;

public class Food {

	public String name;
	public int Kcal;

	public Food() {
	}

	public Food(String name, int kcal) {
		this.name = name;
		Kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return Kcal;
	}

	public void setKcal(int kcal) {
		Kcal = kcal;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", Kcal=" + Kcal + "]";
	}

}
