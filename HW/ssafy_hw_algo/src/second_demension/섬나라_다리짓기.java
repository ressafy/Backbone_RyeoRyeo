package second_demension;

import java.util.Scanner;

public class 섬나라_다리짓기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		// n * n 크기 배열 선언 ( 지도 )
		int[][] map = new int[n][n];
		
		// 지도 정보 입력 받기
		for ( int i = 0 ; i<n ; i++ ) {
			for ( int j = 0 ; j<n; j++ ) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 최대값 저장
		int maxDistance = 0;
		
		for ( int i = 0;  i<n ; i++ ) {
			for ( int j =0 ; j<n ; j++ ) {
				
				// 지금 위치가 섬인지 검사
				if ( map[i][j] == 1 ) {
					
					// 섬이면 현재 위치로부터 사방탐색 하여 가로 또는 세로에 있는 섬과 거리 측정, 최대값 저장
					
					// 동쪽이 1인지 검사
					for (int d = j+1; d<n ; d++) {
						if ( map[i][d] == 1 ) {
							maxDistance = Math.max( maxDistance , d-j-1 );  // max 는 두 값중 큰 것을 넣어준다.
							break;
						}
					}
					
					// 서쪽이 1인지 검사
					for (int d = j-11; d>0 ; d--) {
						if ( map[i][d] == 1 ) {
							maxDistance = Math.max( maxDistance , j-d );
							break;
						}
					}
					
					// 북쪽이 1인지 검사
					for (int d = i-1; d>0 ; d--) {
						if ( map[d][j] == 1 ) {
							maxDistance = Math.max( maxDistance , i-d-1 );
							break;
						}
					}
					
					// 남쪽이 1인지 검사
					for (int d = i+1; d<n ; d++) {
						if ( map[d][j] == 1 ) {
							maxDistance = Math.max( maxDistance , d-i-1 );
							break;
						}
					}
				}
			}
		}
		
		System.out.println(maxDistance);

	}
}
