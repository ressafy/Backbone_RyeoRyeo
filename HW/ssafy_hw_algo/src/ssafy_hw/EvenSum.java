package ssafy_hw;

import java.util.Scanner;

public class EvenSum {

	public static void main(String[] args) {
		System.out.print("숫자 입력 >> ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int ans = 0;
		for(int i = 1;i<num+1;i++) {
			if(i%2==0) {
				ans+=i;
			}
		}
		System.out.println("1부터 10까지 수 중 짝수의 합 = "+ans);
	}

}
