package 상속과다형성.김모씨;

import java.util.Scanner;

public class Kim {
	public static void bbalae() {
		drumWasher dw = new drumWasher();
		dw.on();
		dw.d_open();
		dw.d_close();
		dw.wash();
		dw.d_open();
		dw.off();
	}
	
	public static void dishWork() {
		dishWasher dishw  = new dishWasher();
		
		dishw.on();
		dishw.d_open();
		Scanner sc = new Scanner(System.in);
		System.out.println("접시 몇 장을 돌리시겠습니까...? (최대 10개)");
		int n = sc.nextInt();
		if(n<=10) {
			for(int i = 0;i<n;i++) {
				dishw.insertDish();
			}
		}else {
			System.out.println("최대 10개까지 입니다.");
		}
		dishw.wash();
		for(int i = 0;i<n;i++) {
			dishw.outDish();
		}
		dishw.outDish();
		dishw.d_close();
		dishw.off();
	}
	
	public static void aircon_go() {
		AirConditioner a = new AirConditioner();
		a.on();
		a.normal();
		a.power();
		a.off();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("사용법: bbalae 를 입력하면 bbalae의 과정이 자동으로 실행됩니다.\ndishwork를 입력하면 식기세척기 과정이 자동으로 실행됩니다.\naircon을 입력하면 aircon 동작이 일반냉방에서 파워냉방으로 진행됩니다.\ndishwork_dis를 입력하면 잘못된 동작을 보여줍니다.\n동작을 입력해주세요");
		String input = sc.nextLine();
		if(input.equals("bbalae")) {
			bbalae();
		}else if(input.equals("dishwork")) {
			dishWork();
		}else if(input.equals("aircon")) {
			aircon_go();
		}else if(input.equals("dishwork_dis")) {
			dishWasher dw = new dishWasher();
			System.out.println("접시를 무조건 꺼내보겠습니다.");
			dw.outDish();
			System.out.println("전원을 켜보겠읍니다.");
			dw.on();
			System.out.println("문 닫힘 상태에서 접시를 넣어보겠읍니다.");
			dw.insertDish();
		}else {
			System.out.println("잘못된 입력입니다. 사용법을 다시 읽어주세요");
		}
	    
		
		
		
		
	}

}

