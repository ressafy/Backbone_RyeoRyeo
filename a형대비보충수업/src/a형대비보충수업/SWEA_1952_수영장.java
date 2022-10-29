package a형대비보충수업;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWEA_1952_수영장 {
	private static int [] m_list = new int [4];
	private static int [] p_list = new int [12];
	private static StringBuilder sb = new StringBuilder();
	private static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 1일 1달 3달 1년
			String [] arr = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {  
				m_list[i] = Integer.parseInt(arr[i]);  // 이용권당 가격
			}
			arr = br.readLine().split(" ");
			for (int i = 0; i < 12; i++) {
				p_list[i] = Integer.parseInt(arr[i]);
			}
			// 입력부 완
			answer = m_list[3];
			 dfs(0,0);
			 sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int month, int sum) {

		if(answer < sum) {
			return;
		}
		
		if(month > 11) {
			answer = sum;
			return;
		}
		
		if(p_list[month] == 0 ) {
			dfs(month+1,sum);
		}else {
			// 1일권
			dfs(month+1,sum+p_list[month]*m_list[0]);
			// 1달권
			dfs(month+1,sum+m_list[1]);
			// 3달권
			dfs(month+3,sum+m_list[2]);
		}
	}

}
