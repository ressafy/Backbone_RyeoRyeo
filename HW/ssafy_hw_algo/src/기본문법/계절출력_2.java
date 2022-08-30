package 기본문법;

import java.util.Scanner;

public class 계절출력_2 {
	int month = 0;
	
	public int input_m() {
		System.out.print("월 입력>>");
		Scanner sc = new Scanner(System.in);
		month = sc.nextInt();
		return month;
	}
	
	public void findW(int month) {
		switch(month) {
		case 1:
			System.out.println("1월은 겨울입니다.");
			break;
		case 2:
			System.out.println("2월은 겨울입니다.");
			break;
		case 3:
			System.out.println("3월은 봄입니다.");
			break;
		case 4:
			System.out.println("4월은 봄입니다.");
			break;
		case 5:
			System.out.println("5월은 봄입니다.");
			break;
		case 6:
			System.out.println("6월은 여름입니다.");
			break;
		case 7:
			System.out.println("7월은 여름입니다.");
			break;
		case 8:
			System.out.println("8월은 여름입니다.");
			break;
		case 9:
			System.out.println("9월은 가을입니다.");
			break;
		case 10:
			System.out.println("10월은 가을입니다.");
			break;
		case 11:
			System.out.println("11월은 가을입니다.");
			break;
		case 12:
			System.out.println("12월은 겨울입니다.");
			break;
		}
	}

	public static void main(String[] args) {
		계절출력_2 s  = new 계절출력_2();
		int i = 0;
		while(i<3) {
			s.findW(s.input_m());
			i++;
		}
	}

}
