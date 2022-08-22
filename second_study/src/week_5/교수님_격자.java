package week_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 교수님_격자 {
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int[][] map;
	static HashSet<Integer> set;
	public static void main(String[] args) throws Exception{
		// 방법은 dfs 중복순열로 풀이하는 것이다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T; tc++) {
			// 초기화
			map = new int[4][4];
			set = new HashSet<>();
			// 데이터 입력받고
			for (int i = 0; i < 4; i++) {
				String line = br.readLine();
				for (int j = 0,k=0; j < 4; j++, k+=2) {
					map[i][j] = line.charAt(k)-'0';
				}
			}
			// 4*4 반복 돌면서 7개의 생성할 수 있는 모든 숫자를 만들기. => dfs로 만들자.
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i,j,1,map[i][j]);
				}
			}
			
			
			// 결과 출력하기
			System.out.println("#"+tc+" "+set.size());
		}
		
		
	}

	private static void dfs(int r, int c, int cnt, int num) {
		// 기저 조건 7개의 숫자를 모두 만들면 종료
		// 숫자를 set에 넣어주고 return
		if (cnt == 7) {
			set.add(num);
			return;
		}
		
		
		//4방향을 돌면서 숫자를 생성하기
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			//경계 검사
			if(nr < 0 || nr >= 4 || nc<0 || nc >= 4) continue;
			dfs(nr,nc,cnt+1,(num*10)+map[nr][nc]);
		}
	}
}
