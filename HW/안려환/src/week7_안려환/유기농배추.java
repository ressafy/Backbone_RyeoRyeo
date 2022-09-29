package week7_안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
	// bfs 다 까먹어버렸다...
	static int M, N, K;
	static int[][] cabbage;
	static boolean[][] visit;
	static int count;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		for (int c = 0; c < T; c++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			 M = Integer.parseInt(st.nextToken());
			 N = Integer.parseInt(st.nextToken());
			 K = Integer.parseInt(st.nextToken());
			cabbage = new int[M][N];
			visit = new boolean[M][N];
			count=0;

			for (int i = 0; i < K; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				cabbage[p1][p2] = 1;

			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (cabbage[i][j] == 1 && !visit[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] { x, y });

		while (!que.isEmpty()) {
			x = que.peek()[0];
			y = que.peek()[1];
			visit[x][y] = true;
			que.poll();
			for (int i = 0; i < 4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
					if (!visit[cx][cy] && cabbage[cx][cy] == 1) {
						que.add(new int[] { cx, cy });
						visit[cx][cy] = true;
					}
				}

			}

		}
	}
}