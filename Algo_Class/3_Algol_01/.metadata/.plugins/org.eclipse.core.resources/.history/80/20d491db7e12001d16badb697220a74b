package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P005_SWEA1210_Ladder1 {

	public static void main(String[] args) throws IOException {
		boolean side = false;
		boolean r_side = false;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 아래로 내려가게 하고 방향전환할 수 있으면 방향전환
		
		for (int test = 0; test < 10; test++) {  // 게임 시작
			int [][]data = new int [100][100]; // 사다리 다리들을 넣어줄 2차원 배열
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i<100;i++) { //  사다리 구현부
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<100;j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			br.readLine().split(" "); 로 로크나이저를 바꿔보자.
			int w = 0;
			int h = 99;  // 어차피 하나 올리고 나서 진행된다. 바닥에 도달하면 멈추기 때문이다.
			
			for(int i = 0; i< 100;i++) {
				if(data[h][i] == 2) {
					w = i;
				}
			} // 시작부를 설정해주는  for
			
			// 0보다 작아지거나 100 되면 인덱스 밖으로 나간 것.  data[h][w]
			while(h>0) {
				if(w-1 > 0 && w+1<100) {  //  가운데 사다리 기둥의 경우
					if(side == true) {  // 옆으로 이동하고 있을 때
						if(data[h][w-1] == 1 && data[h][w+1] == 1) {  //가로줄의 중간인 경우
							if(r_side == true) {
								w += 1;
							}else {
								w-= 1;
							}
						}
						else if(r_side == true && data[h][w+1] == 0) {  // 오른쪽으로 이동하다 다음 칸이 0인 경우
							h-=1;
							side = false;
						}else if(r_side == false && data[h][w-1] == 0) {  // 왼쪽으로 이동하다 다음 칸이 0인 경우
							h -=1;
							side = false;
						}
					}else {  // 위로 올라가는 경우
						if(data[h][w+1] == 1) {  // 오른쪽이 1로 자리가 있는 경우
							w += 1;
							side = true;
							r_side = true;  // 우측으로 이동중인 것을 표시
						}else if (data[h][w-1] == 1) {  // 왼쪽이 1로 자리가 있는 경우
							w -= 1;
							side = true;
							r_side = false;  // 좌측으로 이동중인 것을 표시
						}else {
							h-=1;   // 아니면 그냥 위로 올라간다.
						}
					}
				}else {  // 벽쪽의 사다리일 때
					if(w-1 < 0) {  // 좌측 벽쪽의 사다리
						if(data[h][w+1] == 1) {  // 우측에 자리가 있으면 이동합니다.
							w += 1;
							side = true;
							r_side = true;
						}else {
							h -= 1;
							side = false;
						}
					}else if(w+1 == 100) {  // 우측 벽쪽의 사다리
						if (data[h][w-1] == 1) {  // 좌측에 다리가 있으면 이동합니다.
							w -= 1;
							side = true;
							r_side = false;
						}else {
							h -=1;
							side = false;
						}
					}
				}
			} // while 문 끝
			System.out.println("#"+n+" "+w);
		}
		
	}
	
}
