package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import dto.Book;
public class Main {
	List<ObjectOutputStream> list;
	List<Book> books;
	
	private void setUp() {
		books.add(new Book("자바", 20000));
		books.add(new Book("알고리즘", 25000));
	}
	
	public void broadcast(String msg) {
		synchronized (list) {
			for(ObjectOutputStream oos:list) {
				try {
					oos.writeObject(msg);
				} catch (IOException e) {
					list.remove(oos);
					e.printStackTrace();
				}
			}
		}
	}
	
	Main() throws Exception{
		ServerSocket ss = new ServerSocket(9999);  //
		list = new ArrayList<>();
		books = new ArrayList<>();
		setUp();
		while(true) {
			System.out.println("Server ready...!");
			Socket s = ss.accept();  // 자동으로 block 되는
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			list.add(oos);
			ServerThread t = new ServerThread(s,ois,oos);
			t.start();
		
		}
	}

	public static void main(String[] args) throws Exception {
		new Main();
		
	}
	
	class ServerThread extends Thread{
		Socket s;
		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		public ServerThread(Socket s , ObjectInputStream ois, ObjectOutputStream oos) {
			this.s = s;
			this.ois = ois;
			this.oos = oos;
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					Thread.sleep(1000);
					oos.writeObject(books);
					String msg = (String) ois.readObject();
					broadcast(msg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
