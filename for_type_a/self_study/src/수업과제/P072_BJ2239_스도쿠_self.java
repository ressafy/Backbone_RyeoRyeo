package 수업과제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P072_BJ2239_스도쿠_self {
	private static int [][] map = new int[9][9];
	private static List<Pos> list = new ArrayList<>();
	private static class Pos{
		int x, y, cnt;

		public Pos(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 9; i++) {
			char [] a = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = a[j]-'0';
				if(map[i][j] == 0) {
					list.add(new Pos(i,j,0));
				}
			}
		}  // 입력부 완
		
		for(Pos p : list) {  // 0에 대해서 실행
			sudoku(p);
		}
		
	}
	
	private static boolean sudoku(Pos p) {
		if(p.cnt == 81) return true;
		for (int i = 0; i < 10; i++) {
			if(check(p.x,p.y,i)) {
				map[p.y][p.x] = i;
				
			}
		}
		
	}
	
	private static boolean check(int x , int y, int num) {
		for (int i = 0; i < 9; i++) {
			if(map[i][x] == num) return false;
		}
		
		for (int i = 0; i < 9; i++) {
			if(map[y][i] == num) return false;
		}
		
		int nr = y/3*3;
		int nc = x/3*3;
		for (int i = nr; i < nr+3; i++) {
			for (int j = nc; j < nc+3; j++) {
				if(map[i][j] == num) return false;
			}
		}
		
		return true;
		
	}

}
