package week2_안려환;

public class 소수찾기 {

	public static void main(String[] args) {
		
	}

	public int solution(int n) {
	     int answer = 0;  // 리턴해줄 답
	     for(int i=2; i<=n; i++){
	         boolean flag = true;
	         for(int j = 2; j <= Math.sqrt(i); j++) {  // 제곱근 구하기
	        	 if(i % j == 0)  { // 소수 확인을 위한 if
	        	   flag = false; // 소수가 아닌 경우
	                   break; //break를 안해주면 효율성 테스트 통과 못함
	        	  } 
	           }
	      if(flag==true) // 만약 이게 소수라면
	         answer++; 
	    }
	   return answer;
	}
}
