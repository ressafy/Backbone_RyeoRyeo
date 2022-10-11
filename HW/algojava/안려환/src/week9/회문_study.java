package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 재귀적으로 가운데로 파고들어가면서 회문인지 판단한다.
public class 회문_study {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            String s = br.readLine();  // 입력부 
            sb.append(checkPalindrome(s,0,0,s.length()-1));  // 차피 문장으로 입력받으니 그대로 사용한다.
            sb.append("\n");
        }
        System.out.println(sb);
    }


    // result 0 : 회문 / result 1 : 유사회문 / result 2 : 아무것도 아님
    public static int checkPalindrome(String s,int result, int start,int last){

        if(result==2){  // 아무 것도 아님
            return 2;
        }
        
        while(start<=last){ // start 와 last 계속 비교하여 회문인지 판단함

            if(s.charAt(start) == s.charAt(last)){  // 글자가 같으면 이제 가운데로 파고가면서 탐색을 계속한다.
                start++;
                last--;
            }
            else{
            	// 0이 회문이기에 문자가 좀 다르면 1씩 증가시켜 유사회문 그리고 아무것도 아닌 문자인 것을 표시하게 합니다.
                result = Integer.min(checkPalindrome(s,result+1,start+1,last),checkPalindrome(s,result+1,start,last-1));
                break;
            }
        }
        
        return result;
    }
}