import java.util.Scanner;

public class NQueenTest {
	static int N, cols[],ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N  = sc.nextInt();
		
		cols = new int [N+1];
		ans = 0;
	}
	
	public static void setQueen(int rowNo) {
		
		if(isAvailable(rowNo-1)) return; // 직전까지의 상황이 유망하지 않으면 현재 퀸 놓을 필요 없으니 백트랙!!
		// 백트랙 가지치기라고 생각하자
		if(rowNo>N) {  // 퀸을 다 놓았으면 ( 모든 퀸의 배치에 성공했다.)
			ans++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			cols[rowNo] = i;
			if(isAvailable(rowNo)) setQueen(rowNo+1);
		}
	}
	public static boolean isAvailable(int rowNo) {
		for (int i = 0; i < rowNo; i++) {
			if(cols[i] == cols[rowNo] || 
					rowNo - i == Math.abs(cols[rowNo] - cols[i])) return false;
		}
		return true;
	}

}
