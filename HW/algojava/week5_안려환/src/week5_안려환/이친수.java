package week5_안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 이친수 {
	static long [] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 피보나치 수열과 동일하다.
		arr = new long[N+1];
		long result = fibo(N);
		System.out.println(result);

	}
	private static long fibo(int N) {
		if (N <= 1) {
			return N;
		} else {
			return fibo(N - 1) + fibo(N - 2);
		}
	}
	
//	private static long dpFibo(int N) {
//		if(N <= 1) {  // 문제가 조건이 1부터이다.
//			return N;
//		}else if(arr[N] != 0) {
//			return arr[N];
//		}else {
//			return arr[N] = dpFibo(N-1) + dpFibo(N-2);
//		}
//	}

}
