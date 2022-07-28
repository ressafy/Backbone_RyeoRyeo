package com.ssafy.jes.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class ChatServer {
	
	ArrayList <DataOutputStream>list = new ArrayList();  // Object면 다 들어감
	// 이게 제네릭이다. 호모지니어스한 
	public  void broadcast(String msg) { // 동시성 문제를 피하기 위해서는 싱크로나이즈 밖에 없지만 성능에 영향 크게 끼침
		synchronized(list) {  // 이러면 싱크로 나이즈드 블럭이라고 한다. 성능 차이 많이 난다 싱크로나이즈드 메소드보다
			for(DataOutputStream out : list) {  // 실행시에 성능이 엄청 향상되었다. for-each 는 우측 리스트 이름
				try {
					out.writeUTF(msg);
				} catch (IOException e) {
					list.remove(out);
					System.out.println("브로드캐스트 오류");
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private ChatServer() {
		
		try(ServerSocket ss = new ServerSocket(8888);){
			System.out.println("Chat Server Ready....");
			while(true) {
				Socket s = ss.accept();  // 이걸로 기다리는중
				System.out.println(s.getRemoteSocketAddress()+" 접속됨");
				DataInputStream in = new DataInputStream(s.getInputStream());
				// 읽기 위해 대기하는 것
				
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				list.add(out);
				ServerThread t = new ServerThread(in, out);
				t.start();
			}
		} catch (IOException e){
			System.out.println("Server Soket accept 오류");
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new ChatServer();
	}
	
	class ServerThread extends Thread{
		DataInputStream in;
		DataOutputStream out;
		
		ServerThread(DataInputStream in, DataOutputStream out){
			this.in = in;
			this.out = out;
		}
		
		@Override
		public void run() {
			// 하고싶은 일..계속 클라이언트의 메세지를 받아주는 일
			try {
				while(true) {
					String msg = in.readUTF();
					System.out.println("받은 메세지:"+msg);
					broadcast(msg);
				}
			} catch (IOException e) {
				System.out.println("read 오류류류류류류류류류류류류");
				e.printStackTrace();
			}
		}
	}

}
