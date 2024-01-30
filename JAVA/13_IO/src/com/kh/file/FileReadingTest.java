package com.kh.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 문자 기반 스트림
 * - 문자 데이터를 읽고 출력할 때 사용
 * - Reader, Writer : 문자 기반 입출력 스트림의 최상위 클래스
 * */

public class FileReadingTest {

	String fileName = "src/test.txt";
	String outfileName = "src/result.txt";

	public static void main(String[] args) {
		FileReadingTest f = new FileReadingTest();
//		f.fileSave();
//		f.fileRead();
//		f.method1();
		f.method2();
	}

	public void fileSave() {
		// FileWriter를 사용해서 파일을 생성하고 데이터를 문자단위로 저장

		// try -with-resource 문을 통해서 사용한 리소스를 자동으로 close()
		// true 쓰면 뒤에 텍스트 추가 false는 이전 텍스트 삭제 후 텍스트 추가
		try (FileWriter fw = new FileWriter(fileName, true)) {

			fw.write("IO 재밌나요?\n");
			fw.write("아닌가요 ㅠㅠ?\n");
			fw.write("뭐가 되었든 끝납니다!\n");
			fw.write("오전 수업 끝!\n");

			fw.flush(); // 강제로 자료 출력
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * fw = null; try { fw = new FileWriter(fileName);
		 * 
		 * fw.write("IO 재밌나요?\n"); fw.write("아닌가요 ㅠㅠ?\n"); fw.write("뭐가 되었든 끝납니다!\n");
		 * 
		 * fw.flush(); // 강제로 자료 출력
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } finally { try { fw.close();
		 * } catch (IOException e) { e.printStackTrace(); } }
		 */
	}

	public void fileRead() {
		// FileReader를 사용해서 파일에서 데이터를 문자 단위로 읽어온다
		try (FileReader fr = new FileReader(fileName)) {

			int data = 0;
			while ((data = fr.read()) != -1) {
				System.out.println((char) data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일에 있는 내용을 읽어서 한 줄 단위로 콘솔에 출력하는 로직
	// 보조스트림 BufferedReader : 버퍼(char[])에 데이터가 쌓이기를 기다렸다가 꽉 차게 될 시 한꺼번에 보냄
	public void method1() {
		try (
				FileReader fr = new FileReader(fileName); 
				BufferedReader br = new BufferedReader(fr);) 
		{
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 파일에 있는 내용을 읽어서 또 다른 파일로 출력하는 로직
	public void method2() {
		/*
		 * BufferedReader, BufferedWriter : 입출력 효율을 높이기 위해 버퍼 (char[])를 사용하는 보조스트림 -->
		 * 라인(line)단위로 입출력이 편리하다
		 * 
		 * PrintWriter : 프린터와 유사하게 출력하는 print(), println() 매서드를 가지고 있는 보조스트림
		 */
		try (
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				PrintWriter pw = new PrintWriter(new FileWriter(outfileName, true));
//				BufferedWriter bw = new BufferedWriter(new FileWriter(outfileName));
		) {
			String line = "";
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				// bw.write(line);
				// bw.newLine(); // 라인 구분자(개행문자)를 출력
				pw.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
