import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P083_BJ15961_회전초밥_self {
	
	private static int [] dish_list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);  // 접시의 수
		int d = Integer.parseInt(arr[1]);  // 초밥의 가짓수
		int k = Integer.parseInt(arr[2]);  // 연속해서 먹어야 하는 접시의 수
		int c = Integer.parseInt(arr[3]);  // 쿠폰 번호
		
		dish_list = new int [N];
		
		for (int i = 0; i < N; i++) {
			dish_list[i] =  Integer.parseInt(br.readLine());
		}
		
		// k번 동안 연속해서 먹을 동안 쿠폰 번호에 있는 접시가 안나오는 것이 가장 많은 종류의 접시를 먹을 수 있음
		// set을 이용해서 중복 없애면 종류가 몇 종류인지 알기 쉽다.
		// 행사에 무조건 참여하여 하는 것이다. 그러니까 k 만큼만 먹어서 최대한 다양한 초밥 먹는 것이 목표
		eat(0);
		max; 
		for (int i = 0; i < N; i++) {
			eat(i);
			Math.max(a, b);
		}
		
		System.out.println();
	}
	
	private static void eat(int i ) {
		for (int j = 0; j < k; j++) {  // k 만큼 무조건 x 슬라이딩 윈도우..... -> 배열에 넣을 때 왼쪽에서 뺴고 오른쪽으로 넣는 식으로
			
		}
		
	}

}
