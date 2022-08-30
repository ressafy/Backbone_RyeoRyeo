package 기본문법;

public class DigitTest2 {
	
	public static void main(String[] args) {
		// 모래시계 모양의 숫자 출력하는 클래스
		int cnt = 1;
		for (int i = 0; i<5;i++) {
			if (i ==0) {
				for(int j = 0; j<5;j++) {
					System.out.print(cnt);
					System.out.print("  ");
					cnt++;
				}
			}else if(i == 4) {
				for(int j = 0; j<5;j++) {
					System.out.print(cnt);
					System.out.print(" ");
					cnt++;
				}
			} else if(i == 1) {
				System.out.print("   ");
				for (int j = 0;j<3;j++) {
					System.out.print(cnt);
					System.out.print("  ");
					cnt ++;
				}System.out.print("  ");
			}else if(i == 3) {
				System.out.print("  ");
				for (int j = 0;j<3;j++) {
					System.out.print(cnt);
					System.out.print("  ");
					cnt ++;
				}System.out.print("  ");
			}
			else if(i == 2){
				System.out.print("      ");
				System.out.print(cnt);
				cnt++;
				System.out.print("  ");
				}
			System.out.println();
		}
	}
}
			
			
		

