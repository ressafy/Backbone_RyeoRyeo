package 반복문;

import java.util.Scanner;

public class 영수증 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int N = sc.nextInt();
		int a,b,sum = 0;
		for (int i = 0; i < N; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			sum += a * b;
		}
		sc.close();
		if(X == sum) System.out.println("Yes");
		else System.out.println("No");
		
	}

}
