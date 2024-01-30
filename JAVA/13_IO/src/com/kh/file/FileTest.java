package com.kh.file;

import java.io.File;
import java.io.IOException;

/*
 * File 클래스
 * - 파일과 디렉토리를 다루는데 사용되는 클래스
 * */

public class FileTest {

	public static void main(String[] args) {

		File file = new File("src/test.txt");

		System.out.println("파일명 : " + file.getName());
		System.out.println("절대 경로 : " + file.getAbsolutePath());
		System.out.println("상대 경로 : " + file.getPath());
		System.out.println("파일 용량 : " + file.length());
		System.out.println("파일 존재 여부 : " + file.exists());
		System.out.println("파일 여부 : " + file.isFile());
		System.out.println("디렉토리 여부 : " + file.isDirectory());

		// 만약 존재하지 않는 경로를 제시하면 IOException 발생
		File newFile = new File("src/temp/test.txt");
		try {
			// 존재하지 않는 폴더부터 만들기
			File tempDir = new File("src/temp");
			if (!tempDir.isDirectory()) {
				tempDir.mkdir();
			}
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
