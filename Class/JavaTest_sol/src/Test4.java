/*
Test4.java : 팀원 평균

[테스트케이스]

5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("Test4.txt"));
		int[] arr;
		int testcase = in.nextInt();
		for (int i = 0; i < testcase; i++) {
			int N = in.nextInt(); 
			arr = new int[N];
			double sum = 0; 
			for (int j = 0; j < N; j++) {
				int val = in.nextInt(); 
				arr[j] = val;
				sum += val; 
			}

			double mean = (sum / N);
			double count = 0; 

			for (int j = 0; j < N; j++) {
				if (arr[j] > mean) {
					count++;
				}
			}

			System.out.printf("#" + (i + 1) + " %.3f%%\n", (count / N) * 100);

		}
		in.close();
	}
}
