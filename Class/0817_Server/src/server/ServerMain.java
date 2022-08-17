package server;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import dto.book.Book;
import dto.book.Magazine;
import dto.member.Member;
import util.ChatException;
import util.MyProtocol;
import util.Request;

import java.io.*;

public class ServerMain {
	
	ArrayList<ObjectOutputStream> list=new ArrayList<>();
	ArrayList<Member> memberList=new ArrayList<>();
	ArrayList<Book> books=new ArrayList<>();
	
	public synchronized void broadcast(String msg) throws ChatException {
		for(ObjectOutputStream out:list) {			
			try {
				out.writeObject(new MyProtocol(Request.res, null, msg));
			} catch (IOException e) {
				//클라이언트가 나갔을 때
				list.remove(out);
				throw new ChatException("1명 아웃");
				//e.printStackTrace();
			}
		}
		
	}

	
	
	ServerMain() throws Exception{
		ServerSocket ss=new ServerSocket(8888);
		System.out.println("server ready...");
		
		new Thread(()->{
			while(true) {	
				try {
					Socket s=ss.accept();
					ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
					ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
					list.add(oos);
					ServerRunnable r=new ServerRunnable(s,ois,oos);
					Thread t=new Thread(r);
					t.start();
				}catch(Exception e) {
					e.printStackTrace();
				}				
			}
		}).start();
		
		while(true) {
			Scanner sc=new Scanner(System.in);
			String cmd=sc.next();
			if("exit".equalsIgnoreCase(cmd)) {
				//save
				ArrayList<Book> books=new ArrayList<>();
				Book b1 = new Book("21424", "Java 프로그래밍", "조용준", "가메출판사", "p_book04_thum.png", 15000);
                Book b2 = new Book("35355", "토비의 스프링 3.1", "이일민", "에이콘", "p_book05_thum.png", 30000);
                Book b3 = new Book("12345", "Vue입문", "신대호", "로드북", "p_book03_thum.png", 50000);
                Magazine m1 = new Magazine("33333", "2인조 우리는 누구나 날 때부터 2인조다", "이석원", "jaen.kr", "e_book01_thum.png", 60000, 2013, 7);
                Magazine m2 = new Magazine("44444", "안녕, 소중한 사람", "정한경", "북로망스", "e_book02_thum.png", 70000, 2017, 5);
				books.add(b1);
				books.add(b2);				
				books.add(b3);
				books.add(m1);
				books.add(m2);
				
				try(FileOutputStream fos=new FileOutputStream("book.dat");
				ObjectOutputStream oos=new ObjectOutputStream(fos);){
					oos.writeObject(books);
					oos.flush();
					System.out.println("Book 파일 생성 완료");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				System.exit(0);
			}else if("load".equalsIgnoreCase(cmd)) {
				try(FileInputStream fis=new FileInputStream("book.dat");
				ObjectInputStream ois=new ObjectInputStream(fis);){
					books=(ArrayList<Book>) ois.readObject();
					
					//Collections.sort(list);
					
					/*
					 * list.sort((o1,o2)->{ return o1.getAge()-o2.getAge(); });
					 * 
					 */
					
					System.out.println(books);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}	
	
	
	class ServerRunnable implements Runnable{
		Socket s; 
		ObjectInputStream ois; 
		ObjectOutputStream oos;

		public ServerRunnable(Socket s, ObjectInputStream ois, ObjectOutputStream oos) {
			this.s=s;
			this.ois=ois;
			this.oos=oos;
		}

		@Override
		public void run() {			
			try {
				
				while(true) {
					MyProtocol p = (MyProtocol) ois.readObject();
					switch(p.getSign()) {
					case req: String msg=p.getMsg();
						try {
							broadcast(msg);
						} catch (ChatException e) {
							System.out.println(e.getMessage());
						}
							break;
					case firstReq: Member m=p.getM();
					        memberList.add(m);
							System.out.println(m);
							
							p=new MyProtocol(Request.firstRes, books);
							oos.writeObject(p);//첫 연결 시 책 정보 제공
							oos.flush();
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
			
			
		}//more oop
		
	}

	public static void main(String[] args) throws Exception {
		new ServerMain();

	}

}






