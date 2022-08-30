import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareNumberTest {

	static int callCnt1,callCnt2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int x = Integer.parseInt(arr[0]);
		int n = Integer.parseInt(arr[1]);
		
		System.out.println(exp1(x,n));
		System.out.println(callCnt1);
		
		System.out.println(exp2(x,n));
		System.out.println(callCnt2);
		
	}
	
	static long exp1(long x, long n) {
		callCnt1++;
		if(n == 1) return x;
		return x* exp1(x,n-1); // 리턴될 때 쌓이는...
	}
	
	static long exp2(long x, long n) {  // 2의 10억 제곱도 가능하다.
		callCnt2++;
		if(n == 1) return x;
		long y = exp2(x,n/2); 
		return n%2==0 ? y*y : y*y*x;
	}
	
}
