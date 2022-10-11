import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_dfs_역인접행렬로합치기 {
private static int N,M, adjMatrix[][], radjMatrix[][];
private static int Cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adjMatrix = new int[N+1][M+1];
			radjMatrix = new int[N+1][M+1];
			
			StringTokenizer st = null;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				radjMatrix[b][a] = adjMatrix[a][b] = 1;
			}
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				Cnt = 0;
				DFS(i,adjMatrix,new boolean[N+1]);
				DFS(i,radjMatrix,new boolean[N+1]);
				if(Cnt == N-1) answer++;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	private static void DFS(int start, int[][] adjMatrix, boolean[] visited) {  // start 학생부터 자신보다 키가 큰 학생따라 탐색
		visited[start] = true;
			for (int i = 1; i <= N; i++) {  // 
				if(adjMatrix[start][i] == 1 && visited[i] == false) {  // i 가 node 보다 키가 크고(i가 node 보다 키가 작은 경우) 아직 탐색이 되지 않았다면 
					
					Cnt ++ ;  // adjMatrix 전달 대상에 따라 달라 카운트
					DFS(i,adjMatrix,visited);
				}
		}
	}
	
	
	


}
