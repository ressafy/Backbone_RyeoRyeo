import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P072_BJ2239_스도쿠 {
	private static int [][] map;
	private static int check = 0, cnt = 0;
	private static int bx,by;
	private static List<Pos> list = new ArrayList<>();
	
	private static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		
		
		for (int i = 0; i < 9; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = temp.charAt(j)-'0';
				if(map[i][j] == 0) {
					cnt++; 
					list.add(new Pos(j,i));
				} 
			}
		}  // 입력부 완
		Pos a = list.get(0);
		int x = a.x;
		int y = a.y;
		sudoku(1,x,y,0);
		System.out.println(Arrays.deepToString(map));
	}
	
	
	private static void sudoku(int start, int x, int y, int time) {  // 여기서 스도쿠 판을 채워준다.
		// 기저 조건 
		if(time == cnt) return;
		
		for (int i = start; i <= 9; i++) {
			if(check(x,y,i)) {
				if(time < cnt) {
					System.out.println("go: "+time);
					map[y][x] = i;
					Pos a = list.get(time+1);
					int nx = a.x;
					int ny = a.y;
					sudoku(1,nx,ny,time+1);
				}
			}
		}
		if(map[y][x] == 0) {
			System.out.println("back: "+time);
			int nx = list.get(time-1).x;
			int ny = list.get(time-1).y;
			sudoku(1,nx,ny,time-1);
		}
		
		
		time++;
	}
	
	
	// 유효성 검사
	private static boolean check(int x, int y, int num) {  // 맵 안의 수를 가지고 check 
		// 가로줄 체크
		for (int i = 0; i < 9; i++) {
			if(map[y][i] == num) {
				return false;
			}
		}
		
		// 세로줄 체크
		for (int i = 0; i < 9; i++) {
			if(map[i][x] == num) {
				return false;
			}
		}
		
		// 9칸 체크 0,1 1,2
		int nr = y/3*3;
		int nc = x/3*3;   // 나눈 몫이 맞는 것 같읍니다.... 헷갈렸읍니다.....ㅠㅠ
		for (int i = nr; i < nr+3; i++) {
			for (int j = nc; j < nc+3; j++) {
				if(map[i][j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static boolean allcheck() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
}
