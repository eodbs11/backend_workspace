package com.kh.test5;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		ArrayList<Fruit> list = new ArrayList<>();

		for (int i = 0; i < list.length; i++) {
			list.add(new Fruit("사과", "빨강"));
			list.add(new Fruit("메론", "초록"));
			list.add(new Fruit("포도", "보라"));
			list.add(new Fruit("바나나", "노랑"));

			System.out.println(list);
		}

	}

}
