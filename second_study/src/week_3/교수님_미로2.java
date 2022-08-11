package week_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 교수님_미로2 {
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int find;

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			in.readLine();
			map = new int[100][100];
			int r = 0;
			int c = 0;
			find = 0;
			for(int i = 0; i < 100; i++) {
				String s = in.readLine();
				for(int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j) - '0';
					if(map[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}
			bfs(r, c);
			System.out.println("#" + t + " " + find);
		}
	}
	public static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r,c});
        map[r][c] = 1;
        while(!queue.isEmpty()) {
        	int[]  cur = queue.poll();
            r = cur[0];
            c = cur[1];
            for(int i=0;i<4;i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                if(nr >= 0 && nc >= 0 && nr < 100 && nc < 100 && map[nr][nc]!=1) {
                    if(map[nr][nc]==3) {
                    	find = 1;
                        return;
                    }
                    map[nr][nc] = 1;
                    queue.offer(new int[] {nr,nc});
                }               
            }           
        }
	}
}