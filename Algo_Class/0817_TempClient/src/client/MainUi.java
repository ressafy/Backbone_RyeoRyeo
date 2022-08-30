package client;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import dto.Book;
import javax.swing.JFrame;
import javax.swing.*;

public class MainUi {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JButton b = new JButton("start");
		p.add(b);
		f.add(p, BorderLayout.SOUTH);
		f.setBounds(300,300,400,500);
		f.setVisible(true);
		
		b.addActionListener(e -> {
			try {
				Socket s = new Socket("localhost",9999);
				System.out.println(s);
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				new Thread(() -> {
					while(true) {
						try {
							Object o =ois.readObject();
							if(o instanceof ArrayList<?>) {  // 와일드카드 ? 쓰면 된다.
								ArrayList<Book> books = (ArrayList<Book>)o;
								System.out.println(books);
							}else if (o instanceof String) {
								String msg = (String) o;
								System.out.println(msg);
							}
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}).start();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

}
