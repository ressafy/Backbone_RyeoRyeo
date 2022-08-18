package week_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  집의 위치를  List에 담아 놓고 
 *  K영역 안에 집의 개수를 세어서  max값을 구한다.
 *  1. 도시 정보를 읽으면서 집의 위치(r,c)에 해당 하는 정보를 List에 담는다. 
 *  2. K의 최대값까지 반복 하면서 
 *        K의 최대값을 구하기
 *           N이 홀수이면 중심점에서 K가 최대 N일때 모든 영역을 다 포함한다. 
 *           하지만 짝수일때는  중심점에서 K가 최대 N+1일때 모든 영역을 다 포함한다.
 *  3. N*N을 반복하면서 각각의 영역에서 K값에 해당하는 영역에 집이 있는지 확인 
 *     집의 위치와 K영역의 거리 계산하기 
 *     무선 충전에서 범위 내의 거리 계산하기 식을 응용 
 *     D = |XA – XB| + |YA – YB|
 *   
 *  
 *  211ms
 */
class House{
	int r;
    int c;
    public House(int r,int c) {
    	this.r=r;
        this.c=c;
    }
}
public class 교수님_홈방법서비스 {
	static int N, M, K;
    static int max;
    static ArrayList<House> house;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            house = new ArrayList<>();
            for (int i = 0; i<N ; i++) {
                String line= br.readLine();
                for (int j = 0, k=0 ; j<N ; j++, k+=2) {
                    if(line.charAt(k)=='1')  house.add(new House(i,j));
                }
            }
            max=0;
            K=1;
            //N이 짝수일때는  N+1이어야 중심점에서 모든 영역을 다 채울 수 있다
            int end =  N%2==0? N+2:N+1;
            while(K<end) {

                check();
                K++;
            }
            System.out.println("#" + tc +  " " + max);
        }
    }
    static void check() {
        for (int i =0 ; i <N ; i++) {
            for (int j = 0 ; j<N ; j++) {
                check_house(i,j);
            }
        }
    }
    static void check_house(int r, int c) {
        int cnt=0;
        House cur;
        for (int i =0 ; i <house.size() ; i++) {
//        	K 범위 내에 집이 있는지 검사 D = |XA – XB| + |YA – YB| 
            if (Math.abs(r-house.get(i).r) + Math.abs(c-house.get(i).c)<K) {
                cnt++;	//있으면 집 개수 증가 
            }
        }
        //운영값 계산해서 max값 증가 
        if (K*K+(K-1)*(K-1)<=cnt*M){
            max=Math.max(max, cnt);
        }
    }
}