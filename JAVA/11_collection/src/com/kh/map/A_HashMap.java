package com.kh.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.list.model.Person;
import com.kh.map.model.Snack;

/*
 * Map
 * - key-value 쌍으로 저장
 * - 순서 없음
 * - 중복 : 키(key) X, 값(value) o
 * 
 * HashMap
 * - Map 인터페이스를 구현한 대표적인 컬렉션 클래스
 * */

public class A_HashMap {

	public static void main(String[] args) {
		A_HashMap a = new A_HashMap();
//		a.method1();
		a.method2();
	}

	public void method1() {
		Map<String, Integer> map = new HashMap<>();
		map.put("웨하스", 250);
		map.put("고래밥", 180);
		map.put("칸쵸", 800);
		map.put("나쵸", 450);

		System.out.println(map);

		// 1. 키만 가져오기
		Set<String> key = map.keySet();
		System.out.println(key);

		// 2. 값만 가져오기
		Collection<Integer> col = map.values();
		System.out.println(col);

		// 3. 키에 해당하는 value 값 가져오기
		Iterator<String> it = key.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name + " : " + map.get(name));
		}
		System.out.println("----------------------------------");
		for (String s : key) {
			System.out.println(s + " : " + map.get(s));
		}

		/*
		 * 4. entrySet - Map 컬렉션에 있는 Entry 객체(key, value 쌍으로 이루어진)를 Set 컬렉션에 담아서 반환 -
		 * 반환된 Set 컬렉션에서 반복자를 얻어서 반복 처리
		 */

		Set<Entry<String, Integer>> entrySet = map.entrySet();
		System.out.println(entrySet);
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public void method2() {
		Map<String, Snack> map = new HashMap<>();

		map.put("웨하스", new Snack("치즈", 240));
		map.put("웨하스", new Snack("딸기", 255));
		map.put("고래밥", new Snack("양념치킨", 173));
		map.put("자유시간", new Snack("아몬드", 232));
		map.put("칸쵸", new Snack("딸기 요거트", 880));
		map.put("홈런볼", new Snack("초코", 270));
		map.put("스윙칩", new Snack("볶음고추", 347));
		map.put("나쵸", new Snack("치즈", 486));
		map.put("꼬깔콘", new Snack("매콤달콤", 486));
		map.put("후렌치파이", new Snack("딸기", 486));

		System.out.println("과자의 개수 : " + map.size()); // 9 (웨하스 두개 중복)

		// 웨하스에는 뭐가 들어 있을까요
		System.out.println(map.get("웨하스"));

		// 키 값으로 삭제하기 - 꼬깔콘
		map.remove("꼬깔콘");
		System.out.println("과자의 개수 : " + map.size());

		// 1. 홈런볼에 대한 과자 정보 출력
		System.out.println(map.get("홈런볼"));

		// 2. 후렌치파이의 맛 정보 출력
		System.out.println(map.get("후렌치파이").getFlavor());

		// 3. 모든 과자의 칼로리 총합과 평균 출력
		int sum = 0;
		int avg = 0;

		for (String s : map.keySet()) {
			sum += (map.get(s).getCalorie());
			avg = (sum / map.size());
		}
		System.out.println("총합 칼로리 : " + sum + " / 칼로리 평균 : " + avg);
		
		System.out.println("-------------------------------------------");
		
		int sum2 = 0;
		
		for (String key : map.keySet()) {
			Snack snack = map.get(key);
			sum2 += snack.getCalorie();			
		}
		System.out.println("총합 칼로리 : " + sum2 + " / 칼로리 평균 : " + (sum2 / map.size()));
		
		
		System.out.println("-------------------------------------------");
		
		int sum1 = 0;
		Set<Entry<String, Snack>> entrySet = map.entrySet();
		for(Entry<String, Snack> entry : entrySet) {
			Snack snack = entry.getValue();
			sum1 += snack.getCalorie();
		}
		System.out.println("칼로리 총합 : " + sum1);
		System.out.println("칼로리 평균 : " + (sum1 / map.size()));
		
		// 모든 entry 객체 삭제
		map.clear();
		System.out.println("비어있는지 : " + map.isEmpty());
		System.out.println(map);
	}

}