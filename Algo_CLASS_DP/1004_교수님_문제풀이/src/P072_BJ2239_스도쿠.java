import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P072_BJ2239_스도쿠 {
	private static int [][] map;
	private int check;
	private static List<Pos> list = new ArrayList<Pos>() ;
	
	static class Pos{
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
					list.add(new Pos(j,i));
				}
			}
		}  // 입력부 완
		
		for(Pos p : list) {
			sudoku(0,p.x,p.y);
			printMap();
		}
		
	}
	
	private static void printMap() {  // 출력부 , 근데 81번째 수가 가장 작은 map을 출력해야 한다....
		
	}

	private static void sudoku(int cnt,int x, int y) {  // 여기서 스도쿠 판을 채워준다.
		// 맵을 돌면서 0이 나오면 
		if() return;
		for (int i = 1; i <= 9; i++) {
			if(check(x,y,i)) {
				 map[y][x] = i;
				 if(x+1<9) sudoku(cnt,x+1,y);
				 
				 
			}
			
		}
		
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
}
