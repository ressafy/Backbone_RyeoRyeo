import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import dto.Book;

public class ChatUI extends JFrame {
	
	private JPanel contentPane;
	JTextArea textArea;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ChatUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(e -> {
			try {
				Socket s = new Socket("localhost",9999);
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				new Thread(() -> {
					while(true) {
						try {
							Object o = ois.readObject();
							if(o instanceof ArrayList) {
								ArrayList<Book> books = (ArrayList<Book>)o;
								for(Book book: books) {
									textArea.append(book.toString()+"\n")
								}
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}).start();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		
		});
		panel.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		contentPane.add(textArea, BorderLayout.CENTER);
	}

}
