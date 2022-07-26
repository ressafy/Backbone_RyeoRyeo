package 기본문법;

import java.util.Scanner;

public class 가위바위보 {
	int cnt = 0;
	int me = 0;
	int l_cnt = 0;
	
	public int user(String rcp) {
		if(rcp.equals("가위")) {  // 사용자 입력 수로 변경
			me = 1;
		}else if (rcp.equals("바위")) {
			me = 2;
		}else if(rcp.equals("보")){
			me = 3;
		}else {
			System.out.println("wrong!!");
		}
		return me;
	}
	
	public int game(int me,int com) {
		if (com == 1) {  // 컴퓨터가 가위낸 상황
			if (me == 1) {
				System.out.println("비겼습니다!!!");
			}else if(me == 2) {
				System.out.println("이겼습니다!!!");  // 내가 바위 내야 이김
				cnt ++;
			}else if(me == 3){
				System.out.println("졌습니다!!!");
				l_cnt ++;
			}
		}else if(com == 2) {  // 컴퓨터가 바위낸 상황
			if (me == 1) {
				System.out.println("졌습니다!!!");
				l_cnt ++;
			}else if(me == 2) {
				System.out.println("비겼습니다!!!");
			}else if(me == 3){
				System.out.println("이겼습니다!!!");  // 내가 보 내야 이김
				cnt ++;
			}
		}else if(com == 3){  // 컴퓨터가 보낸 상황
			if (me == 1) {
				System.out.println("이겼습니다!!!");  // 내가 가위 내야 이김
				cnt ++;
			}else if(me == 2) {
				System.out.println("졌습니다!!!");
				l_cnt ++;
			}else if(me == 3){
				System.out.println("비겼습니다!!!");
			}
		}
		
		if(cnt > l_cnt) {
			return 1;
		}else if (cnt == l_cnt) {
			return 0;
		}else {
			return -1;
		}
		
	}
	public void findWinner(int go) {
		if (go == 1) {
			System.out.println("사용자 승!!!");
		}else if (go == 0) {
			System.out.println("비겼습니다.");
		}else {
			System.out.println("컴퓨터 승!!!");
		}
	}

	public static void main(String[] args) {
		int rand = (int) (Math.random()*(2)) + 1;
		int com,game;
		int nono = 0;
		String rcp;
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println();
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.println();
		System.out.print("번호를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		game = sc.nextInt();
		가위바위보 s = new 가위바위보();
		if(game == 1) {
			
			com = rand;
			for(int i =0;i<5;i++) {
				System.out.print("가위바위보 중 하나 입력: ");
				Scanner sc2 = new Scanner(System.in);
				rcp = sc2.nextLine();
				int me = s.user(rcp);
				sc2.close();  // 그냥 경고창 뜨는게 싫어서 넣었다.
				nono = s.game(me, com);
			}
			s.findWinner(nono);
		}
		else if (game == 2) {
			com = rand;
			for(int i =0;i<3;i++) {
				System.out.print("가위바위보 중 하나 입력: ");
				Scanner sc2 = new Scanner(System.in);
				rcp = sc2.nextLine();
				int me = s.user(rcp);
				sc2.close(); // 그냥 경고창 뜨는게 싫어서 넣었다.
				nono = s.game(me, com);
			}
			s.findWinner(nono);
			
		}else if(game == 3){
			com = rand;
			for(int i =0;i<1;i++) {
				System.out.print("가위바위보 중 하나 입력: ");
				Scanner sc2 = new Scanner(System.in);
				rcp = sc2.nextLine();
				int me = s.user(rcp);
				sc2.close(); // 그냥 경고창 뜨는게 싫어서 넣었다.
				nono = s.game(me, com);
			}
			s.findWinner(nono);
		}
		sc.close(); // 그냥 경고창 뜨는게 싫어서 넣었다.
	}
}

