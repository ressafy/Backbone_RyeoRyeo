package week8_안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 킹 {
		static int[] dy = {0,0,-1,1,1,1,-1,-1};
		static int[] dx = {1,-1,0,0,1,-1,1,-1};
		
		static int ky,kx;
		static int sy,sx;
		
		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			String[] arr = br.readLine().split(" ");
			
			kx = arr[0].charAt(0)-'A';
			ky = arr[0].charAt(1)-'0'-1;
			
			sx = arr[1].charAt(0)-'A';
			sy = arr[1].charAt(1)-'0'-1;
			
			int N = Integer.parseInt(arr[2]);
			
			for (int i = 0; i < N; i++) {
				String order = br.readLine();
				
				List<Integer> pos = move(ky, kx, order);
				if(!check(pos.get(0),pos.get(1))) continue;  // 킹이 범위 밖으로 벗어나면 그 이동은 무시한다.
				
				// 킹이 움직여서 돌이랑 곂쳤을 때
				if(pos.get(0) == sy && pos.get(1) == sx) {
					//돌 이동시킨게 범위 안일때만 명령어 수행
					List<Integer> new_s = move(sy,sx,order);
					if(check(new_s.get(0), new_s.get(1))) {
						//돌 이동
						sy = new_s.get(0);
						sx = new_s.get(1);
						//킹 이동
						ky = pos.get(0);
						kx = pos.get(1);
					}
					
				}else {
					ky = pos.get(0);
					kx = pos.get(1);
				}
				
			}
			
			//마지막 위치 출력
			sb.append((char)(kx+65)).append(ky+1).append("\n");  // 65는  char
			sb.append((char)(sx+65)).append(sy+1).append("\n");
			System.out.print(sb);
		}
		//범위 체크
		private static boolean check(int y, int x) {
			if(y < 0 || y >= 8 || x < 0 || x >= 8) {
				return false;
			}
			return true;
		}

		private static List<Integer> move(int y, int x, String o) {
			int ny=0 , nx=0;
			List<Integer> pos = new ArrayList<Integer>();
			switch (o) {
				case "R":
					ny = y + dy[0];
					nx = x + dx[0];
					break;
				case "L":
					ny = y + dy[1];
					nx = x + dx[1];
					break;
				case "B":
					ny = y + dy[2];
					nx = x + dx[2];
					break;
				case "T":
					ny = y + dy[3];
					nx = x + dx[3];
					break;
				case "RT":
					ny = y + dy[4];
					nx = x + dx[4];
					break;
				case "LT":
					ny = y + dy[5];
					nx = x + dx[5];
					break;
				case "RB":
					ny = y + dy[6];
					nx = x + dx[6];
					break;
				case "LB":
					ny = y + dy[7];
					nx = x + dx[7];
					break;
			
			}
			pos.add(ny);
			pos.add(nx);

			return pos;
			

		}

}
