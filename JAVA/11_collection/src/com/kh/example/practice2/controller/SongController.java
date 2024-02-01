package com.kh.example.practice2.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.kh.example.practice2.compare.ArtistDescending;
import com.kh.example.practice2.compare.TitleAscending;
import com.kh.example.practice2.model.Song;

public class SongController {

	private ArrayList<Song> list = new ArrayList<Song>();
	
	//싱글톤 패턴(Singleton pattern)
	// 디자인 패턴
	
	//1. 생성자는 private
	private SongController() {
		
	}
	
	//2. 유일한 객체를 담을 static 변수 
	private static SongController instance;
	
	//3. 객체를 반환하는 static 메서드
	public static SongController getInstance(){
		if(instance==null) instance = new SongController();
		return instance;
	}
	
	public boolean addLastList(String musicname, String singername) {
		if(!musicname.equals("") && !singername.equals("")) {
			return list.add(new Song(musicname, singername));
		}
		return false;
	}

	public boolean addFirstList(Song song) {
		if(!song.getSingername().equals("") && !singername.equals("")) {
			list.add(0, new Song(musicname, singername));
		}
		return false;
	}

	public ArrayList<Song> printAll() {
		return list;
	}

	public Song searchSong(String musicname) {
		for (Song song : list) {
			if (song.getMusicname().contains(musicname)) {
				return song;
				
			}
		}
		return null;
	}

	public Song removeSong() {
		for (Song song : list) {
			if (song.getMusicname().equals(musicname)) {			
				return list.remove(list.indexOf(song));
			
			}
		}
		return null;
	}

	public Song updateSong(String search, Song update) {

		for (Song song : list) {
			if (song.getMusicname().contains(search)) {
				System.out.println(song + "의 값이 변경 되었습니다.");
				list.set(list.indexOf(song), update);
			}
		}
		return update;
		
	}

	public ArrayList<Song> ascTitle() {

		ArrayList<Song> cloneList = (ArrayList<Song>) list.clone();
		Collections.sort(cloneList, new TitleAscending());
		return cloneList;
		
	}

	public ArrayList<Song> descArtist() {

		ArrayList<Song> cloneList = (ArrayList<Song>) list.clone();
		Collections.sort(cloneList, new ArtistDescending());
		return cloneList;
		
	}

	

}
