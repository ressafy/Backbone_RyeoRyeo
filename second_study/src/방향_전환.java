import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 방향_전환 {
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
	static class Pos{
		int i,j;
		public Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test < T+1; test++) {
			String [] arr = br.readLine().split(" ");
			int x1 = Integer.parseInt(arr[0]);
			int y1 = Integer.parseInt(arr[1]);
			int x2 = Integer.parseInt(arr[2]);
			int y2 = Integer.parseInt(arr[3]);
		}

	}

}
