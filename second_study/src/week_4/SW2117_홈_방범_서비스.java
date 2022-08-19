package week_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SW2117_홈_방범_서비스 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		int [][] map = new int [N][N];
		
		for (int i = 0; i < N; i++) {
			String [] arr1 = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(arr1[j]);
			}
		}  // 입력부
		//  what can I do???
		

	}

}
