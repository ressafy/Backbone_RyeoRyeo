package week6_안려환;

public class 등굣길 {

	public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        
        // 웅덩이 초기화
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][1];
            int y = puddles[i][0];
            dp[x][y] = -1;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;  // 웅덩이는 0으로 해줘서 점화식 사용할 수 있게 한다.
                }
                
                if (!(i == 1 && j == 1)) {  // 시작 점이 아닐 때
                    int left = 0;
                    int up = 0;
                 // 각 1인 경우 맨 위와 맨 왼쪽이기 때문에 맨 위나 왼쪽은 좌 우 중 한 쪽이 없다.
                    if (j > 1)   
                        left = dp[i][j - 1];
                    if (i > 1) 
                        up = dp[i - 1][j];

                    dp[i][j] = (left + up) % 1000000007;
                }
            }
        }
        
        return dp[n][m];
    }
}
	

