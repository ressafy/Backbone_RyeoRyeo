package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 상호의배틀필드 {
	private static char [][] map;
	private static StringBuilder sb = new StringBuilder();
	private static int H,W;
	private static Pos po;
	private static class Pos{
		int i,j,dir;
		// 0 : up 1: down 2: left 3: right
		
		public Pos(int i, int j, int dir) {
			super();
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
		
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String [] arr1 = br.readLine().split(" ");
			H = Integer.parseInt(arr1[0]);
			W = Integer.parseInt(arr1[1]);
			map = new char [H][W];
			po = new Pos(0,0,0);
			for (int i = 0; i < H; i++) {
				String arr = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] =  arr.charAt(j);
					if(arr.charAt(j) != '.' && arr.charAt(j) != '-' && arr.charAt(j) != '*' && arr.charAt(j) != '#') {
						switch(arr.charAt(j)) {
						case '^':
							po = new Pos(i,j,0);
							break;
						case 'v':
							po = new Pos(i,j,1);
							break;
						case '<':
							po = new Pos(i,j,2);
							break;
						case '>':
							po = new Pos(i,j,3);
							break;
						}
					}
				}
			}  // 맵 입력부 완
			
//			for (int j = 0; j < H; j++) {
//				System.out.println(map[j]);
//			}
			
			int N = Integer.parseInt(br.readLine());
			String mov = br.readLine();
			for (int i = 0; i < N; i++) {
				switch (mov.charAt(i)) {
				case 'S':  // 포탄 발사
					// 바라보는 방향 으로 탄을 쏘는데 
					shoot();
					break;
				case 'U':  // 위로 바꾸고 평지라면 이동
					move(0);
					break;
				case 'R':  // 오른쪽 
					move(3);
					break;
				case 'L':  // 왼쪽
					move(2);
					break;
				case 'D':  // 아래쪽
					move(1);
					break;
				default:
					break;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				sb.append(map[i]).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	private static void shoot() {
		switch(po.dir) {
		case 0:
			for (int i = po.i-1; i >= 0 ; i--) {
				if(map[i][po.j] == '*') {
					map[i][po.j] = '.';
					break;
				}else if(map[i][po.j] == '#') {
					break;
				}
			}
			break;
		case 1:
			for (int i = po.i+1; i < H; i++) {
				if(map[i][po.j] == '*') {
					map[i][po.j] = '.';
					break;
				}else if(map[i][po.j] == '#') {
					break;
				}
			}
			break;
		case 2:
			for (int j = po.j-1; j >= 0; j--) {
				if(map[po.i][j] == '*') {
					map[po.i][j] = '.';
					break;
				}else if(map[po.i][j] == '#') {
					break;
				}
			}
			break;
		case 3: 
			for (int j = po.j+1; j < W; j++) {
				if(map[po.i][j] == '*') {
					map[po.i][j] = '.';
					break;
				}else if(map[po.i][j] == '#') {
					break;
				}
			}
			break;
		default:
			break;
		}
	}
	
	private static void move(int n) {
		// 주어진 방향으로 돌리면 되니까 현재 방향은 중요하지 않다.
		switch(n) {
		case 0:
			if(po.i-1 >= 0 && map[po.i-1][po.j] == '.') {
				map[po.i][po.j] = '.';
				po = new Pos(po.i-1,po.j,0);
				map[po.i][po.j] = '^';
				break;
			}else {
				po = new Pos(po.i,po.j,0);
				map[po.i][po.j] = '^';
				break;
			}
		case 1:
			if(po.i+1 < H && map[po.i+1][po.j] == '.') {
				map[po.i][po.j] = '.';
				po = new Pos(po.i+1,po.j,1);
				map[po.i][po.j] = 'v';
				break;
			}else {
				po = new Pos(po.i,po.j,1);
				map[po.i][po.j] = 'v';
				break;
			}
		case 2:
			if(po.j-1 >= 0 && map[po.i][po.j-1] == '.') {
				map[po.i][po.j] = '.';
				po = new Pos(po.i,po.j-1,2);
				map[po.i][po.j] = '<';
				break;
			}else {
				po = new Pos(po.i,po.j,2);
				map[po.i][po.j] = '<';
				break;
			}
		case 3: 
			if(po.j+1 < W && map[po.i][po.j+1] == '.') {
				map[po.i][po.j] = '.';
				po = new Pos(po.i,po.j+1,3);
				map[po.i][po.j] = '>';
				break;
			}else {
				po = new Pos(po.i,po.j,3);
				map[po.i][po.j] = '>';
				break;
			}
		default:
			break;
		}
		
		
	}

}
