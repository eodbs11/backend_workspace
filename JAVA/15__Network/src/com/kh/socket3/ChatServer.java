package com.kh.socket3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(3000);
			System.out.println("클라이언트 기다리는중....");
			
			while(true) {
			Socket socket = serverSocket.accept();
			//클라이언트가 접속할 때 마다 새로은 스레드 생성
			ClientThread client = new ClientThread(socket);
			client.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
