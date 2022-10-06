package a형대비보충수업;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7793_오나의여신님 {
	private static final int[] dx = {1,0,-1,0};
	private static final int[] dy = {0,1,0,-1};
	private static int N,M,ans;
	private static boolean[][] visit;
	private static char[][] map;
	private static Queue<Pos> q;
	private static Queue<Pos> Devilq;
	
	private static class Pos{
		int x,y,cnt;

		private Pos(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		private Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	/**
	 * 
	 * 악마랑 수연의 이동을 따로 큐에 나눠서 할 것이다. 
	 * 악마가 갈 수 있는 곳은 . 과 S 이다.
	 * 수연이 갈 수 있는 곳은 . 과 D 이다. 
	 * 수연이 D에 갔으면 cnt 를 올려줄 것이다.
	 * 
	 * **/
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			visit = new boolean[N][M];
			q = new LinkedList<>();
			Devilq = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				char[] ch = br.readLine().toCharArray();
				for (int j = 0; j < M; j++) {
					map[i][j] = ch[j];
					if(map[i][j] == '*') Devilq.add(new Pos(i,j));
					else if(map[i][j] == 'S') q.add(new Pos(i,j,0));
				}
			}  // 입력부 완
			ans = 0;
			bfs();
			if(ans == 0) System.out.println("#" + tc + " " + "GAME OVER");
			else  	     System.out.println("#" + tc + " " + ans);
		}
	}
	private static void bfs() {  // 손아귀와 수연이가 각각 돌아야 한다.
		int size = 0;
		while(!q.isEmpty()) {
			
			size = Devilq.size();
			for (int f = 0; f < size; f++) {
				Pos devil = Devilq.poll();  // 손아귀 위치 꺼낸다.
				for (int i = 0; i < 4; i++) {
					int nx = devil.x + dx[i];
					int ny = devil.y + dy[i];
					
					if((nx<0 || nx >=N || ny <0 || ny>= M)) {  // 맵 밖으로 나가는 경우 제외
						continue;
					}
					
					if(map[nx][ny] == '.' || map[nx][ny] == 'S') {  // 손아귀가 갈 수 있는 위치라면
						map[nx][ny] = '*';
						Devilq.add(new Pos(nx,ny));  // 이동한 곳에서 다시 bfs
					}
				}
			}
			
			size = q.size();
			for (int h = 0; h < size; h++) {
				Pos pos = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = pos.x + dx[i];
					int ny = pos.y + dy[i];
					
					if((nx<0 || nx >=N || ny <0 || ny>= M)) {  // 맵 밖으로 나가는 경우 제외
						continue;
					}
					if(map[nx][ny] == 'D') {  // 여신의 위치로 이동했다면
						ans = pos.cnt+1;
						return;
					}
					
					if(map[nx][ny] == '.') {  // 이동할 수 있는 땅으로 갔다면
						map[nx][ny] = 'S';
						q.add(new Pos(nx,ny,pos.cnt+1));
					}
				}
			}
		}
	}


}
