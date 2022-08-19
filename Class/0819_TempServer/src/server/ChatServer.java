package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import dto.Book;

public class ChatServer {
	List<ObjectOutputStream> list;
	List<Book> books;
	public static void main(String[] args) {
		// 서버 소켓 먼저 만들어야 한다. -> 생성자 만들어서 서버 소켓 만들자.
	
	}
	
	
	
	void broadcast(String msg) {
		synchronized(list) {
			for(ObjectOutputStream oos : list) {
				try {
					oos.writeObject(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	
	}
	
	
	
	
	ChatServer() throws Exception{
		ServerSocket ss = new ServerSocket(9999);
		list = new ArrayList<>();
		books = new ArrayList<>();
		books.add(new Book("a",20000));
		books.add(new Book("a",25000));
		System.out.println("Server ready");
		while(true) {
			Socket s = ss.accept();
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			synchronized(list) {
				list.add(oos);
				}
			}
			
			ServerThread t = new ServerThread(s,ois,oos);
			t.start();
		}
		
	}
	
	class ServerThread extends Thread{
		Socket s;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		public ServerThread(Socket s, ObjectInputStream ois, ObjectOutputStream oos) {
			this.s =s ;
			this.ois=ois;
			this.oos = oos;
		}
		@Override
		public void run() {
			oos.writeObject(books);
			oos.flush();
			
			try {
				while(true) {
					Object o = ois.readObject();
					if( o instanceof String) {
						String msg = (String) o;
						
					}
				}
			
			} catch (Exception e) {
				e.printStackTrace();
		}
		
	}
}
