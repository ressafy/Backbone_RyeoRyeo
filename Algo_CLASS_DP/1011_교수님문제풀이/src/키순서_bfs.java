import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 키순서_bfs {
	private static int N,M, adjMatrix[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adjMatrix = new int[N+1][M+1];
			
			StringTokenizer st = null;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjMatrix[a][b] = 1;
			}
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				if(gtBFS(i) + ltBFS(i) == N-1) answer++;
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	private static int gtBFS(int start) {  // start 학생부터 자신보다 키가 작은 학생따라 탐색
		int cnt = 0; // 나보다 작은 학생 수
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		que.offer(start);
		while(!que.isEmpty()) {
			int node = que.poll();
			
			for (int i = 1; i <= N; i++) {  // 인접행렬에서 자신의 열로 간선정보를 갖고있는 정점 들여다보기
				if(adjMatrix[i][node] == 1 && visited[i] == false) {  // i 가 node 보다 키가 작고 아직 탐색이 되지 않았다면 
					cnt ++ ;  // 나보다 작은 학생 카운트
					visited[i] = true;
					que.offer(i);
				}
			}
		}
		return cnt;
	}
	
	private static int ltBFS(int start) {  // start 학생부터 자신보다 키가 큰 학생따라 탐색
		int cnt = 0; // 나보다 큰 학생 수
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		que.offer(start);
		while(!que.isEmpty()) {
			int node = que.poll();
			
			for (int i = 1; i <= N; i++) {  
				if(adjMatrix[node][i] == 1 && visited[i] == false) {  // i 가 node 보다 키가 크고 아직 탐색이 되지 않았다면 
					cnt ++ ;  // 나보다 큰 학생 카운트
					visited[i] = true;
					que.offer(i);
				}
			}
		}
		return cnt;
	}

}
