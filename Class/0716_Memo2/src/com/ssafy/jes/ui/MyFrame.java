package com.ssafy.jes.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	TextField tf;
	TextArea ta;
	Panel p;
	Button b;
	Frame f = new Frame();
	MenuBar mb;
	Menu fileMenu,editMenu;
	MenuItem openItem,saveItem;
	FileDialog openDialog,saveDialog;
	Socket s;
	public MyFrame() {
		createComponent();
		addComponent();
		setComponent();
		addEventHandling();
	}
	
	public void addEventHandling() {
		
		tf.addActionListener(e ->{
			try {
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
				out.writeUTF(tf.getText());
				// 입력한 것을 적는 것
			} catch (IOException e1) {
				System.out.println("메세지 전송 오류");
				e1.printStackTrace();
			}
		});
		
		
		saveItem.addActionListener(e ->{  // actionPerformed(ActionEvent e)
			saveDialog.setVisible(true);
			try(FileWriter fw = new FileWriter(saveDialog.getDirectory()+saveDialog.getFile());) {
				fw.write(ta.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		openItem.addActionListener(e -> {
			openDialog.setVisible(true);
			// 이 형태가 try with resources이다. : auto closing ==> AutoClosable interface
			try(FileReader fr = new FileReader(openDialog.getDirectory()+openDialog.getFile());  
					BufferedReader br = new BufferedReader(fr);) {  //JVM이 얘네가 close 되어야할 애들인지 어케 아냐?
				String oneLine = "";
				ta.setText("");
				while((oneLine = br.readLine()) != null) {
					ta.append(oneLine+"\n");
				};
			} catch(FileNotFoundException ex) {
				System.out.println("ERR01"); // 이렇게 설정을 해준다. 비즈니스 서비스에서 IO 가 퍼포먼스를 매우 나쁘게 해준다. 하나만 있어도 3배는 나빠진다.
			}catch (IOException ex) {
				ex.printStackTrace();  // 이게 있어야 개발에 편한데 실행에 있어서는 다른 것을 써야한다.
			} 
		});
		
		b.addActionListener(e ->{
			//채팅 서버에 연결
			try {
				s = new Socket("localhost",8888);
				ta.append("채팅 서버에 접속되었습니다.\n");
			} catch (UnknownHostException e1) {
				ta.append("UnknownHostException\n");
				e1.printStackTrace();
			}catch (IOException e1) {
				ta.append("IOException\n");
				e1.printStackTrace();
			} 
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void setComponent() {
		setSize(400,400);
		setBackground(Color.PINK);
	}
	
	public void addComponent() {
		add(ta);
		add(p,BorderLayout.SOUTH);
		p.add(tf);
		p.add(b);
		
		setMenuBar(mb);
		mb.add(fileMenu);
		mb.add(editMenu);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
	}
	
	public void createComponent() {
		tf = new TextField(20);
		ta = new TextArea();
		p = new Panel();
		b = new Button("chat open");
		mb = new MenuBar();
		fileMenu = new Menu("file");
		editMenu = new Menu("edit");
		openItem = new MenuItem("open");
		saveItem = new MenuItem("save");
		openDialog = new FileDialog(this, "open***", FileDialog.LOAD);
		saveDialog = new FileDialog(this, "save***", FileDialog.LOAD);
	}
	
	

	
}
