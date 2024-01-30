package com.kh.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * IO(Input / Output)
 * - 입력과 출력
 * - 두 대상 간의 데이터를 주고 받는 것
 * - 입력 : 키보드, 파일, 네트워크
 * - 출력 : 모니터, 파일, 네트워크
 * 
 * 스트림 (stream)
 * - 데이터를 운반하는 연결 통로
 * - 연속적인 데이터 흐름을 물(stream)에 비유
 * - 하나의 스트림으로 입출력을 동시에 수행할 수 없음(단방향 통신)
 * - 
 * */

public class ByteStreamTest {

	/*
	 * 바이트 기반 스트림 - 데이터를 바이트(byte) 단위로 주고 받는다 - 그림, 멀티미디어 등 바이너리 데이터를 읽고 출력할 때 사용 -
	 * InputStream, OutputStream : 바이트 기반 입출력 스트림의 최상위 클래스
	 * 
	 * 보조 스트림 - 스트림의 기능을 향상시키거나 새로운 기능을 추가하기 위해 사용 - 독립적으로 입출력을 수행할 수 없음
	 */

	public static void main(String[] args) {

		// 바이너리 데이터(이미지파일)을 읽어서 파일로 출력하는 로직

		FileInputStream fis = null;
		FileOutputStream fos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try {
			// 1. 먼저 기반 스트림을 생성한다.
			// FileInputStream, FileOutputStream : 파일에 입출력을 하기 위한 스트림
			fis = new FileInputStream("src/bird.jpg");
			fos = new FileOutputStream("src/bird_output.jpg");

			// 2. 기반 스트림을 이용해서 보조스트림을 생성한다.
			// DataInputStream, DataOutputStream : 기본형 타입으로 읽고 쓰는 보조스트림
			dis = new DataInputStream(fis);
			dos = new DataOutputStream(fos);

			// 3. 데이터를 읽어서 출력
			int data = 0;
			while ((data = dis.read()) != -1) {
				dos.write(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원반납
				fis.close();
				fos.close();
				dis.close();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
