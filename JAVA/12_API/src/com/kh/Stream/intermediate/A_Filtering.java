package com.kh.Stream.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.kh.Stream.model.Student;

/*
 * 필터링
 * - 중간 처리 기능으로 요소를 걸러내는 역할 
 * */

public class A_Filtering {

	public static void main(String[] args) {

		A_Filtering a = new A_Filtering();
//		a.method1();
		a.method2();



	}

	// distinct : 중복 제거
	public void method1() {

		List<String> names = Arrays.asList("이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미", "정대윤", "이상호", "권예빈");
		Stream<String> stream = names.stream();
		stream.forEach(name -> System.out.print(name + " "));

		System.out.println();

		stream = names.stream();
		stream.distinct().forEach(name -> System.out.print(name + " ")); // 중복제거
		
		System.out.println();

		stream = names.stream();
		stream.forEach(name -> System.out.print(name + " "));
		
		System.out.println();

		List<Student> students = Arrays.asList(new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90),
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60));

		students.stream().distinct().forEach(student -> System.out.println(student));
	}

	// filter
	public void method2() {
		List<String> names = Arrays.asList("이상현", "정대윤", "이상호", "권예빈", "손민정", "정세영", "조세미", "정대윤", "이상호", "권예빈");
		
		names.stream()
			.filter(name -> name.startsWith("이"))
			.forEach(name -> System.out.println(name + " "));
		
	
		List<Student> students = Arrays.asList(
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60),
				new Student("이상호", 21, "남자", 50, 100),
				new Student("권예빈", 18, "여자", 60, 45),
				new Student("손민정", 22, "여자", 70, 90),
				new Student("이상현", 20, "남자", 80, 50),
				new Student("정대윤", 19, "남자", 75, 60));	
		
		
		System.out.println();
		
		// 성별이 여자인 요소만 출력		
		
		students.stream()
			.filter(student -> student.getGender().equals("여자"))
			.forEach(student -> System.out.println(student));
	
		System.out.println();

		
		// 수학 점수, 영어 점수 둘 다 60점 이상인 요소만 출력
		
		students.stream()
			.filter((Student student )-> { 
				return student.getMath()>= 60 && student.getEnglish()>= 60;
			});
		

		
		students.stream()
			.filter(student -> student.getMath()>= 60 && student.getEnglish()>= 60)
			.forEach(student -> System.out.println(student));
		
	}
	

}
