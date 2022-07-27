package com.ssafy.jes;

import com.ssafy.jes.ui.MyFrame;

public class Main {

	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		f.setVisible(true);  // 내부적으로 쓰레드 하나 더 생긴다. 화면에 그려진 상태를 붙들고 있는다.
		// 메인 스레드(데몬스레드)는  안의 서브 스레드가 다 죽어야 끝날 수 있다.
		// visible true 는 마지막에
	}

}
