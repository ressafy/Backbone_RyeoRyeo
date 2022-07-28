package com.ssafy.jes;

import javax.swing.JFrame;

import com.ssafy.jes.ui.MyFrame;

public class Main {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);  // 좀 보기 좋게 바뀜
		MyFrame f = new MyFrame();
		f.setVisible(true);
		
	}

}
