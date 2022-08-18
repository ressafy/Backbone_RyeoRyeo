package week_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *	모든 영역을 돌면서  BFS로 영역내에 집이 있는지 검사
 *   	
 *  422ms
 */
public class 교수님_홈방범서비스_BFS {
	static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static Queue<Node> queue;
	static boolean[][] visited;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] map;
	static int N, M, T, max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; ++t) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = 0;
			
			queue = new LinkedList<>();
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int r = 0 ; r < N ; ++r) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0 ; c < N ; ++c) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
//			도시의 모든 영역(노드)를 순회하면서 
			for(int r = 0 ; r < N ; ++r) {
				for(int c = 0 ; c < N ; ++c) {
//					bfs를 위한 초기화 
					init();
//					bfs로 house를 탐색한다. 
					bfs(r, c);
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
	
	private static void bfs(int r, int c) {
//		탐색을 시작할 도시를 큐에 넣고, 방문 체크 하기 
		queue.offer(new Node(r, c));
		visited[r][c] = true;
		
//		K는 1부터 시작, r,c에 해당하는 영역에 집이 있는 검사해서 house를 초기화 한다. 
		int K = 1;					
		int house = map[r][c] == 1 ? 1 : 0;
		
//		K=1일대의 운영 비용 계산하여 기존의 max 값을 갱신한다. 
		if(cost(K) <= house * M) {
			max = K > max ? K : max;
		}
		
		while(!queue.isEmpty()) {
			K++;
			//K에 등록된 영역의 만큼 반복 돌면서 
			for(int i = 0, size = queue.size() ; i < size ; ++i) {
//				Queue에서 영역 하나를 추출해서 
				Node cur = queue.poll();
				r = cur.r;
				c = cur.c;
//				4방을 탐색한다.
				for(int d = 0 ; d < 4 ; ++d) {
					int nr = r + dir[d][0];
					int nc = c + dir[d][1];
//					경계 밖이거나 	방문했다면 pass
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
					
//					다음 영역이 집이면 house 개수를 증가 시킨다. 	
					if(map[nr][nc] == 1) house++;
					
//					다음 영역을 큐에 넣고 방문 체크를 한다. 
					queue.offer(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
			
//			K 영역 내의 모든 영역을 확인했다면  운영 비용을 계산하여 max값을 갱신한다. 
			if(cost(K) <= house * M) {
				max = house > max ? house : max;
			}
		}
		
	}
	
	/**운영 비용 계산 */
	private static int cost(int k) {
		return k * k + (k - 1) * (k - 1);
	}

	/**새로운 bfs를 하기 위한 초기화 */
	private static void init() {
		queue.clear();
		for(int r = 0 ; r < N ; ++r) {
			for(int c = 0 ; c < N ; ++c) {
				visited[r][c] = false;
			}
		}
	}
}