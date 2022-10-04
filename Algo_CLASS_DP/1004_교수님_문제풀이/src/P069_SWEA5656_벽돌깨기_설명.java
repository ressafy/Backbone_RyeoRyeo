import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P069_SWEA5656_벽돌깨기_설명 {
	private static int [][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String [] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int W = Integer.parseInt(arr[1]);
			int H = Integer.parseInt(arr[2]);
			map = new int [H][W];
			for (int i = 0; i < H; i++) {
				arr = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}  // 입력부 완
			
			/** 시뮬레이션 + 중복순열 + DFS/BFS 
			 * 	열 우선 탐색을 해야 하는 문제이다.
			 *  1. 구슬을 던진다.
			 *  	w 만큼 구슬을 떨어뜨릴 수 있다.
			 *  	떨어트린 자리에 또 떨어트릴 수 있다.
			 *  	중복 순열이다. 순서마다 값이 다르니까
			 *  	w 위치만큼 떨어트릴 수 있고 N 번 던질 수 있다. 
			 *  	W의 N 제곱이 된다. -> W의 최대는 12 N 은 4
			 *  2. 구슬에 맞는 벽돌 처리 (연쇄적 처리) => 부서지는 벽돌 동시에 모두 처리
			 *  	구슬에 맞은 벽돌 인접한 벽돌을 쭈욱 (N-1, 사방)
			 *  	탐색 => 벽돌(정점) 그래프로 볼 수 있다. 그래프의 탐색 문제다.
			 *  3. 부서진 벽돌 제거, 빈공간 없이 벽돌 내리기(중력 처리)
			 * **/
			
		}
	}

}
