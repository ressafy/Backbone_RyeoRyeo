package 스터디문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 욕심쟁이_판다 {
	// 못풀어서 보고 이해했읍니다...
	// dfs 에서 메모이제이션을 사용하는 문제라고 합니다.
	// 판다가 시작할 수 있는 위치를 전부 메모이제이션을 활용한 DFS로 구하면 된다고 함

	private static int n = 0;
	private static int[][] map;
	private static int[][] dp;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
 
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(dfs(i, j), ans);
            }
        }
        System.out.println(ans);
    }
 
    private static int dfs(int i, int j) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        int cnt = 1;
        for (int k = 0; k < 4; k++) {
            if(i + dx[k] >= 0 && i + dx[k] < n && j + dy[k] >= 0 && j + dy[k] < n) {
                if(map[i][j] < map[i + dx[k]][j + dy[k]]) {
                    cnt = Math.max(dfs(i + dx[k], j + dy[k]) + 1, cnt);
                    dp[i][j] = cnt;
                }
            }
        }
        return cnt;
    }

}
