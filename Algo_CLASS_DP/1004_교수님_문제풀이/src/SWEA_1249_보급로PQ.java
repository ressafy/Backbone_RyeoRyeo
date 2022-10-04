import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1249_보급로PQ {
	static int N = 0,ans,INF = Integer.MAX_VALUE,dr,dc;
	static int[][] map;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j)-'0';
				}
			}

			sb.append("#"+tc+" "+dijkstra(0,0)+"\n");
		}
		System.out.println(sb);
	}
	
	private static int dijkstra(int startR, int startC) {
		//출발지에서 자신으로의 최소비용을 저장할 배열 생성 후 초기화
		int [][]minCost = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				minCost[i][j] = INF;
			}
		}
		
		// 출발지에서 출발지로의 최소비용 0 처리
		minCost[startR][startC] = 0;
		int r=0,c=0,nr,nc,minTime;
		
		
		// 다익스트라를 정점의 수만큼 다 돌리면 뭘 얻을 수 있냐
		// 이 남은 정점 최소비용 정점 찾기 
		// 이 경유해서 가는 다른 정점과의 비용을 다 따져본다....
		// 그리고 저 배열에 업데이트한다.
		
		// 지금 전체 다 돌면서 확인하는데 더 빠르게 PQ 를 쓰는 방법을 강구해보자
		// 우리는 도착지 G 까지 오는 최소 비용 원하는 목표 비용이 된다면 끝낼 것...
		while(true) {
			// step 1. 미방문 정점 중 최소 비용의 정점을 찾기
			r = c = -1; // 혹시 도달 못하는 경우를 체크해주기 위해서....
			minTime = INF;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j] && minTime > minCost[i][j]) {
						minTime = minCost[i][j];
						r = i;
						c = j;
					}
				}
			}
			// r,c 가 -1일 경우는 더이상 갈 수 있는 정점이 없다!!
			if(r == -1) return -1;
			
			visited[r][c] = true;
			if(r == N-1 && c == N-1) return minTime;// 이건 도착지점에 도착한 것이다.
			
			
			
			// step2. 현재 정점 기준으로 인접한 정점ㅁ들 들여다보며 경유 비용이 유리한지 계산
			// 인접 정점: 4방향이라서...
			for (int i = 0; i < 4; i++) {
				nr = r + dx[i];
				nc = c + dy[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] &&
						minCost[nr][nc] > minTime + map[nr][nc]) {
					minCost[nr][nc] = minTime + map[nr][nc];
				}
			}
			
			
		}
		
		
	}

}
