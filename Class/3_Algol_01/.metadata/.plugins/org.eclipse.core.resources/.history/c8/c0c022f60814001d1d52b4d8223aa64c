package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class P014_BJ2164_카드2 {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> arr = new LinkedList<>();
		// 스트링 빌더는 append 나 delete 연산을 하게 되면 매우 느리다... 
		// 되도록이면 출력할 때만 사용하도록 하자. 
		
		for(int i =0; i<n;i++) {
			arr.add(i+1);
		}
		
		while(arr.size()!= 1) {  // size 가 1이 되면 마지막 남는 값이 됩니다.
			arr.remove();  // 맨 앞의 값을 제거해줍니다.
			arr.offer(arr.poll());  //맨 앞의 값을 제거하지 않고 가져와서 offer 를 이용하여 더해줍니다. 
		}
		System.out.println(arr.poll());  // 마지막 남은 값을 출력해줍니다.
	}

}
