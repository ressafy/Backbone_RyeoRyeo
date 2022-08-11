package week_3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Matrix_bfs {
	static int n;
	static char [][] map;
	static boolean [][] visited;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int end = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/map.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		// 탐색
		bfs(0,0);
	
	}
	
	private static void bfs(int r, int c) {
		//큐 생성하기
		Queue<int[]> que = new LinkedList<>();
		//큐에 첫 노드를 추가
		que.offer(new int[] {r,c});
		// 방문 체크를 하연 속도가 줄어든다.
		visited[r][c] = true;  // 넣을 때 방문체크를 해야 수행 시간을 단축시킬 수 있다!!
		
			// 모든 노드를 탐색하기 위해서 큐에 노드가 없을 때까지 반복처리해줘야 한다.
			// 노드를 통해서 처리할 일을 작성 --> 출력
		while(!que.isEmpty()) {
			int [] cur = que.poll();
			r = cur[0];
			c = cur[1];
			System.out.print(map[r][c] + "->");
			// 노드에 인접한 노트를 (4방 탐색) 큐에 넣기 -> 그냥 넣으면 안되고 인접한 것을 탐색
			for(int i =0 , end = dr.length; i< end; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr < 0 || nr >= n||nc <0 || nc >= n ||visited[nr][nc]) continue;
				
				que.offer(new int[] {nr,nc});
				
				visited[nr][nc] = true;
			}
			// 인접한 노드가 경계내에 있어야 하고 방문안한 노드인지 검사
	
			// 인접한 노드를 큐에 넣기
			// 방문체크하기
			
		}
			
	}

}
