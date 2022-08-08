package second_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st,stch;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<String> clist = new LinkedList<>();
		for(int i = 0; i< n;i++) {
			st = new StringTokenizer(br.readLine());
			clist.add(st.nextToken());
		}
		String [] arr = {"WBWBWBWB","BWBWBWBW"};
		
		if(clist.get(0).charAt(0) == 'W') {
			for (int i = 0; i < arr.length; i++) {
				for(int j = 0; j<8;j++) {
					
				}
			}
		}else {
			for (int i = 0; i < arr.length; i++) {
				for(int j = 0; j<8;j++) {
					
				}	
			}
			
		}
		
	}

}
