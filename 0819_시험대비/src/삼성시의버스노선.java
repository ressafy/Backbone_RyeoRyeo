import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 삼성시의버스노선 {
	static int cnt;
	
	static class Pos {
		private int a1;
		private int b1;
		
		public Pos(int a1, int b1) {
			this.a1 = a1;
			this.b1 = b1;
		}
		
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test < T+1; test++) {
			sb = new StringBuilder();
			sb.append("#").append(test).append(" ");
			int N = Integer.parseInt(br.readLine());
			Pos [] que = new Pos[N];
			for (int i = 0; i < N; i++) {
				
				String [] arr = br.readLine().split(" ");
				int atemp = Integer.parseInt(arr[0]);
				int btemp = Integer.parseInt(arr[1]);
				Pos po = new Pos(atemp,btemp);
				que[i] = po;
				
			}
			int P = Integer.parseInt(br.readLine());
			for (int i = 0; i < P; i++) {
				cnt = 0;
				int temp = Integer.parseInt(br.readLine());
				for (int j = 0; j < N; j++) {
					if(que[j].a1 <= temp && temp <= que[j].b1) cnt ++;
				}
				
				sb.append(cnt).append(" ");
			}
			
			System.out.println(sb);
		}

	}

}
