package 과목평가3회차출제;

import java.util.Scanner;

// 백준 20361 일우는 야바위꾼
public class Algo1_도시_반_이름 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt(); //종이컵의 수
			int X = sc.nextInt(); //간식이 들어있는 종이컵 번호
			int K = sc.nextInt(); //컵의 위치를 바꾸는 횟수

			for (int k = 0; k < K; k++) {
				int cup1 = sc.nextInt();
				int cup2 = sc.nextInt();

				if (cup1 == X) // 방금 바꾼 컵에 있었네 ? 컵 위치 옮기기
					X = cup2;
				else if (cup2 == X)
					X = cup1;
			}
			System.out.println("#"+tc+" "+X);
		}
	}
}
