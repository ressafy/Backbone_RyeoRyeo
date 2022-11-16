package 그래프와순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_4193_수영대회_결승전 {
	private static int N;
	private static Pos start,goal;
	private static int[][] map;
	private static boolean[][] visited;
	
	private static class Pos{
		int i,j;

		public Pos(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= args.length; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			visited = new boolean[N][N];
			String [] arr;
			for (int i = 0; i < N; i++) {
				arr = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			} // 맵 입력
			arr = br.readLine().split(" ");
			start = new Pos(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
			arr = br.readLine().split(" ");
			goal = new Pos(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));
			// 입력 완료
			
			
		}
	}

}
