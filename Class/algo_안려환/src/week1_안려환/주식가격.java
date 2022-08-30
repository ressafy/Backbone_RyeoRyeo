package week1_안려환;

import java.util.Stack;


// 문제 이해 자체를 못해서 풀이를 보고 나서 이해를 했읍니다....
class Solution2 {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {  // 비어있지 않으면서 고가보다 
                ans[stack.peek()] = i - stack.peek();  // 그 값에 구매한 주식은 
                stack.pop(); // 답을 구했기 때문에 stack에서 제거한다  -> 이건 떨어진 주식에 대한 정보를 가져오기 위함이다.
            }
            stack.push(i);  // 올라간 주식
        }

        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            ans[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return ans;
    }

}