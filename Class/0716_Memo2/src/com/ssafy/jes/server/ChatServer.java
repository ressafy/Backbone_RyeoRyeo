package com.ssafy.jes.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class ChatServer {
	
	private ChatServer() {
		
		try(ServerSocket ss = new ServerSocket(8888);){
			System.out.println("Chat Server Ready....");
			while(true) {
				Socket s = ss.accept();  // 이걸로 기다리는중
				System.out.println(s.getRemoteSocketAddress()+" 접속됨");
				DataInputStream in = new DataInputStream(s.getInputStream());
				// 읽기 위해 대기하는 것
				System.out.println("받은 메세지:"+in.readUTF());
			}
		} catch (IOException e){
			System.out.println("Server Soket accept 오류");
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new ChatServer();
	}

}
