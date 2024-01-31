package com.kh.socket2;

// 키보드로 입력받은 데이터를 읽어서 서버로 보낸다
// 다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔 창에 출력한다

public class ChatClient {

	public static void main(String[] args) {
		try {
			
			// 1. 소켓생성
			
			// 2. 스트림 (무한루프-> 클라이언트가 계속 입력하게 하려면)
		    // BufferedReader, InputStreamReader, System.in
			// PrintWriter <- s.getOutputStream ,true
			
					
			// 다시 서버가 보낸 메세지를 받아서 클라이언트 자신의 콘솔창에 출력한다(무한루프) 
			// BufferedReader, InputStreamReader <- s.getInputStream
			// line, serverMsg 
		} catch (Exception e) {
			
		}			
	}
}
