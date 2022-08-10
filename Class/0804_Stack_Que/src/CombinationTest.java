import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class CombinationTest {
	static int N, R,totalCnt;
	static int [] numbers,input;

	// nPn : n개의 입력받은 수 중 n개를 모두 뽑아 순서적으로 나열한 것 (입력 수 : 1 ~ 100000)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R= sc.nextInt();
		totalCnt = 0;
		
		input = new int[N]; 
		numbers = new int[R];
		
		for (int i = 0; i <N; i++) {
			input[i] = sc.nextInt();
		}
		
		Comb(0,0);
		System.out.println("총 경우의 수: "+totalCnt);
		
	}

	private static void Comb (int cnt, int start) {  // cnt 직전까지 뽑은 조합에 포함된 수의 개수, start: 시도할 수의 시작 위치
		
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return; 
		}
		// START 부터 시작해서 중복 방지
	
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			// 앞쪽에서 사용되지 않았던 수를 사용한다.
			Comb(cnt+1, i+1);
			// start 는 시작 위치만 결정하는 것이다. i를 사용해야 중복을 제거할 수 있다.
		}
		
		
	
	}
}