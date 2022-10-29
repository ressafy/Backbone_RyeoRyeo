package 그래프와순회;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS_다시풀어보기 {
	private static int [][] map;
	private static boolean [] visited;
	private static Queue<Integer> que = new LinkedList<Integer>();
	private static StringBuilder sb = new StringBuilder();
	private static int M,N,V;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // 노드의 수
		M = sc.nextInt();  // 간선의 수
		V = sc.nextInt();  // 시작 노드
		map = new int [N+1][N+1];  
		visited = new boolean [N+1];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			map[y][x] = map [x][y] = 1;
		}
		
		dfs(V);
		visited = new boolean [N+1];
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
		
	}
	
	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v).append(" ");
		for (int i = 0; i <= N; i++) {
			if(visited[i] == false && map[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int v) {
		que.add(v);
		visited[v] = true;
		sb.append(v).append(" ");
		while(!que.isEmpty()) {
			int temp = que.poll();
			for (int i = 1; i <= N; i++) {
				if(visited[i] == false && map[temp][i] == 1) {
					que.add(i);
					visited[i] = true;
					sb.append(i).append(" ");
				}
			}
		}
	}

}
