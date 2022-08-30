package 일차원_배열;

import java.util.Scanner;

public class 일차원배열_순회_2 {
	
	public void nums() {
		int [] nums = {10,9,8,7,6,5,4,3,2,1};
		for(int a :nums) {
			System.out.print(a);
		}
		System.out.println();
	}
	
	public void foods() {
		int i;
		String s;
		Scanner sc = new Scanner(System.in);
		i = sc.nextInt();
		String [] foods = new String[i];
		for(int j = 0;j<i;j++) {
			Scanner sc2 = new Scanner(System.in);
			s = sc2.nextLine();
			foods[j] = s;
		}
		for(String food:foods) {
			System.out.println(food);
		}
	}

	public static void main(String[] args) {
		일차원배열_순회_2 fa = new 일차원배열_순회_2();
		fa.nums();
		fa.foods();
	}
}
