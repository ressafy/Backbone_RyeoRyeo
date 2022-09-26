import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수영장 {

	static int[] cou,mon;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		for (int i = 0; i < T; i++) {
			sb = new StringBuilder();
			String[] coupon = br.readLine().split(" ");
			String[] month = br.readLine().split(" ");
			
			cou = new int[4];
			mon = new int [12];
			
			for (int j = 0; j < 4; j++) {
				cou[i] = Integer.parseInt(coupon[j]);
			}
			for (int j = 0; j < 12; j++) {
				mon[i] = Integer.parseInt(month[j]);
			}
			//입력부 완
			
			min = Integer.MAX_VALUE;
			dfs(0,0);
			min = min>cou[3] ? cou[3]:min;
			sb.append("#").append(i).append(" ").append(min);
			System.out.println(sb);
			
		}

	}
	
	public static void dfs(int cnt, int sum) {
		if(cnt >= 12) {  // 12달 다 돌았다며
			min = min > sum? sum:min;
			return;
		}
		// 아직 다 못풀었습니다...ㅠㅠ 
	}

}
