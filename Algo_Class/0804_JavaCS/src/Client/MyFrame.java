package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.books.Book;
import dto.member.Member;
import util.Myprotocol;
import util.Request;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame {

	private JPanel contentPane = new JPanel();
	JMenuBar menuBar = new JMenuBar();
	JMenu mnNewMenu = new JMenu("file");
	JMenu mnNewMenu_1 = new JMenu("Edit");
	JMenu mnNewMenu_2 = new JMenu("Chat");
	JMenuItem mntmNewMenuItem = new JMenuItem("Start");
	TextArea textArea = new TextArea();
	TextField textField = new TextField();
	JFrame chatFrame = new JFrame("채팅 정보 입력");
	JTextField chatIdField = new JTextField("a", 20);
	JTextField ageField = new JTextField("1", 20);
	JButton chatBtn = new JButton("채팅 시작");
	Socket s;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	String chatId;
	List<Book> books;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);

		setJMenuBar(menuBar);

		menuBar.add(mnNewMenu);

		menuBar.add(mnNewMenu_1);

		menuBar.add(mnNewMenu_2);

		mnNewMenu_2.add(mntmNewMenuItem);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		textArea.setBounds(351, 10, 223, 395);
		contentPane.add(textArea);

		textField.setBounds(351, 434, 223, 68);
		contentPane.add(textField);

		chatFrame.setLayout(new FlowLayout());
		chatFrame.add(chatIdField);
		chatFrame.add(ageField);
		chatFrame.add(chatBtn);
		chatFrame.pack();
		setEvent();
	}

	private void setEvent() {
		// 채팅 필드에 엔터를 쳤을 때
		textField.addActionListener(e -> {
			try {
				Myprotocol p = new Myprotocol(Request.req, null, chatId + textField.getText());
				oos.writeObject(p);
				textField.setText("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});

		// 채팅 시작 버튼
		chatBtn.addActionListener(e -> {
			String id = chatIdField.getText();
			int age = Integer.parseInt(ageField.getText());
			Member m = new Member(id, age);

			// socket
			try {
				s = new Socket("localhost", 8888);
				oos = new ObjectOutputStream(s.getOutputStream());
				ois = new ObjectInputStream(s.getInputStream()); // 한 번만 실행되게 하기 위함이다.
				oos.writeObject(new Myprotocol(Request.firstReq, m, null));
				oos.flush();
				new Thread(() -> {
					// 서버에서 오는 내용을 계속 듣는 작업
					while (true) {
						try {
							Myprotocol p = (Myprotocol) ois.readObject();
							switch (p.getSign()) {
							case firstRes: books = p.getBooks();
							textArea.append(books + "\n");
							break;
							default:textArea.append(p.getMsg() + "\n");
							}
							
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}

				}).start(); // 스레드 시작
			} catch (UnknownHostException e1) {
				//e1.printStackTrace();
			} catch (IOException e1) {
				//e1.printStackTrace();
			}

			textArea.append("채팅 시작\n");
			chatId = "[" + id + "]"; // 반복작업일 때는 StingBuffer
			chatFrame.setVisible(false);
		});
		// 채팅 시작 메뉴아이템
		mntmNewMenuItem.addActionListener(e -> chatFrame.setVisible(true)); // 누를 때마다 실행이 된다.
	}

}