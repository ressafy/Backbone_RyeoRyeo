import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/**
 * BFS 로 돌면서 각 노드별로 갈 수 있는 노드 수만큼 (방문체크 대신에 cnt를 올려준다.)
 * 
 * 
 * **/

public class P081_SWEA5643_키순서_bfs {
	private static Queue <Pos> que = new LinkedList<Pos>();
	private static List<Pos> list = new ArrayList<Pos>();
	private static int[] list2;
	private static int ans,cnt;
	private static int [][] distance;
	private static StringBuilder sb = new StringBuilder();
	
	private static class Pos{
		int x,y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());  // 노드의 수
			int M = Integer.parseInt(br.readLine());  // 비교횟수
			distance= new int[N+1][N+1]; // 
			list2 = new int [N+1];
			
			for (int i = 0; i < M; i++) {
				String [] a = br.readLine().split(" ");
				int x = Integer.parseInt(a[0]);
				int y = Integer.parseInt(a[1]);
				
			}
			bfs();
			
		}
	}
	
	private static void bfs() {
		
		
	}

}
