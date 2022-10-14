package 수업과제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_2112_보호필름 {
	private static int [][] map, rmap;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String [] arr =br.readLine().split(" ");
			int D = Integer.parseInt(arr[0]);
			int W = Integer.parseInt(arr[1]);
			int K = Integer.parseInt(arr[2]);
			map = new int [D][W];
			rmap = new int [W][D];
			for (int i = 0; i < D; i++) {
				arr = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					rmap[j][i] = map[i][j] = Integer.parseInt(arr[j]);
					
				}
			}  // 입력부 완
			int cnt = 0;
			boolean check = false;
			Queue<Integer> que = new LinkedList<>();
			for (int i = 0; i < W; i++) {
				for (int j = 0; j < D; j++) {
					if(j+1 < W) {
						if(rmap[i][j] == rmap[i][j+1]) {
							cnt ++;
						}else {
							if(cnt > 2) {
								check = true;
							}
							cnt = 0;
						}
						
					}
				}
				if(check == false) {
					que.add(i);
				}
			} // 통과하지 못한 열 que에 담아둔다.
			
		}
	}
	
	

}
