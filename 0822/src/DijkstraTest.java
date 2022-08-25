import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {
	// 프림과 거의 비슷하다!! 근데 프림이 뭐냐 도대체
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		
		
		int [][] adjMatrix = new int[V][V];
		
		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// start -> end 로의 최단 경로
		int start = 0; // 출발 정점
		int end = 0; // 도착 정점
		// 다익스트라 알고리즘에 필요한 자료구조
		int [] D = new int[V]; // 출발지에서 자신으로 오는데 소요되는 최소비용
		boolean[] visited = new boolean[V]; // 처리한 정점 여부
		
		Arrays.fill(D, Integer.MAX_VALUE);
		// 출발 정점 처리
		D[start] = 0;
		
		int min, minVertex;
		
		for (int i = 0; i < V; i++) {
			//step 1. 미방문 정점 중 출발지에서 자신으로의 비용이 최대한 정점 선택 
			//방문해야하는 나머지 정점 중 출발지에서 가장 가까운 정점 찾기
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min>D[j]) {
					min = D[j];
					minVertex = j;
				}
			}
			
			//step 2. 방문처리
			visited[minVertex] = true;
			// if(minVertex == end) break;  // 출발지에서 모든 비용 다 구하는 것이 아니라 어느 지점까지의 최소비용을 구하고 싶다면 이 줄을 넣으면 된다.
			
			//step 3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 패스
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[minVertex][j] > 0 && D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
			// 방문한 적이 없으면서 adjMatrix[minVertex][j] 갈 수 있는지 체크이다. 인접 행렬에서 주어진 조건이 0이면 못가는 애들이다. 인접 행렬에서 구하는 것.
					D[j] = D[minVertex] + adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println(Arrays.toString(D));  // 이렇게 찍어보면 출발지에서 나머지 도착로까지가 잘 들어있나 확인할 수 있다.
		System.out.println(D[end]);
	}

}
