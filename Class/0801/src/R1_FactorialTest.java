import java.util.Scanner;

public class R1_FactorialTest {

	static int factorial(int n) {
		int res = 1;
		for(int i = n; i>=1;i--) {
			res *= i;
		}
		return res;
	}
	
	static int res = 1;
	
	static int factorial2(int i) {
		if(i<=1) {
			return res;
		}else {
			res *= i;
			return factorial2(i-1);
		}
		
	}
	
	
	// 이게 제대로된 재귀 팩토리얼
	static int factorial3(int n) {
		if(n<= 1) {
			return 1;
		}
		return n*factorial3(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(factorial2(N));
		System.out.println(factorial3(N));

	}

}
