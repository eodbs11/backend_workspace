package com.kh.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.kh.set.model.Person;

/*
 * TreeSet
 * - 저장과 동시에 자동 오름차순 정렬 (HashSet + 정렬)
 * - HashSet보다 데이터 추가, 삭제에 시간이 더 걸림
 * */

public class B_TreeSet {

	public static void main(String[] args) {
		B_TreeSet b =new B_TreeSet();
//		b.method1();
		b.method2();
	}

	public void method1() {
		Set<String> set = new TreeSet<>();
		
		// set에는 중복값 안됨
		set.add("라미란");
		set.add("공명");
		set.add("염혜란");
		set.add("박병은");
		set.add("라미란");
		set.add("라미란");
		
		System.out.println(set);
		System.out.println(set.size());
		System.out.println("라미란이 포함되어 있는가? " + set.contains("라미란"));
		
		set.remove("박병은");
		System.out.println(set);
		
		set.clear();
		System.out.println("비어 있는지? " + set.isEmpty());
	}

	public void method2() {
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("라미란", 48));
		set.add(new Person("공명", 29));
		set.add(new Person("염혜란", 47));
		set.add(new Person("박병은", 46));
		set.add(new Person("라미란", 48));
		set.add(new Person("라미란", 48));
		
		// 객체에 주소값을 가지고 비교하기 때문에 모두 다른 객체로 인식해서 중복 제거되지 X
		// 객체에 hashcode, equals 메서드 재정의 자동 생성
		System.out.println(set);
		
		for(Person p : set) {
			System.out.println(p);			
		}
		
		/*
		 * Iterator
		 * - 컬렉션에 저장된 요소를 접근하는데 사용하는 인터페이스
		 * - iterator()를 호출해서 Iterator를 구현한 객체를 얻어서 사용
		 * */
		Iterator<Person> it = set.iterator();
		while(it.hasNext()) { // 읽어올 요소가 있는지 확인
			System.out.println(it.next()); // 다음 요소를 읽어옴			
		}
	}
}
