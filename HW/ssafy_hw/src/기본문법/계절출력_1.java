package 기본문법;

import java.util.Scanner;

public class 계절출력_1 {
	int month = 0;
	
	public int input_m() {
		System.out.print("월 입력>>");
		Scanner sc = new Scanner(System.in);
		month = sc.nextInt();
		return month;
	}
	
	public void findS(int month) {
		if (month >= 3 && month <=5) {
			System.out.println(month + "월은 봄입니다.");
		}else if (month >= 6 && month <=8) {
			System.out.println(month + "월은 여름입니다.");
		}else if (month >= 9 && month <=11) {
			System.out.println(month + "월은 가을입니다.");
		}else {
			System.out.println(month + "월은 가을입니다.");
		}
	}

	public static void main(String[] args) {
		계절출력_1 s = new 계절출력_1();
		for(int i = 0; i<3;i++) {
			s.findS(s.input_m());
		}
		
	}
}
