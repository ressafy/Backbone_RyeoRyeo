package week1_안려환;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
	public List<Integer> solution(int[] progresses, int[] speeds) {
		List<Integer> list = new ArrayList<>();
        int [] days = new int [progresses.length];
        int check = 0;
        for( int i = 0; i<progresses.length;i++) {
        	if((100 - progresses[i]) % speeds[i] != 0) {
        		check = (100 - progresses[i]) / speeds[i] + 1;
        	}else {
        		check = (100 - progresses[i]) / speeds[i];
        	}
        	days[i] = check;
        }   // 이건 걸리는 일자를 모아두기 위한 코드이다. 
        int before = days[0];  //  전의 경과 일을 담아두기 위함.
        int cnt = 1;  // 체크이다. 일단 전의 경과일이 하나 있기에 1 해둔 것이다.
        for (int i = 1; i < days.length; i++){  
            if (before < days[i]){
                list.add(cnt);  // 이후 경과일이 더 걸리는 일이 오면 앞에꺼는 넣어야 한다.
                cnt = 1;  // 다시 원래의 1값으로 설정해둔 후
                before = days[i];
            } else{
            	cnt++;  // 이전 일수보다 적게 소요되는 애들 싹 모아준다.
            }
        }
        list.add(cnt);  // 구한 cnt 값을 넣어준다.

        
        return list;  // 반환 타입을 List<Integer> 로 바꿔주어 그대로 리턴할 수 있게 한다.
        
    }
}
