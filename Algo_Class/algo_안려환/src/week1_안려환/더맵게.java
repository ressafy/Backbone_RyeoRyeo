package week1_안려환;

import java.util.PriorityQueue;


public class 더맵게 {
	public int solution(int[] scoville, int K) {
		int answer = 0;
//		Queue <Integer> que = new LinkedList<Integer>();
//		Arrays.sort(scoville);
//		for (int a : scoville) {
//			que.offer(a);
//		}
//		int sum = 0;
//		while(true) {
//			int a = que.poll();
//			int b = que.poll();
//			sum = a+(b*2);
//		}  이거 우선순위 큐라는 것을 이용해서 푸는 문제이다....
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i = 0; i<scoville.length;i++) {
			que.offer(scoville[i]);
		}
		
		while(que.peek() <K) {
			if(que.size() < 2) return -1;
			int f1 = que.poll();  // 꺼내면 이미 작은 값인 것이다.
			int f2 = que.poll();
			
			int sum = f1+(f2 * 2);
			que.offer(sum);
			answer ++;
		}
		return answer;
	}
}