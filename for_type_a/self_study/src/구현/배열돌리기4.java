package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 배열돌리기4 {
	private static int [][] map;
	private static boolean [][] visited;
	private static int R,C,S,N,M,K;
	private static Pos po;
	
	private static class Pos{
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
		for (int i = 0; i < K; i++) {
			arr = br.readLine().split(" ");
			R =Integer.parseInt(arr[0])-1;
			C = Integer.parseInt(arr[1])-1;
			S = Integer.parseInt(arr[2]);
//			int x = (R+S) - (R-S);  // 그 줄의 첫 연산 횟수
//			int y = (C+S) - (C-S);
			po = new Pos(R-S,C-S,0,map[C-S][R-S]);
			move();
		}
	}
	
	private static void move() {
		while(true) {
			if(po.dir == 3 && po.i - 1 < 0) {  // 바깥 껍데기
				if(visited[po.i+1][po.j+1] == true) {
					break;
				}
			}  // 껍데기면서 대각선 안에 방문했으면 다 돈 것
			if(po.dir == 3 && visited[po.i-1][po.j] == true && visited[po.i+1][po.j+1] == true) {
				break;
			}  // 맨 안쪽까지 다 돌았다면
			
			//그게 아니라면
			switch(po.dir) {
			case 0:
				if(po.j+1<M && visited[po.i][po.j+1] == false) {
					visited[po.i][po.j+1] = true;
					int temp = po.temp;
					po = new Pos(po.i,po.j+1,0,map[po.i][po.j+1]);
					map[po.i][po.j+1] = temp;
					break;
				}else {
					po = new Pos(po.i+1,po.j,1,map[po.i][po.j+1]);
					break;
				}
			case 1:
				
			}
			
		}
	}

}
