package com.kh.test4.model;

public class Person {
	public String Name;

	public Person() {
	}

	public Person(String name) {
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "Person [Name=" + Name + "]";
	}

}
