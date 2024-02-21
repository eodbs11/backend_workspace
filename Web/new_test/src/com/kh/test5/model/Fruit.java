package com.kh.test5.model;

public class Fruit {

	public String name;
	public String color;

	public Fruit() {

	}

	public Fruit(String name, String color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", color=" + color + "]";
	}

}
