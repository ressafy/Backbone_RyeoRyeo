package week_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 격자판의_숫자_이어_붙이기 {
	
	static int [][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static Stack<StringBuilder> stack;
	static int [][] arr;
	static StringBuilder sb;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int test = 0; test < T; test++) {
			int [][] arr = new int [4][4];
			stack = new Stack<>();  // 담아둘 큐
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}  // 입력부 구현 완료
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i,j,1,sb);
				}
			}
			// 이제 stack 에는 중복이 제거되지 않은 값들이 들어있을 것
			// 중복 제거처리
		}
	}
	
	private static void dfs(int x, int y, int depth,StringBuilder sb) {
		if(depth == 7) { // 7개를 가지고 순열이니까
			stack.add(sb);
			sb = new StringBuilder();
			return;
		}
		for (int i = 0; i < 4; i++) {
			int dx = x + dir[i][0];
			int dy = y + dir[i][1];
			if(dx < 0 && dy < 0 && dx >= 4 && dy >= 4) continue;
			dfs(dx,dy,depth+1,sb.append(arr[dx][dy]));  // 여기서 NullPointerException이 발생합니다...
		}
	}

}
