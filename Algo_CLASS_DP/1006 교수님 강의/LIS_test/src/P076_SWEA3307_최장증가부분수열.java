import java.util.Arrays;
import java.util.Scanner;

public class P076_SWEA3307_최장증가부분수열 {
	private static int [] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			arr = new int [N];  // 수열의 수들
			int [] LIS = new int [N]; // 동적테이블: 각 원소를 끝으로 하는 LIS 값
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) {  // 앞쪽으로 모든 원소기준으로 자신을 끝으로 하는 LIS 계산
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[j]<arr[i] && LIS[i] < LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}
				max = Math.max(max, LIS[i]);
			}
			sb.append("#").append(tc+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	
	// ex 1 3 2 5 4    BinarySearch(1,4,5) 
	
	// mid 2 
	private static int BinarySearch(int start, int end, int target ) {
		while(start<end) {
			int mid = (start + end)/2;  // 이진탐색을 위한 중간 위치
			if(arr[mid] < target) {  // 이 중간 위치의 값이 target 값보다 작으면 
				start = mid + 1;  // 왼쪽부터 따질 곳을 중간 위치의 다음번으로 설정
			}else { // target보다 큰 경우
				// 그러면 찾고자 하는 값이 우측에 있는 것이다. 
				end = mid;
			}
		}
		
		return end;
	}
	
	

}
