package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 배열돌리기4 {
	private static int [][] map;
	private static boolean [][] visited;
	private static int R,C,S,N,M,K;
	private static Pos po;
	
	private static class Pos{  //ㄷ 다시 ㅜㅍㄹ기
		int i,j,dir,temp;

		public Pos(int i, int j, int dir, int temp) {
			super();
			this.i = i;
			this.j = j;
			this.dir = dir;
			this.temp = temp;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		K = Integer.parseInt(arr[2]);
		map = new int [N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			arr = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
	}
	
	
}
