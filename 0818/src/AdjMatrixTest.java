import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
	static int [][] adjMatrix;
	static int N;
	static boolean [] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		adjMatrix = new int [N][N];
		visited = new boolean[N];
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1; // 무향 그래프
		}
		
		//bfs();
		dfs(0);
	}
	
	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.println((char)(cur+'A'));
		for (int i = 0; i < N; i++) {
			if(!visited[i] && adjMatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우
				dfs(i);
			}
		}
	}
	
	
	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		 visited = new boolean[N];
		
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.println((char)(cur+'A'));
			
			// 현 정점에 인접점들 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우
					visited[i] = true;
					queue.offer(i);
					
				}
			}
		}
		System.out.println();
	}
	
}
