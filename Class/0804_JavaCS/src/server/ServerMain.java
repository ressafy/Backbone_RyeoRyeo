package server;

import java.net.*;

import util.ChatException;
import util.Myprotocol;
import util.Request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import dto.member.Member;

import java.io.*;

public class ServerMain {
	ArrayList<ObjectOutputStream> list = new ArrayList<>();
	ArrayList<Member> memberlist = new ArrayList<>();
	public synchronized void broadcast(String msg) throws ChatException {
		for (ObjectOutputStream out : list) {
			try {
				out.writeObject(new Myprotocol(Request.firstReq, null, msg));
			} catch (IOException e) { // 클라이언트가 나갔을 때
				list.remove(out);
				throw new ChatException("1명 아웃이다.");
			}
		}

	}

	ServerMain() throws Exception { // 이래야 생성자이다.
		ServerSocket ss = new ServerSocket(8888);
		System.out.println("Server ready...");
		
		new Thread(() -> {
			while (true) {
				memberlist.add(new Member("안려환",28));
				try {
					Socket s = ss.accept();
					ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
					ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
					list.add(oos);
					ServerRunnable r = new ServerRunnable(s, ois, oos);
					Thread t = new Thread(r);
					t.start();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}).start();
		
		while(true) {  // --> main
			Scanner sc = new Scanner(System.in);
			String cmd = sc.next();
			if("exit".equalsIgnoreCase(cmd)) {   // 앞에 상수를 넣는 것이 좋다. 포인터가 상수라 널포인터 익셉션이 떨어지지 않기 때문이다.
				//save
				memberlist.add(new Member("가려환", Integer.MIN_VALUE));  // 여기에 이걸 넣으면 맨 앞으로 오는줄알았는데 맨 뒤로 갔네; 언더플로우 나와서 부호를 빼버리고 아예 다른 수로 인식해버려서 그렇다.
				memberlist.add(new Member("나려환", 28));
				memberlist.add(new Member("다려환", 28));
				memberlist.add(new Member("라려환", 38));
				
				try{FileOutputStream foo = new FileOutputStream("member.dat");
				ObjectOutputStream oos = new ObjectOutputStream(foo);
				oos.writeObject(memberlist);
				oos.flush();
				System.out.println("Member 파일 생성 완료");
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.exit(0);
			}else if("load".equalsIgnoreCase(cmd)) {
				try{FileInputStream fis = new FileInputStream("member.dat");
					ObjectInputStream ois = new ObjectInputStream(fis);
					ArrayList<Member> list = (ArrayList<Member>)ois.readObject();  /// 극도로 중요!!!! 타입 캐스팅!!!! !!! 시험 나와요
					
					//비교할 수 있는 방법 1
					//콜렉션즈는 컴퍼러블 비교이다. 나 자신이다. 나 자신과 비교 !!!!! 꼭 공부하자
					Collections.sort(list);
					System.out.println(list);
					
					//비교할 수 있는 방법 2 (어레이리스트는 컴퍼레이터를 받아온다.
//					list.sort((o1,o2)->{  // 이게 컴페어 갖고있다. 인자 2개로 노래방기계처럼 비교
//						return o1.getAge() - o2.getAge();  // ArrayList 가 Member 만 갖고있어서 바로 getAge() 쓸 수 있다.
//					});
//					System.out.println(list);
					
				}catch(Exception e) {
					e.printStackTrace();
				}	
			}
		}
		
		

	}

	class ServerRunnable implements Runnable { // more OOP
		ObjectInputStream ois;
		ObjectOutputStream oos;
		Socket s;

		public ServerRunnable(Socket s, ObjectInputStream ois, ObjectOutputStream oos) {
			this.s = s;
			this.ois = ois;
			this.oos = oos;
		}

		@Override
		public void run() {

			try {
				while (true) {
					Myprotocol p = (Myprotocol) ois.readObject();
					switch (p.getSign()) {
					case req:
						String msg = p.getMsg();
						System.out.println(msg);  /// !!!!!!!!!!!!!!!여기 꼭 보자
						try {
							broadcast(msg);  // 누군가 out 되었을 때 마다
						} catch (ChatException e) {
							System.out.println(e.getMessage()+"\n");  // !!!!!!!!여기랑 같이
						}
						break;
					case firstReq: Member m = p.getM();
						memberlist.add(m);
						System.out.println(m);
						break;
					default:
						System.out.println("asdf");
						break;
					}
				}

			} catch (Exception e) {
				//list.remove(oos);
				try {
					broadcast("1명 아웃");
				} catch (ChatException e1) {
					System.out.println(e1.getMessage());
				}
			} 

		}

	}

	public static void main(String[] args) throws Exception {
		new ServerMain();

	}

}
