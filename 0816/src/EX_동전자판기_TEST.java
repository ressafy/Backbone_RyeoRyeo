import java.util.Scanner;

import com.sun.org.apache.xml.internal.serializer.ToHTMLSAXHandler;

import sun.management.counter.Units;

public class EX_동전자판기_TEST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int targetMoney = sc.nextInt();
		
		int[]units = {500,100,50,10,5,1};
		int[]counts = {sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
		
		int totalMoney = 0;
		for (int i = 0; i < units.length; i++) {  // 보유하고 있는 동전들로 만들 수 있는 금액 계산
			totalMoney += units[i] * counts[i];
		}
		
		int remainMoney = totalMoney - targetMoney;
		// 음료수 값을 지불하는데 동전을 최대로 사용하려면, 지불하고 남은 금액의 동전 수를 최소로 하면 된다.
		
		int sum = 0, maxCnt, availCnt;
		for (int i = 0; i < units.length; i++) {  // 가장 큰 화폐 단위부터 많이 사용하도록
			maxCnt = remainMoney/units[i]; // 해당 금액을 i 화폐 단위를 가장 많이 쓸 때의 개수
			availCnt = maxCnt <= counts[i] ? maxCnt: counts[i]; 
			
			counts[i] -= availCnt;  // 사용하고 남은 개수
			remainMoney -= availCnt*units[i];
			
			sum += counts[i]; // 사용되고 남은 동전이 지불하기 위해 사용될 동전 수
		}
		System.out.println(sum); // 음료수값을 지불하기 위해 사용된 동전 수
		for (int i = 0, size = counts.length; i < size; i++) {  // 이렇게 해야 자꾸 배열 길이 참조하는 메모리 손실을 막는다.
			System.out.println(counts[i]+ " ");
		}
	}

}
