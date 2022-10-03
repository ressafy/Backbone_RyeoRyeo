package a형대비보충수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
    static int[][] map;
    static boolean[][] visited;
    static int n, m, x, y, time;
    static Queue<Pos> q = new LinkedList();
    static StringBuilder sb = new StringBuilder();
    
    static class Pos {
        int x, y, time;

        public Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());  // 세로
            m = Integer.parseInt(stringTokenizer.nextToken());  // 가로
            x = Integer.parseInt(stringTokenizer.nextToken());  // 맨홀 뚜껑 세로
            y = Integer.parseInt(stringTokenizer.nextToken());  // .. 가로
            time = Integer.parseInt(stringTokenizer.nextToken());  // 소요 시간
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bf.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }  // 입력부 완
            
            
            bfs();
            
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) count++;  // 방문할 수 있던 곳이었다면 
                }
            }
            sb.append("#").append(tc).append(" ").append(count).append("\n");
            
        }
        System.out.print(sb);
    }
    
    private static void bfs() {
    	q.add(new Pos(x, y, 1));
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int tunnel = map[cur.x][cur.y];  // map 에 있는 터널의 타입
            int[][] next = next(tunnel);  // 터널의 번호를 가져다가 next에서 이동할 배열의 번호를 맞춰준다.
            
            for (int[] dxdy : next) {
                int nx = cur.x + dxdy[0];
                int ny = cur.y + dxdy[1];  // 도둑이 이 시간에 이동해서 존재할 수 있는 위치
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] != 0) {
                    if (cur.time >= time) continue;
                    boolean check = false;
                    for (int[] a : next(map[nx][ny])) {
                        int cx = nx + a[0];
                        int cy = ny + a[1];
                        if (cx == cur.x && cy == cur.y) {
                            check = true;
                        }
                    }
                    if (check) {
                    	visited[nx][ny] = true;
                        q.add(new Pos(nx, ny, cur.time + 1));
                    }
                }
            }
        }
    }

    private static int[][] next(int tunnel) {   // 터널 구조물 타입
        switch (tunnel) {
            case 1:
                return new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            case 2:
                return new int[][]{{1, 0}, {-1, 0}};
            case 3:
                return new int[][]{{0, 1}, {0, -1}};
            case 4:
                return new int[][]{{-1, 0}, {0, 1}};
            case 5:
                return new int[][]{{1, 0}, {0, 1}};
            case 6:
                return new int[][]{{1, 0}, {0, -1}};
            case 7:
                return new int[][]{{-1, 0}, {0, -1}};
        }
        return new int[][]{{0, 0}};
    }

    

}