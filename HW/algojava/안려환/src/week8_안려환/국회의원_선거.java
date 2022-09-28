package week8_안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 국회의원_선거 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int dasom = Integer.parseInt(bf.readLine()); // 첫번째 후보가 다솜
		int[] arr = new int[N-1];
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(bf.readLine());
		// 입력부
		
		int min = 0;	// 매수해야하는 사람의 수
		if(N == 1) {	// 후보가 한 명일 때
			System.out.println("0");
			return;
		}
		
		while(true) {
			Arrays.sort(arr);  // 정렬해서 최대 득표수를 알기 위함
			boolean flag = true;
			int last = arr.length-1;	// 최다 득표자
			if(dasom <= arr[arr.length-1]) {  // 다솜이가 최다 득표자가 아닌 경우
				dasom ++;
				arr[last] --;	
				min ++;		// 한 명 매수
				flag = false;	// 다솜이가 당선이 되지 못했으므로 false로 설정
			}
			if(flag)	// 다솜이보다 높은 투표수가 없는경우
				break;
		}
		System.out.println(min);
	}

}
