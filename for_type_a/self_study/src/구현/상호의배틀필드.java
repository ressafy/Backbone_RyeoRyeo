package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상호의배틀필드 {
	private static char [][] map;
	private static StringBuilder sb = new StringBuilder();
	private static class Pos{
		int j,i,dir;
		// 0 : up 1: down 2: left 3: right
		
		public Pos(int j, int i, int dir) {
			super();
			this.j = j;
			this.i = i;
			this.dir = dir;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String [] arr1 = br.readLine().split(" ");
			int	H = Integer.parseInt(arr1[0]);
			int W = Integer.parseInt(arr1[1]);
			map = new char [H][W];
			Pos po = new Pos(0,0,0);
			for (int i = 0; i < H; i++) {
				String arr = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] =  arr.charAt(j);
					if(arr.charAt(j) != '.' && arr.charAt(j) != '-' && arr.charAt(j) != '*' && arr.charAt(j) != '#') {
						switch(arr.charAt(j)) {
						case '^':
							po = new Pos(j,i,0);
							break;
						case 'v':
							po = new Pos(j,i,1);
							break;
						case '<':
							po = new Pos(j,i,2);
							break;
						case '>':
							po = new Pos(j,i,3);
							break;
						}
					}
				}
			}
			System.out.println(po.i+" "+po.j+" "+po.dir);
			int N = Integer.parseInt(br.readLine());
			String mov = br.readLine();
			for (int i = 0; i < N; i++) {
				switch (mov.charAt(i)) {
				case 'S':  // 포탄 발사
					
					break;
				case 'U':  // 위로 바꾸고 평지라면 이동
					
					break;
				case 'R':  // 오른쪽 
	
					break;
				case 'L':  // 왼쪽
	
					break;
				case 'D':  // 아래쪽
					
					break;
				default:
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				sb.append(map[i]).append("");
			}
		}
	}

}
