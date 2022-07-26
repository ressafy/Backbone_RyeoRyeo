package 기본문법;

public class 별찍기_개인공부 {

	public static void main(String[] args) {
//		int cnt = 0;
//		for(int i =1; i<5;i++) {
//			for(int j = 4;j>0;j--) {
//				if(i<j) {
//					System.out.print(' ');
//				}else {
//					System.out.print(cnt);
//					cnt++;
//				}
//			}
//			System.out.println();
//		}
		
//		int cnt = 1;
//		for(int i =2; i<7;i++) {
//			for(int j = 1; j<i;j++) {
//				System.out.print(cnt);
//				cnt ++;
//			}
//			System.out.println();
//		}
		
//		int cnt = 1;
//		for(int i =5;i>0;i--) {
//			for(int j = 0; j<i;j++) {
//				System.out.print(cnt);
//				cnt ++;
//			}
//			System.out.println();
//		}
		
		int cnt = 1;
		for(int i = 0; i<5;i++) {
			for(int j = 0; j<i;j++) {
				System.out.print(' ');
			}
			for(int j = 5; j>i;j--) {
				System.out.print(cnt);
				cnt++;
			}
			System.out.println();
			}

	}

}
