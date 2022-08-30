package week1_안려환;
import java.util.*;

public class 같은숫자는싫어 {
	public Queue <Integer> solution(int []arr) {
        Queue <Integer> list = new LinkedList<>();
        list.offer(arr[0]);  // 0인덱스 미리 꺼내준다.
        for(int i =1;i<arr.length-1;i++) {
        	if(arr[i] != arr[i+1]) {  // 수가 달라지면
        		list.offer(arr[i+1]);
        	}
        }
        
        return list;
        
    }
}
