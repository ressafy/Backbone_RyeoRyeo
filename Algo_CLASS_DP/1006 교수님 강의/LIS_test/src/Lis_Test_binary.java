import java.util.Arrays;
import java.util.Scanner;

public class Lis_Test_binary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] arr = new int [N];  // 수열의 수들
		int [] C = new int [N]; // 동적테이블: 각 원소를 끝으로 하는 LIS 값
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int size = 0;
		
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(C, 0, size, arr[i]);
			if(pos>=0) continue;  // 대상을 찾았다. 
			
			int insertPos = Math.abs(pos) - 1;  // 맨 뒤 또는 기존 원소의 대체자리
			C[insertPos] = arr[i]; // 그 자리에 우리가 탐색하는 값으로 바꿔버림
			
			if(insertPos == size) size++;
			
		}
		
		System.out.println(size);
	}
	
	

}
