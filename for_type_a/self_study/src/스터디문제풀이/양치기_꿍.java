package 스터디문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * #이라는 울타리 안에 갇혀있는 
 * 양과 늑대의 수를 비교해서 
 * 양의 수가 많으면 늑대가 사라지고 
 * 늑대의 수가 같더나 많으면 양이 다 잡아먹힌다. 
 * 각 구역별로 bfs를 돌려서 양과 늑대의 수를 비교해준다.
 * **/


public class 양치기_꿍 {
	private static char [][] map;
	private static boolean [][] visited;
	private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int sheep = 0, wolf = 0;
    private static int R,C;
    private static StringBuilder sb = new StringBuilder();
    
    
	private static class Pos{
		int y,x;

		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		R = Integer.parseInt(arr[0]);
		C = Integer.parseInt(arr[1]);
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String a = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = a.charAt(j);
			}
		} // 입력부 완
		
		for (int i = 0; i < R; i++) {
	           for (int j = 0; j < C; j++) {
	               if (visited[i][j] == false && map[i][j] != '#') {  // 울타리가 아니고 방문한적 없는 점에서 bfs 돌려준다.
	                   bfs(new Pos(i, j));
	               }
	           }
	       }
		sb.append(sheep).append(" ").append(wolf);
	    System.out.println(sb);
		
	}

	private static void bfs(Pos pos) {
        Queue<Pos> que = new LinkedList<Pos>();  
        que.offer(pos);
        visited[pos.y][pos.x] = true;
        int wolfCnt = 0;
        int sheepCnt = 0;
        while (!que.isEmpty()) {
            Pos pos2 = que.poll();
            int y = pos2.y;
            int x = pos2.x;
            if (map[y][x] == 'k') {  // 양의 수를 세어 준다.
                sheepCnt++;
            } else if (map[y][x] == 'v') {  // 늑대의 수를 세어 준다.
                wolfCnt++;
            }
            for (int i = 0; i < 4; i++) { // 이 구역 안에서 맵 밖으로 나가지 않고 벽이 아닌 곳에서 이동하기 때문에 각 구역에 대한 
                int y2 = pos2.y + dx[i];  // 양과 늑대의 수를 확인할 수 있다.
                int x2 = pos2.x + dy[i];
                if ((y2 > 0 && y2 < R && x2 > 0 && x2 < C) && visited[y2][x2] == false && map[y2][x2] != '#') {  // 유효성 검사를 해준다.
                	visited[y2][x2] = true;
                	que.offer(new Pos(y2, x2));
                }
            }
        }
        if (sheepCnt > wolfCnt) {  // 양의 수가 많은 경우만 
            sheep += sheepCnt;
        } else { // 같거나 늑대가 많으면
            wolf += wolfCnt;
        }
    }
	
}
