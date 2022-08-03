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
		
	    bbalae();
		dishWork();
		aircon_go();
		
		
	}

}

