package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {

//		HashSet<Integer> lotto = new HashSet<>();
		ArrayList<Integer> lotto = new ArrayList<>();
		while (lotto.size() < 6) {

			int num = (int) (Math.random() * 45 + 1);
			if (lotto.contains(num)) {
				lotto.add(num);
			}
			lotto.add(num);
		}
		int count = 0;
		while (true) {

			ArrayList<Integer> myLotto = new ArrayList<>();
			while (myLotto.size() < 6) {
				int num = (int) (Math.random() * 45 + 1);
				if (!myLotto.contains(num)) {
					myLotto.add(num);
				}
			}
			count++;

			System.out.println("로또 번호 : " + lotto);
			System.out.println("내 번호 : " + myLotto);

			Collections.sort(lotto);
			Collections.sort(myLotto);

			// 멈추는 조건 : 로또번호와 내번호 일치
			if (lotto.equals(myLotto)) {
				System.out.println("횟수 : " + count);
				break;
			}

		}
	}
}
