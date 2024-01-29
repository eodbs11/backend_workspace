package com.kh.Stream.intermediate;

import java.util.Arrays;

/*
 * 반복
 * - 요소 전체를 반복하는 역할
 * - peek : 중간 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * - forEach : 최종 처리 단계에서 전체 요소를 반복하면서 추가적인 작업을 하기 위해 사용
 * 
 * */

public class D_Looping {

	public static void main(String[] args) {

		int[] values = { 1, 2, 3, 4, 5 };

		// peek
		int sum = Arrays.stream(values)
					.filter(i -> i % 2 == 0)
					.peek(value -> System.out.println(value)).sum();
		System.out.println("1~5 중 짝수의 합계 : " + sum);

		// forEach 반복으로 끝내고 싶을 때
		Arrays.stream(values)
				.filter(i -> i % 2 == 0)
				.forEach(value -> System.out.println(value));
		System.out.println("1~5 중 짝수의 합계 : " + sum);
		
		System.out.println();
		
		// forEach  - sum을 쓰고 싶은 경우
				int sum2 =Arrays.stream(values)
						.filter(i -> i % 2 == 0)
						.sum();
				System.out.println("1~5 중 짝수의 합계 : " + sum2);			
		
	}

}
