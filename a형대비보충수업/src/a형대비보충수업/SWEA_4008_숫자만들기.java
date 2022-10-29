package a형대비보충수업;

import java.util.Scanner;

public class SWEA_4008_숫자만들기 {
	
	
	/**
	 * 완전 탐색으로 푸는 문제이다.
	 * 연산자 하나씩 추가해가면서 재귀호출을 한다.
	 * N-1 개 모두 추가 후 값을 계산해서 
	 * 값을 구해준다.
	 * 
	 * 
	 * **/

	private static int N;
	private static int answer, minN, maxN;
	private static int[] operator, numbers, operation;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			minN = 100000000;
			maxN = -100000000;  // 문제에서 제약 조건으로 주어졌다.

			N = sc.nextInt();  // 테스트 케아스 N 
			operator = new int[4];  // 연산자는 4개밖에 없으므로
			numbers = new int[N];  // 입력받을 숫자
			operation = new int[N-1];   // 제약사항에서 알려준 연산자 카드 개수의 총 합은 N -1 

			for(int i=0; i<4; i++) {
				operator[i] = sc.nextInt();  // 연산자들 갯수를 넣어준다.
			}

			for(int i=0; i<N; i++) {  // 연산할 숫자들을 넣어준다.
				numbers[i] = sc.nextInt();
			}

			checkAll(0);  // 연산 가능한 모든 경우를 체크해준다.

			answer = maxN-minN;  // 답: 만들 수 있는 최대의 수 - 만들 수 있는 최소의 수
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		System.out.println(sb);

	}
	static void checkAll(int idx) {
		
		if(idx == N-1) {  // 이 연산자 카드 개수의 총합과 같아졌을 때 계산을 한다.
			calcNum();
		}

		for(int i=0; i<4; i++) {
			if(operator[i] == 0)  // 해당하는 연산자가 없는 경우
				continue;  // 그냥 넘어간다.
			
			// operator 연산자 몇 개 가지고 쓸건지 갯수가 들어있음
			operator[i]--;  // 사용할 때마다 하나씩 빼준다.
			operation[idx] = i;
			checkAll(idx+1);
			operator[i]++;
		}
		
		
	}

	static void calcNum() {
		int num = numbers[0];
		for(int i=0; i<N-1; i++) {  // i + 1 까지니까 N - 1 해야 올바른 범위
			if(operation[i] == 0) {  // 덧셈
				num+=numbers[i+1];  // 0부터 시작이니까 i + 1 넣어줘야 한다.
			}
			else if(operation[i] == 1) {  // 뺄셈
				num-=numbers[i+1];
			}
			else if(operation[i] == 2) {  // 곱
				num*=numbers[i+1];
			}
			else if(operation[i] == 3) {  // 나누기
				num/=numbers[i+1];
			}
		}
		
		maxN = Math.max(num,maxN);  // 최대값
		minN = Math.min(num,minN);  // 최소값
		
	}

}