package second_study;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto_test {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("원하는 게임 수 입력하세요.");
		int n = sc.nextInt();
		
		Lotto []games = createLottoGames(n);
		
		for( int i = 0; i< n; i++) {
			System.out.print((i+1) + "번째 게임: ");
			for( int no: games[i].getNumbers()) {
				System.out.print(no+"\t");
			}
			System.out.println();
		}{
			System.out.print("숫자 한 개 지정한 로또게임 생성(숫자 하나 입력하세요) : ");
			int num1 = sc.nextInt();
			Lotto lotto = new Lotto(num1);
			System.out.println(Arrays.toString(lotto.getNumbers()));
		}{
			System.out.print("숫자 두 개 지정한 로또게임 생성(숫자 두 개 입력하세요) : ");
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			Lotto lotto = new Lotto(num1,num2);
			System.out.println(Arrays.toString(lotto.getNumbers()));
		}

	}
	
	private static Lotto[] createLottoGames(int n) {
		Lotto[] games = new Lotto[n];
		for(int i = 0; i<n;i++) {
			games[i] = new Lotto();
		}
		return games;
	}
}
