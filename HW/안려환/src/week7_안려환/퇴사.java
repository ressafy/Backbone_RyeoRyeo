package week7_안려환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] Inc = new int[N+2];

        for (int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            if (i + T[i] > N + 1) Inc[i] = Inc[i+1];
            else {
            	Inc[i] = Math.max(Inc[i+1], P[i] + Inc[i+T[i]]);
            }
        }
        System.out.println(Inc[1]);
    }
}