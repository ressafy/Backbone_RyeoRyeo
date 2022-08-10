import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class nPrTest {
	static int N, R,totalCnt;
	static int [] numbers;
	static boolean[] isSelected;
	// nPn : 1부터 n 까지의 수 중 n개를 모두 뽑아 순서적으로 나열한 것
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		
		numbers = new int[R];
		isSelected = new boolean[N+1];  // 수가 1부터 시작하니까 인덱스도 1부터 시작하기 위해서 1 인덱스부터해서 맞춰준다.
		perm(0);
		System.out.println("총 경우의 수: "+totalCnt);
		
	}

	private static void perm (int cnt) {  // cnt 매개변수에 대한 정의는 직전까지 뽑은 순열에 포함된 수의 개수, cnt+1번째에 해당하는 순열에 포함될 수를 뽑기
		
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return; 
		}
		// 가능한 모든 수에 대해서 시도한다.
		for(int i = 1; i<= N; i++) {  // 선택지가 된다.
			// 시도하는 수가 선택되었는지 판단
			if(isSelected[i])  continue;  // 하면 증감식 저 i++ 로 간다.
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = i;
			isSelected[i] = true;
			// 다음 수 뽑으러 가기
			perm(cnt+1);
			// 사용했던 수에 대해 선택 되돌려놔야한다.
			isSelected[i] = false;
			
		}
		
		
		
	
	}
}