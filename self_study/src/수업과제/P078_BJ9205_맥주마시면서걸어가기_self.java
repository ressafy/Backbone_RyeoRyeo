package 수업과제;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class P078_BJ9205_맥주마시면서걸어가기_self {
	static final int INF = 9999999;
    static int N,distance[][],T;
    private static class Pos{
    	int x , y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
    	
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
        	N = sc.nextInt();
            List<Pos> list = new ArrayList<>();
            distance = new int[N+2][N+2];
            for (int i = 0; i < N+2; i++) { // 주어지는 편의점 + 집과 페스티벌 위치
				int x = sc.nextInt();
				int y = sc.nextInt();
				
			}
		}
        
        
	}

}
