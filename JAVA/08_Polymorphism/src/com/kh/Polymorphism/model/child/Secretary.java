package com.kh.Polymorphism.model.child;

import com.kh.Polymorphism.model.parent.Employee;

public class Secretary extends Employee{

	private String nameOfBoss;

	public Secretary() {
	}

	public Secretary(String name, int salary, String nameOfBoss) {
		super(name, salary);
		this.nameOfBoss = nameOfBoss;
	}

	public String getNameOfBoss() {
		return nameOfBoss;
	}

	public void setNameOfBoss(String nameOfBoss) {
		this.nameOfBoss = nameOfBoss;
	}

	@Override
	public String toString() {
		return super.toString() + "Secretary [nameOfBoss=" + nameOfBoss + "]";
	}	
	
	
}
