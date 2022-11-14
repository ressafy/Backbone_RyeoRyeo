package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 등산로조성 {
	private static int [][] map;
	private static boolean [][] visited;
	private static Queue <Pos> po;
	private static Queue <Pos> bigpo;
	private static int [] dx={0,0,-1,1};
	private static int [] dy={-1,1,0,0};
	private static StringBuilder sb = new StringBuilder();
	private static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			po = new LinkedList();
			bigpo = new LinkedList();
			String [] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			visited = new boolean[N][N];
			map = new int [N][N];
			int temp = 0;
			for (int i = 0; i < N; i++) {
				arr = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
					if(temp < map[i][j]) temp = map[i][j];
				}
			}
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == temp) {
						bigpo.add(new Pos(j,i));
					}
				}
			} // 높은 봉우리들의 위치를 기록해둠
			while(!bigpo.isEmpty()) {
				po.add(bigpo.poll());
				int leng = 1;
				while(!po.isEmpty()) {
					Pos nu = po.poll();
					visited[nu.y][nu.x] = true;
					
					// 현재 이동한 위치보다 값이 작은 값이면 이동하면서 길을 내고 아니면 멈춤.
					int curx = nu.x;
					int cury = nu.y;
					boolean check = false ,used = false;
					for (int i = 0; i < 4; i++) {
						int nx = dx[i] + nu.x;
						int ny = dy[i] + nu.y;
						if(visited[ny][nx] == false && nx > 0 && nx < N && ny > 0 && ny < N && map[ny][nx] < map[cury][curx]) {
							check = true;
							po.add(new Pos(ny,nx));
							leng += 1;
						}
					}
					if(!check && !used) {  // 값이 작지 않은 값에 와서 깎고 길을 놓는 방법
						for (int j = 0; j < 4; j++) {
							int nx = dx[j] + nu.x;
							int ny = dy[j] + nu.y;
							if(visited[ny][nx] == false && nx > 0 && nx < N && ny > 0 && ny < N) {
								check = true;
								
								po.add(new Pos(ny,nx));
								leng += 1;
							}
						}
					}
					
				}
			}
		}
	}
}
