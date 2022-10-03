package 그래프와순회;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS {
	private static Queue<Integer> que = new LinkedList<Integer>();
	private static int [][] map;
	private static boolean[] visited; 
	private static int N,M;
	private static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();  // node number
		M = sc.nextInt();  // line 
		int V = sc.nextInt();  // start node
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[y][x] = 1;
			map[x][y] = 1;
		} // 입력부 완
		
		dfs(V);
		visited = new boolean[N+1];
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}
	
	private static void dfs(int v) {
		
		// 재귀의 형식으로 구현을 한다. stack 을 사용하지 않아도 재귀를 이용하면 구현할 수 있다.
		visited[v] = true;
		sb.append(v).append(" ");  // 값을 꺼내서 처리할 작업...
		
		for (int i = 0; i <= N ; i++) {
			if(map[v][i] == 1 && visited[i] == false) {  // map 에 존재하고 방문하지 않았다면 
				dfs(i);
			}
		}
	}
	
	private static void bfs(int v) {  // 탐색 시작 노드부터 넣어준다.
		que.add(v);  // 먼저 큐에 넣는다.
		visited[v] = true;  // 방문처리를 한다.
		while(!que.isEmpty()) {
			int node = que.poll();  // 들어간 노드를 꺼내서 
			sb.append(node).append(" "); // 꺼내서 작업할 것을 해주고 
			for (int i = 1; i <= N ; i++) {  // N 그니까 노드의 수만큼 반복을 하면서 (1부터인 이유는 하나는 이미 꺼냈으니까 안봐도 됨)
				if(map[node][i] == 1 && visited[i] == false) {  // map 에 존재하고 방문하지 않았으면
					que.add(i);  // 큐에 넣어주고 
					visited[i] = true; // 방문처리 
					// 이러면 이제 다시 while 에 걸리고 작업을 반복하게 된다.
				}
			}
		}
	}
}
