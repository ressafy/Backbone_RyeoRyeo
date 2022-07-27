package com.ssafy.jes.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
// *로 통으로 가져와도 속도나 메모리에 끼치는 영향은 똑같다. 전부 가져오지 않고 특정한 것만 가져오기 때문이다.
// 사용하는 것만 적어주는 이유는 꼼꼼함 어필

// 생성자 쫓아가서 걔의  super에서  하위에 있는 생성자는  super생성자의  argument 안받는거 받는다. -> 힌트
public class MyFrame extends Frame{
	private TextField tf;
	private TextArea ta;
	private Button b1;  // 데이터는 무조건 private 해두자
	Panel p;
	MenuBar mb;
	Menu fileMenu, editMenu;
	MenuItem saveItem,openItem;
	
	public void createComponent() {
		b1 = new Button("b1");
		ta = new TextArea();
		tf = new TextField(20);
		p = new Panel();
		mb =new MenuBar();
		fileMenu = new Menu("file");
		editMenu = new Menu("edit");
		saveItem = new MenuItem("save");
		openItem = new MenuItem("open");
		
	}
	
	public void addComponent() {
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		
		
		mb.add(fileMenu);
		mb.add(editMenu);
		
		setMenuBar(mb);
		
		p.add(tf);
		p.add(b1);
		
		add(ta,BorderLayout.CENTER);
		add(p,BorderLayout.SOUTH);
	}
	
	public void setComponent() {
		setSize(400, 500);
//		Color bgColor = new Color(123,145,0);
		setBackground(Color.YELLOW);
	}
	
	public void eventHandling() {
		ta.addMouseWheelListener((e) -> {
			System.out.println("마우스 휠이 움직입니다.");
		});
		
		b1.addActionListener((e->{
			ta.append(tf.getText()+"\n");
			tf.setText("");
		}));
		
		// 가독성을 높이는 어나니머스 로컬 클래스 형태가 되었다.
		// b1.addActionListener(new 하고 ctrl spacebar 하면 이렇게 어나니머스 이너 타입으로 나온다.)
//		b1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ta.append(tf.getText()+"\n");
//				tf.setText("");
//			}// local 클래스이다. local 클래스의 별명은 어나니머스이다.  inner class 는 다른 바깥 클래스에서 안으로 들어오는 것 
//		});
		
		
		// 이건 람다식이다. 자바 8 서부터 사용가능한 이... 메서드와 함수는 다른 말이다. 
		// 함수는 독립적인, 메서드는 종속적인  자바에는 함수라는 말이 없다.
//		b1.addActionListener((ActionEvent e) ->{
//				ta.append(tf.getText()+"\n");
//				tf.setText("");
//			}// local 클래스이다. local 클래스의 별명은 어나니머스이다.  inner class 는 다른 바깥 클래스에서 안으로 들어오는 것 
//		);
		
		
		// 람다표현을 하려면 사용할 수 있는 메소드가 단 하나여야 한다.
//		// 가독성을 높이는 어나니머스 로컬 클래스 형태가 되었다.
//		addWindowListener(new WindowAdapter(){  // window adapter는 구현 안하는 부위 안보이게 가독성 높여주는
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.exit(0);
//			}
//		});
		
		
		// 가독성을 높이는 어나니머스 로컬 클래스 형태가 되었다.
			addWindowListener(new WindowAdapter(){  // window adapter는 구현 안하는 부위 안보이게 가독성 높여주는
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		
	}
	

	
	public MyFrame() {
		createComponent();
		addComponent();
		setComponent();
		eventHandling();

	}// end constructor
	
	
}  // end class
