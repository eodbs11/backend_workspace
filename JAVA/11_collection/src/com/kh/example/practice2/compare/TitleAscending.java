package com.kh.example.practice2.compare;

import java.util.Comparator;

import com.kh.example.practice2.model.Song;

public class TitleAscending implements Comparator<Song>{

	/*
	 * 두 개의 매개값으로 전달된 객체를 비교
	 * 비교해서 같으면 0 반환, 
	 * 첫번째 객체가 뒤에 있어야 하면 양의 정수,
	 * 첫번쨰 객체가 앞에 있어야 하면 음의 정수
	 * */
	
	@Override
	public int compare(Song o1, Song o2) {
		return o1.getMusicname().compareTo(o2.getMusicname());
	}

}
