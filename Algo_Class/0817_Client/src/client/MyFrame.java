package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dto.book.Book;
import dto.member.Member;
import util.MyProtocol;
import util.Request;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

	JPanel contentPane = new JPanel();
	JMenuBar menuBar = new JMenuBar();
	JMenu mnNewMenu = new JMenu("File");
	JMenu mnNewMenu_1 = new JMenu("Edit");
	JMenu mnNewMenu_2 = new JMenu("Chat");
	JMenuItem mntmNewMenuItem = new JMenuItem("Start...");
	TextArea textArea = new TextArea();
	TextField textField = new TextField();
	
	JFrame chatFrame=new JFrame("채팅 정보 입력");				
	JTextField chatIdField=new JTextField("a",20 );
	JTextField ageField=new JTextField("1",20);
	JButton chatBtn=new JButton("채팅 시작");
	
	String chatId;
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;	
	List<Book> books;
	JPanel panel;
	
	
	
	private JLabel imgLabel1,imgLabel2,imgLabel3 ;
	

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
					//e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		menuBar.setBounds(0, 0, 884, 23);
		contentPane.add(menuBar);		
		menuBar.add(mnNewMenu);		
		menuBar.add(mnNewMenu_1);		
		menuBar.add(mnNewMenu_2);		
		
		
		mnNewMenu_2.add(mntmNewMenuItem);		
		textArea.setBounds(663, 29, 211, 475);
		contentPane.add(textArea);		
		textField.setBounds(663, 510, 211, 23);
		contentPane.add(textField);
		
		panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(24, 48, 602, 223);
		contentPane.add(scrollPane);
		
		imgLabel1=new JLabel(new ImageIcon("book\\e_book01_thum.png"));
		imgLabel2=new JLabel(new ImageIcon("book\\e_book02_thum.png"));
		imgLabel3=new JLabel(new ImageIcon("book\\e_book03_thum.png"));
		
		panel.add(imgLabel1);
		panel.add(imgLabel2);
		panel.add(imgLabel3);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 300, 602, 233);
		contentPane.add(panel_1);
		
		
		chatFrame.getContentPane().setLayout(new FlowLayout());
		chatFrame.getContentPane().add(chatIdField);
		chatFrame.getContentPane().add(ageField);
		chatFrame.getContentPane().add(chatBtn);
		chatFrame.pack();
		
		setEvent();
		
	}

	private void setEvent() {
		//채팅 필드에 엔터를 쳤을 때
		textField.addActionListener(e->{			
			try {
				MyProtocol p=new MyProtocol(Request.req,null,chatId+textField.getText());
				oos.writeObject(p);
				textField.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
		});
		
		
		
		//채팅 시작 버튼 이벤트
		chatBtn.addActionListener(e->{
			String id=chatIdField.getText();
			int age=Integer.parseInt(ageField.getText());
			Member m=new Member(id,age);
			
			//Socket...
			try {
				s=new Socket("localhost",8888);
				oos=new ObjectOutputStream(s.getOutputStream());
				ois=new ObjectInputStream(s.getInputStream());
				
				oos.writeObject(new MyProtocol(Request.firstReq,m,null));
				oos.flush();//8kb		
				
				new Thread( ()->{
					
						// 서버에서 오는 내용을 계속 듣는 작업...
						while(true) {
							try {
								MyProtocol p=(MyProtocol) ois.readObject();
								switch(p.getSign()) {
								case firstRes: books=p.getBooks();
								
								for(Book book:books) {
									String imgName = book.getDesc();
									ImageIcon icon = new ImageIcon(imgName);
									JLabel label = new JLabel(icon);
									panel.add(label);
									label.revalidate();  // 그려낼 수 있는 엔진에 명령
									label.repaint();
									label.update(label.getGraphics());
								}
								
								break;
								default:textArea.append(p.getMsg()+"\n");
								}
								
							} catch (Exception ex) {					
								//ex.printStackTrace();
							} 
						}
				 }
				).start();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			
			textArea.append("채팅 시작\n");
			chatId="["+id+"]";
			
			chatFrame.setVisible(false);
			
		});
		
		//채팅 시작 메뉴아이템
		mntmNewMenuItem.addActionListener(e-> chatFrame.setVisible(true));
		
	}
}






