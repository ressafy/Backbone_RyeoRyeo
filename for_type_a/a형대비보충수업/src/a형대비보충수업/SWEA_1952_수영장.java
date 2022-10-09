package a형대비보충수업;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SWEA_1952_수영장 {
	/**
	 * 1일 이용권 
	 * 1달 이용권
	 * 3달 이용원 연속된 3달 동안 이용이 가능 11월 12월 구매안되는 듯
	 * **/
	private static int [] m_list = new int [4];
	private static int [] p_list = new int [12];
	private static StringBuilder sb;
	private int cnt;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 1일 1달 3달 1년
			String [] arr = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				m_list[i] = Integer.parseInt(arr[i]);
			}
			arr = br.readLine().split(" ");
			for (int i = 0; i < 12; i++) {
				p_list[i] = Integer.parseInt(arr[i]);
			}
			// 입력부 완
			
			 
		}
	}
	
	private static void bfs() {
		
	}

}
