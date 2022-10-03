package week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 전쟁_전투 {
	
	private static Character map[][];
	private static boolean visit[][];
	private static int dy[] = { 1, 0, -1, 0 };
	private static int dx[] = { 0, 1, 0, -1 };
	private static int b = 0, w = 0, c = 0;
	private static int N, M;
	private static Queue <Pos> que = new LinkedList<>();
	
	static class Pos { // 위치를 받기 위함
		private int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		sc.nextLine();
		map = new Character[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		} // 입력부 완

		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {  // 방문하지 않은 곳에서
					c = 1;
					visit[i][j] = true;
					Pos po = new Pos(i,j);
					que.add(po);

					bfs();
					
					if(map[i][j]=='W')  // 흰 팀이 제곱이 되는지 파란 팀이 제곱이 되는지 
						w += c * c;
					else
						b += c * c;
				}

			}
		}
		sc.close();
		sb.append(w).append(" ").append(b);
		System.out.println(sb);
		
	}

	private static void bfs() {

		while (!que.isEmpty()) {
			
			Pos po = que.poll();
			int row = po.x;
			int col = po.y;
			
			// 이동
			for (int i = 0; i < dx.length; i++) {
				int nx = row + dx[i];
				int ny = col + dy[i];


				if (nx >= N || nx < 0 || ny >= M || ny < 0) // 범위 밖으로 나갔는지 체크한다.
					continue;
				if (visit[nx][ny])  // 방문 체크
					continue;
				if (map[nx][ny] != map[row][col])  // 값이 다른지 체크
					continue;

				c++;
				visit[nx][ny] = true;
				que.add(new Pos(nx,ny));

			}
		}

	}

}