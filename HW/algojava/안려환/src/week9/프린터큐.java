package week9;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
 
public class 프린터큐 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int cnt = 0;
			Queue<int[]> queue = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				queue.add(new int[] {j,sc.nextInt()});
			}
			
			while (true) {
				int now[] = queue.poll();
				boolean flag = true;
				
				for (int q[] : queue) {
					if(q[1] > now[1]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					cnt++;
					if(now[0] == M) break;
				}else {
					queue.add(now);
				}
			}
			System.out.println(cnt);
		}
	}
}