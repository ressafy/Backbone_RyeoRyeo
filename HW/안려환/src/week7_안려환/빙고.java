package week7_안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고 {
	static int [][] arr = new int[5][5];  // 빙고판은 25로 고정
	static int num;  // 숫자 부름 수
	static int count;  // 빙고 체크 3이면 부름
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	for(int i = 0; i < 5; i++) {  // 빙고판 만들기
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 5; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i = 0; i < 5; i++) {  // 숫자 부르기
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 5; j++) {
    			num++;
    			check(Integer.parseInt(st.nextToken()));
    			bingoCheck();
    			if(count >= 3) {
    				System.out.println(num);
    				return;
    			}
    		}
    	} 	
    }
    
    
    public static void check(int n){
    	for(int i = 0; i < 5; i++) {
    		for(int j = 0; j < 5; j++) {
    			if(arr[i][j] == n) {
    				arr[i][j] = -1;  // 5빙고를 맞춰주기 위함인데 0보다는 -1 을 이용해서 5개의 칸이 지워졌나 
    			} // 체크를 해준다.
    		}
    	}
    }
    
    // 줄 검사 
    public static void bingoCheck() {
    	count = 0;  // 하나 불러줄 때마다 모든 칸을 검사해서 3빙고인지 확인하기 위해 매번 0으로 초기화
    	int row = 0; // 가로
    	int col = 0; // 세로
    	int right = 0; // 오른쪽 아래
    	int left = 0; // 왼쪽 아래
    	int index = 0;
    	for(int i = 0; i < 5; i++) {
    		row = 0;
    		col = 0;
    		for(int j = 0; j < 5; j++) { // 판의 모든 값을 돌면서 체크
    			row += arr[i][j];
    			col += arr[j][i];
    			
    			if(i == j) { // 오른쪽 아래를 향하고 있는 칸의 값을 전부 더해서 -5가 되나 확인하기 위함
    				right += arr[i][j];
    			}
    			if(i == index && j == 4 - index) { // 왼쪽 아래를 향하고 있는 값을 더해 -5 체크
    				left += arr[i][j];
    				index++;
    			}
    		}
    		if(row == -5) {
    			count++;
    		}
    		if(col == -5) {
    			count++;
    		}
    		if(right == -5) {
    			count++;
    		}
    		if(left == -5) {
    			count++;
    		}
    	}
    }
}