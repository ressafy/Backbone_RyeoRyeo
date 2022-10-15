package 수업과제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 탈주범검거_다시 {
	
	private static class Pos{
		int R,C,time;

		public Pos(int r, int c, int time) {
			super();
			R = r;
			C = c;
			this.time = time;
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String [] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int M = Integer.parseInt(arr[1]);
			int R = Integer.parseInt(arr[2]);
			int C = Integer.parseInt(arr[3]);
			int L = Integer.parseInt(arr[4]);
			
			int [][] map = new int [N][M];
			for (int i = 0; i < N; i++) {
				arr = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}  // 입력부 완
			
			int answer = 0;
			Pos po = new Pos(R,C,1);
			Queue<Pos> list = new LinkedList<>();
			list.add(po);
		}
	}

}
