import java.util.Scanner;

public class DP_최소동전개수구하기 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int[] D = new int[money+1]; // money일때 최소 동전의 개수
        int min;
        for(int i=1; i<=money; ++i) {
            min = Integer.MAX_VALUE;
            if(i>=1 && min > 1+D[i-1]) min = 1+ D[i-1];  // 마지막에 1원을 낼때
            if(i>=4 && min > 1+D[i-4]) min = 1+ D[i-4]; // 마지막에 4원을 낼경우
            if(i>=6 && min > 1+D[i-6]) min = 1+ D[i-6]; // 마지막에 6원을 낼경우
            D[i] = min;
        }
        System.out.println(D[money]);
    }
    }