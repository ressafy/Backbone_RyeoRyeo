import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팩토리얼 {
	static int n ;
	static int fact = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		facto(n,fact);
	}
	public static void facto(int n,int fact) {
		if(n <= 1) {
			System.out.println(fact);
			return;
		}
		else {
			fact *= (n--);
			facto(n--,fact);
		}
	}
}
