package 조건문;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 두_수_비교하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		
		if(a>b) {
			System.out.println(">");
		}else if (a < b) {
			System.out.println("<");
		}else {
			System.out.println("==");
		}

	}

}
