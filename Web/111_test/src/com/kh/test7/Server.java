package com.kh.test7;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket server;
		try {
			server = new ServerSocket(3000); // 포트번호 어디로 가야할지 서버가 설정해줌
			Socket s = server.accept();
		} catch (IOException e) {			
			e.printStackTrace();
		}	

	}

}

