import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 활주로_건설 {
	private static int N,X;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String [] arr = br.readLine().split(" ");
			N = Integer.parseInt(arr[0]);
			X = Integer.parseInt(arr[1]);
			int [][] map = new int [N][N];
			for (int i = 0; i < N; i++) {
				arr = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}  // 입력부 완
			
			int [][] col = new int [N][N];  // 가로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					col[i][j] = map[j][i];
				}
			}  // 세로줄 분리 완
			int answer = 0;
			for (int i = 0; i < N; i++) {
				answer += check(map[i]);
				answer += check(col[i]);
			}
			// answer를 출력하면 된다.
		}
	}
	
	
	private static int check(int [] arr) { // 가능하면 1을 리턴한다.
		boolean [] visited = new boolean[N];  // 경사로
		// 앞 뒤의 차이가 1보다 크면 끝
		for (int i = 0; i < N-1; i++) {
			int bef = arr[i];
			int next = arr[i+1];
			
			if(Math.abs(bef - next) > 1) return 0; // 
			if(visited[i] == true) continue;  // 경사로 뒀으면 건너뜀
			
			if(bef > next && i+X < N) {  // 앞의 지형이 뒤의 지형보다 작은 경우
				for (int j = i; j < i+X; j++) {  // 경사로만큼  // 경사로가 필요한데 이미 있는 경우
					if(arr[j] == arr[j+1] && j+1 <= i+X) {  // 경사로 두기가 가능
						visited[j] = visited[j+1] = true; // 경사로를 둔다.
					}
				}
			}else if( ){  // 오르막 경사로를 둬야할 경우
				// 감사합니다.
			}
		}
	}

}
