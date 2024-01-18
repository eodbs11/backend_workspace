package com.kh.Polymorphism.model.child;

import com.kh.Polymorphism.model.parent.Employee;

public class Manager extends Employee{
	private String dept;
	

	public Manager() {		
	}

	public Manager(String name, int salary, String dept) {
		super(name, salary);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + " / Manager [dept=" + dept + "]";
	}
	
	
}
