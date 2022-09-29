package second_study;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	// 상태: 숫자 6개
	private int[] numbers =  new int[6]; 
	//	기능: 숫자 6개 추출
	// 			반자동 기능을 지원(오버로딩을 보여주기 위해 그냥 list)
	//   우리는 2개까지 고정으로 가자
	public Lotto() {
		createLotto();
	}
	
	public Lotto(int num1) {
		createLotto(num1);
	}
	
	public Lotto(int num1, int num2) {
		createLotto(num1, num2);
	}

	public int[] getNumbers() {
		return Arrays.copyOf(numbers, numbers.length);
	}
	
	private void selectRandomNumbers(final int SIZE, boolean[] used) {
		Random r = new Random();
		int cnt = 0 , tmp = 0;
		while(cnt<SIZE) {
			tmp = r.nextInt(45)+1;
			if(!used[tmp]) {
				numbers[cnt++] = tmp;
				used[tmp] = true;
			}
		}
		Arrays.sort(numbers);
	}
	
	private void createLotto(int num1) {
		boolean[] used = new boolean[46];
		used[num1] = true;
		numbers[5] = num1;
		selectRandomNumbers(5,used);
		
	}
	
	
	private void createLotto(int num1, int num2) {
		boolean[] used = new boolean[46];
		used[num1] = true;
		numbers[5] = num1;
		used[num2] = true;
		numbers[4] = num2;
		selectRandomNumbers(4,used);
	}
	
	
	private void createLotto() {
		boolean[] used = new boolean[46];
		selectRandomNumbers(6,used);
	}
}
