import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class PermutationBitMaskingTest2 {
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
		
		perm(0,0);
		System.out.println("총 경우의 수: "+totalCnt);
		
		
	}
	
	// cnt 매개변수에 대한 정의는 직전까지 뽑은 순열에 포함된 수의 개수, cnt+1번째에 해당하는 순열에 포함될 수를 뽑기
	// flag: 선택된 수들의 상태를 비트로 표현하고 있는 비트열(정수)
	private static void perm (int cnt, int flag) {  
		
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return; 
		}
		// 가능한 모든 수에 대해서 시도한다.( input 배열의 모든 수 시도)
		for(int i = 0; i< N; i++) {  // 선택지가 된다.
			// 시도하는 수가 선택되었는지 판단
			if((flag & 1 << i) != 0)  continue;  // 하면 증감식 저 i++ 로 간다.
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];
			// 다음 수 뽑으러 가기
			perm(cnt+1, flag | 1<<i);  // 이러면 되돌릴 필요 없다.
			
		}
		
		
		
	
	}
}