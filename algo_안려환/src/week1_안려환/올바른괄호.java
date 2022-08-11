package week1_안려환;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);  // 하나씩 받아와서
            
            if(c == '('){  // 여는 괄호일 때
                stack.push(c);
            }
            
            if(c == ')'){  // 닫는 괄호일 때
                if(stack.size() == 0){
                    return false;  // 들어있는 것이 없으면 잘못된 것이다.
                }
                else stack.pop();
            }
        }
        if(stack.size() != 0) answer = false;  // 들어있는 것이 없으면 잘못된 것

        return answer;
    }
}