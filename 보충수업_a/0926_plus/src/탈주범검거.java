import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈주범검거 {
	public static int[] dy = {-1, 0, 1, 0};
	public static int[] dx = {0, -1, 0, 1};
	public static int[][] dir = {{0, 0, 0, 0}, // 0 인덱스 때문에 0으로 두었고 이후 각 파이프 별 이동 가능 방향
			{1, 1, 1, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, 
			{1, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}, {1, 1, 0, 0}};
	static Queue<Pos> q;
	static int[][] map;
	static boolean[][] visited;
	static int n, m, r, c, l, time;
	static int ans = 0;
	
	static class Pos {
		int r,c,time;
		
		Pos(int r, int c, int time){
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			r = sc.nextInt(); // 맨홀 세로 위치
			c = sc.nextInt(); // 맨홀 가로위치
			l = sc.nextInt(); // 탈출 후 소요된 시간
			q = new LinkedList<>();
			map = new int[n][m];
			visited = new boolean[n][m];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					map[j][k] = sc.nextInt();
				}
			} // 입력부 완
			
			bfs();
			sb.append("#").append(i).append(" ").append(ans).append("\n");
			System.out.println("#"+i+" "+ans);
			
		}
	}
	
	private static void bfs() {
		q.offer(new Pos(r,c,1));
		visited[r][c] = true;
		while(!q.isEmpty()) {
			Pos po = q.poll();
			// 움직였으니까 1 더한다.
			ans++;
			
			if(po.time >= l) continue;  // l이 시간이니 
			
			int type = map[po.r][po.c];
			
			for (int i = 0; i < 4; i++) {
				if(dir[type][i] == 0) continue;  // 1이여야 움직인다.
				
				int nc = po.c + dx[i];
				int nr = po.r + dy[i];
				
				if (nc < 0 || nr < 0 || nc >= m || nr >= n) continue;  // 지도 밖으로 나가는 경우를 뺴준다.
				
				if (!visited[nr][nc] && map[nr][nc] != 0) { // 방문하지 않은 곳이면서 map 안에 있는 곳 중에서
					if (dir[map[nr][nc]][(i + 2) % 4] == 0) {
						continue;
					}
					
					q.offer(new Pos(nr, nc, po.time + 1));
					visited[nr][nc] = true;
				}
			}
		}
	}

}
