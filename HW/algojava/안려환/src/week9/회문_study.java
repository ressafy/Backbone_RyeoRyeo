package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class 회문_study {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            String s = br.readLine();
            sb.append(checkPalindrome(s,0,0,s.length()-1));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // start 와 last 계속 비교하여 회문인지 판단
    // result 0 : 회문 / result 1 : 유사회문 / result 2 : 아무것도 아님
    public static int checkPalindrome(String s,int result, int start,int last){

        if(result==2){
            return 2;
        }

        while(start<=last){

            if(s.charAt(start) == s.charAt(last)){
                start++;
                last--;
            }
            else{
                result = Integer.min(checkPalindrome(s,result+1,start+1,last),checkPalindrome(s,result+1,start,last-1));
                break;
            }
        }
        
        return result;
    }
}