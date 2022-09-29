import java.util.Arrays;
import java.util.Scanner;

public class DP2_ChangeMinCoinTest2 {

	// 4원 6원 단위로 화폐 고정
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();  // 목표금액, <= 100000
		
		int [] D = new int[money+1];  // D[i] : i금액을 만드는 최소동전 수
		
		int INF = 100000;  // 가장 작은 화폐 단위를 가장 많이 써도 만들 수 없는 큰 값, 그리고 +1 했을 때 오버플로 안나는 값
		D[0] = 0;
		for (int i = 1; i <= money; i++) {
			int min = INF;
			min = Math.min(min, D[i-1]+1);
			if(i>=4) min = Math.min(min, D[i-4]+1);
			if(i>=6) min = Math.min(min, D[i-6]+1);
			D[i] = min;
		}
		
		System.out.println(Arrays.toString(D));
		System.out.println(D[money]==INF?-1:D[money]);  //d 머니가 INF 랑 같으면 -1주고 아니면 D[money] 준다.
		
	}


}
