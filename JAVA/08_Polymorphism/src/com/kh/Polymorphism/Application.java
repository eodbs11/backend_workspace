package com.kh.Polymorphism;

import com.kh.Polymorphism.model.child.Engineer;
import com.kh.Polymorphism.model.child.Manager;
import com.kh.Polymorphism.model.child.Secretary;
import com.kh.Polymorphism.model.parent.Employee;

/*
 * 다형성(Polymorphism)
 * - 하나의 객체 변수가 여러가지 모양과 모습을 가지는 능력
 * - 부모 타입으로 자식 객체를 형성하는 것
 * */

public class Application {
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee("이수근", 12000);
		Engineer eg1 = new Engineer("김영철", 56000, "Java", 200);
		Manager m1 = new Manager("강호동", 23000, "기획팀");
		Secretary s1 = new Secretary("서장훈", 34000, "강호동");
		
		System.out.println(e1);
		System.out.println(eg1);
		System.out.println(m1);
		System.out.println(s1);
		
		
		System.out.println();
		//다형성 방식으로 객체 생성 --> 부모타입으로 객체 타입이 가능하다
		Employee eg2 = new Engineer("김영철", 56000, "Java", 200);
		Employee m2 = new Manager("강호동", 23000, "기획팀");
		Employee s2 = new Secretary("서장훈", 34000, "강호동");
		
		System.out.println(eg2);
		System.out.println(m2);
		System.out.println(s2);
		
		// 다형성 + 객체 배열
	}
}
