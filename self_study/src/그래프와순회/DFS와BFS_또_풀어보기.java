package 그래프와순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와BFS_또_풀어보기 {
	private static int N,M,V;
	private static int [][] map ;
	private static boolean [] visited;
	private static Queue<Integer> que = new LinkedList<>();
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		V = Integer.parseInt(arr[2]);
		
		map = new int[N+1][N+1]; 
		for (int i = 0; i < M; i++) {
			arr = br.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			map[x][y] = 1;
			map[y][x] = 1;
		}
		// 입력부 완
		
		visited = new boolean [N+1];
		dfs(V);
		sb.append("\n");
		visited = new boolean [N+1];
		bfs(V);
		System.out.println(sb);
	}
	
	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		for (int i = 0; i <= N; i++) {
			if(map[v][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int v) {
		que.add(v);
		visited[v] = true;
		while(!que.isEmpty()) {
			int temp = que.poll();
			sb.append(temp).append(" ");
			for (int i = 0; i <= N; i++) {
				if(map[temp][i] == 1 && visited[i] == false) {
					que.add(i);
					visited[i] = true;
				}
			}	
		}
	
	}

}
