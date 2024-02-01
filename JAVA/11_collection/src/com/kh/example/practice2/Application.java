package com.kh.example.practice2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.example.practice2.compare.ArtistDescending;
import com.kh.example.practice2.compare.TitleAscending;
import com.kh.example.practice2.controller.SongController;
import com.kh.example.practice2.model.Song;

public class Application {

	private Scanner sc = new Scanner(System.in);
	private SongController control = SongController.getInstance();
	private ArrayList<Song> list = new ArrayList<Song>();

	public static void main(String[] args) {
		Application a = new Application();
		a.mainMenu();
	}

	public void mainMenu() {
		try {
			boolean check = true;

			while (check) {
				System.out.println("===== 메인 메뉴 =====");
				System.out.println("1. 마지막 위치에 곡 추가");
				System.out.println("2. 첫 위치에 곡 추가");
				System.out.println("3. 전체 곡 목록 출력");
				System.out.println("4. 특정 곡 검색");
				System.out.println("5. 특정 곡 삭제");
				System.out.println("6. 특정 곡 수정");
				System.out.println("7. 곡 명 오름차순 정렬");
				System.out.println("8. 가수 명 내림차순 정렬");
				System.out.println("9. 종료");
				System.out.print("메뉴 번호 입력: ");
				int menu = Integer.parseInt(sc.nextLine());

				switch (menu) {
				case 1:
					addLastList();
					break;
				case 2:
					addFirstList();
					break;
				case 3:
					printAll();
					break;
				case 4:
					searchSong();
					break;
				case 5:
					removeSong();
					break;
				case 6:
					updateSong();
					break;
				case 7:
					ascTitle();
					break;
				case 8:
					descArtist();
					break;
				case 9:
					check = false;
					System.out.println("종료");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다 : " + e.getMessage());
			mainMenu();
		}

	}

	// 마지막 위치에 곡 추가
	public void addLastList() {

		System.out.println("****** 마지막 위치에 곡 추가 ******");

		System.out.println("곡 명 : ");
		String musicname = sc.nextLine();

		System.out.println("가수 명 : ");
		String singername = sc.nextLine();

		boolean result = control.addLastList(new Song(musicname, singername));
		if (result) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}

	}

	public void addFirstList() {

		System.out.println("****** 첫 위치에 곡 추가 ******");

		System.out.println("곡 명 : ");
		String musicname = sc.nextLine();

		System.out.println("가수 명 : ");
		String singername = sc.nextLine();

		boolean result = control.addFirstList(new Song(musicname, singername));
		if (result) {
			Song song = new Song(musicname, singername);
			control.addFirstList(musicname, singername);
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}

	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		for (Song song : list) {
			System.out.println(song);
		}
	}

	public void searchSong() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.println("검색할 곡 명 : ");
		String musicname = sc.nextLine();

		Song song = control.searchSong(musicname);
		if (song != null) {
			System.out.println(song + "를 검색했습니다.");
		} else {
			System.out.println("검색한 곡을 찾지 못 했습니다.");
		}
	}

	public Song removeSong() {

		System.out.println("삭제할 곡 명 : ");
		String musicname = sc.nextLine();
		Song song = control.removeSong(musicname);
		if (song != null) {
			System.out.println(song + "을 삭제했습니다");
		} else {
			System.out.println("삭제할 곡이 없습니다");
		}

	}

	public void updateSong() {

		System.out.println("******곡 수정 ******");
		System.out.println("검색할 곡 명 : ");
		String search = sc.nextLine();

		System.out.println("수정할 곡 명 : ");
		String musicname = sc.nextLine();

		System.out.println("수정할 가수 명 : ");
		String singername = sc.nextLine();

		Song update = new Song(musicname, singername);
		Song song = control.updateSong(search, update);
		if (song != null) {
			System.out.println(song + "의 값이 변경 되었습니다");
		} else {
			System.out.println("수정할 곡을 찾지 못했습니다.");
		}
	}

	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");

		for (Song song : control.ascTitle()) {
			System.out.println(song);
		}
	}

	// 8.
	public void descArtist() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");		
		for (Song song : control.descArtist()) {
			System.out.println(song);
		}
	}

}
