package 과목평가3회차풀어보기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 냐옹이의야바위게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test < T+1; test++ ) {
			sb = new StringBuilder();
			String arr []  = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int X = Integer.parseInt(arr[1]);
			int K = Integer.parseInt(arr[2]);
			for (int i = 0; i < K; i++) {
				String arr2[] = br.readLine().split(" ");
				int cup1 = Integer.parseInt(arr2[0]);
				int cup2 = Integer.parseInt(arr2[1]);
				if (cup1 == X)
					X = cup2;
				else if (cup2 == X)
					X = cup1;
			}
			sb.append("#").append("test").append(" ").append(X);
			System.out.println(sb);
		}
	}

}

//public class Main {
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb;
//		int T = Integer.parseInt(br.readLine());
//		sb = new StringBuilder();
//		String arr []  = br.readLine().split(" ");
//		int N = Integer.parseInt(arr[0]);
//		int X = Integer.parseInt(arr[1]);
//		int K = Integer.parseInt(arr[2]);
//		for (int i = 0; i < K; i++) {
//			String arr2[] = br.readLine().split(" ");
//			int cup1 = Integer.parseInt(arr2[0]);
//			int cup2 = Integer.parseInt(arr2[1]);
//			if (cup1 == X)
//				X = cup2;
//			else if (cup2 == X)
//				X = cup1;
//		}
//		sb.append(X);
//		System.out.println(sb);
//		
//	}
//
//}