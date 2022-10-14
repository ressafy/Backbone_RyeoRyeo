package 수업과제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 탈주범검거 {
	
	private static class Pos{
		int r,c,time;

		public Pos(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}
	
	private static int [][] map;
	private static boolean [][] visited;
	private static int[] dy = {-1, 0, 1, 0};  // 상 좌 하 우
	private static int[] dx = {0, -1, 0, 1};
	private static int[][] tunnel = {{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 1, 0}, 
			{0, 1, 0, 1}, {1, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}, {1, 1, 0, 0}};
	private static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String [] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);  // 세로
			int M = Integer.parseInt(arr[1]);  // 가로
			int R = Integer.parseInt(arr[2]); // 맨홀 세로
			int C = Integer.parseInt(arr[3]); // 맨홀 가로
			int L = Integer.parseInt(arr[4]); // 소요 시간
			map = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				arr = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}  // 입력부 완
			
			
			int answer = 0;
			Queue<Pos> list = new LinkedList<>();
			Pos po = new Pos(R,C,1);
			// start bfs 
			list.add(po);
			visited[R][C] = true;
			
			while(!list.isEmpty()) {
				Pos cur = list.poll();
				answer++;
				
				if(cur.time >= L) continue;
				
				int type = map[cur.r][cur.c];
				
				for (int i = 0; i < 4; i++) {
					if (tunnel[type][i] == 0) {
						continue;
					}
					int nx = cur.c + dx[i];
					int ny = cur.r + dy[i];
					
					if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
					
					if(!visited[ny][nx] && map[ny][nx] != 0) {
						if(tunnel[map[ny][nx]][(i+2) % 4] == 0) continue;
						
						list.offer(new Pos(ny,nx,cur.time+1));
						visited[ny][nx] = true;
					}
				}
				
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);
		
	}
	

}
