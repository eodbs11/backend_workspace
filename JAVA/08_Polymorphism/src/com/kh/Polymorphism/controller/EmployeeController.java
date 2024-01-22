package com.kh.Polymorphism.controller;

import com.kh.Polymorphism.model.child.Engineer;
import com.kh.Polymorphism.model.parent.Employee;

public class EmployeeController {
	// 각각 매개변수와 리턴값 뭘로 처리를 해야하는지!
	
	// 이름으로 사람 찾기
	public Employee findEmployeeByName(String name, Employee[] empArr) {
		for(Employee employee : empArr) {
			if(employee.getName().equals(name)) {
				return employee;
			}
		}
		return null;
	}
	
	// 찾은 사람의 연봉은? -> 한 사람의 연봉을 찾는 기능!
	public int getAnnualSalary(Employee e) {
		int annualSalary = e.getSalary() * 12;
		if(e instanceof Engineer) {
			Engineer engineer = (Engineer) e; // 부모 -> 자식 : 강제 형 변환!
			return annualSalary + engineer.getBonus();
		} 
		return annualSalary;
	}
	
	// 전체 사람들의 연봉 총합은?
	public int getTotalSalary(Employee[] empArr) {
		int sum = 0;
		for(Employee employee : empArr) {
			sum += getAnnualSalary(employee);
		}
		return sum;
	}
}