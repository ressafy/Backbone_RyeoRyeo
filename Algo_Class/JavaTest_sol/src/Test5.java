import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Baduk_doll {
	int y, x, type;// type 1 = 검은돌, 2 = 흰돌

	public Baduk_doll(int y, int x, int type) {
		this.y = y;
		this.x = x;
		this.type = type;
	}

}

public class Test5 {
	private static int N, map[][];
	private static List<Baduk_doll> list = new ArrayList<>();
	private static boolean visited[][];
                          //(상 하) (좌 우) (좌하 우상) (좌상 우하)
	private static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
	private static int dy[] = {-1, 1, 0, 0, 1, -1, -1, 1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Test5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		N = 19; // 바둑판 가로, 세로 19

		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];

		for( int i = 1; i <= N; i++ ) {
			stt = new StringTokenizer(br.readLine());  // 이것만 봐도 아 비효율이네...
			for( int j = 1; j <= N; j++) {
				int rock = Integer.parseInt(stt.nextToken());
				map[i][j] = rock;

				if(rock != 0) list.add(new Baduk_doll(i, j, rock));
			}
		}

		search();
	}

	private static void search() {
		for ( int i = 0; i < list.size(); i++) { // 받아온 바둑돌을 기준으로 전부 탐색
			Baduk_doll tmp = list.get(i);

			int cur_y = tmp.y; // 기준되는 바둑돌의 x좌표
			int cur_x = tmp.x; // 기준되는 바둑돌의 y좌표
			int type = tmp.type; // 흑, 백
			int cnt = 1;

			int save_x = 0; // 돌이 5개 만들어졌을때의 x와 y좌표를 저장
			int save_y = 0;
			boolean vic = false; // 승리 맞는지 아닌지. 돌이 6개이상이 될 경우도 생각해야함

			visited[cur_y][cur_x] = true; // 현재 위치 방문

			for( int k = 0; k < 8; k++) { // 8방향탐색
				cur_y += dy[k];
				cur_x += dx[k];
				if(cur_y < 1 || cur_y >= N+1 || cur_x < 1 || cur_x >= N+1) {
					// 전방향 탐색을 하지만 일종의 페어가 존재한다
					// -상,하-, -좌,우-, -우상,좌하-, -좌상,우하-를 하나의 페어로 보고
					// k 인덱스가 짝수단위로 올라가는 순간 다른 페어가 된다고 판단 
                       // (0,1) (2,3) (4,5) (6,7) 이므로
					if((k+1)%2 == 0) cnt = 1;
					visited = new boolean[N+1][N+1]; // 방문 모두 초기화  계속 이 라인이 비효율적으로 실행이 된다. 이거 말고 Collections.fill(0) 이거 써라
					cur_y = tmp.y; // 제일 처음 바독돌의 위치로 
					cur_x = tmp.x;
					continue;
				} 
				if(map[cur_y][cur_x] != type ) { // 탐색하다가 자신과 다른 타입을 만남
					if((k+1)%2 == 0) cnt = 1; // 페어인지 판단
					visited = new boolean[N+1][N+1]; // 방문초기화
					cur_y = tmp.y; // 제일 처음 바독돌의 위치로 
					cur_x = tmp.x;
					continue;
				}

				cnt++; // 같은 타입, 같은 페어, 방문안한 지점이면 카운트 + 1
				k--; // 같은 방향으로 탐색을 이어가야하므로 k-1

				if( cnt == 5) { // 만약 바둑돌이 연속으로 5개가 있는 경우
					save_x = cur_x; // 현재 위치를 저장한다.
					save_y = cur_y;
					vic = true; // 승리 플래그 일단 true
				} else if( cnt > 5 ) { // 세다보니 5개보다 많더라하는 경우
					if(vic) {
						vic = false; // 승리 취소
					}
				}
			} // 8방탐색 종료
			
			if( vic ) { // 승리가 맞다면
				System.out.println(type); // 현재 타입
				if( tmp.x < save_x) // 탐색 기준지점이 끝 지점보다 왼쪽
					System.out.println(tmp.y + " " + tmp.x);
				else if( tmp.x == save_x) { // 기준지점과 끝지점이 같은 x라인 == 세로로 한줄
					if(save_y < tmp.y)
						System.out.println(save_y + " " + save_x);
					else
						System.out.println(tmp.y + " " + save_x);
				} else { // 탐색 기준지점이 끝 지점보다 오른쪽
					System.out.println(save_y + " " + save_x);
				}
				return;
			}
		}
		// 리턴되지 않고 여기까지 왔다는 것은 흑,백 둘다 승리하지 못했음을 나타낸다.
		System.out.println("0");
	}
}

