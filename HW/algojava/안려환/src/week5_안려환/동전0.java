package week5_안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 동전0 {
 
	public static void main(String[] args) throws Exception {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int K = Integer.parseInt(arr[1]);
		
		int[] coin = new int[N];
		
		for(int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
 
		for(int i = N - 1; i >= 0; i--) {
			// 차피 오름차순으로 주니까 나눌 수 있는 제일 큰 값으로 나눠주면 끝이다.
			if(coin[i] <= K) {
				count += (K / coin[i]);
				K = K % coin[i];
			}
		}
		System.out.println(count);
	}
 
}