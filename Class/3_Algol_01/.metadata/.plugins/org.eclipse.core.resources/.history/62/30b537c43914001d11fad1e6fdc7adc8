package 안려환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class P012_SWEA1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		for(int t = 1 ; t<11; t++) {
			Stack<String> stack1 = new <String>Stack();
			Stack<String> stack2 = new <String>Stack();
			Stack<String> stack3 = new <String>Stack();
			Stack<String> stack4 = new <String>Stack();
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			String []str = br.readLine().split("");  // char 단위로 받아낼 때 사용하자.
			int check = 0;
			for(int test = 0; test<n;test++) {
				switch(str[test]) {
				case "(":
					stack1.add(str[test]);
					break;
				case "{":
					stack2.add(str[test]);
					break;
				case "<":
					stack3.add(str[test]);
					break;
				case "[":
					stack4.add(str[test]);
					break;
				case ")":
					if(stack1.size()>0) {
						stack1.pop();
						break;
					}else {
						check = 1;
						break;
					}
				case "}":
					if(stack2.size()>0) {
						stack2.pop();
						break;
					}else {
						check = 1;
						break;
					}
				case ">":
					if(stack3.size()>0) {
						stack3.pop();
					}else {
						check = 1;
					}break;
				case "]":
					if(stack4.size()>0) {
						stack4.pop();
						break;
					}else {
						check = 1;
						break;
					}
				}

				
			}
			
			if(stack1.isEmpty() == false || stack2.isEmpty() == false || stack3.isEmpty() == false || stack4.isEmpty() == false) {
				check = 1;
			}
			if(check == 1) {
				check = 0;
			}else {
				check = 1;
			}
			sb.append("#").append(t).append(" ").append(check);
			System.out.println(sb);
			
			
		}
		

	}

}
