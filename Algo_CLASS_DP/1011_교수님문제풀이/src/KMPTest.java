import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KMPTest {
	
	/**input
	 * 
	 * 
	 * 
ababababcababaca
ababaca
 
==>
1
[9]

aaaaaab
aaa

==>
4
[0, 1, 2, 3]

ababababcababaca
abacabab

==>
0
	 * **/   
	
	
	/**
	 * 
	 * https://bowbowbow.tistory.com/6
	 * 
	 * **/

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;
		
		// 부분일치테이블 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){// i:접미사 포인터(i=1부터 시작: 우리는 부분일치테이블를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.), j:접두사 포인터
	    	// for문 안에 while 으로 조건 만족할 때까지 넣은 이유는 최대한 중간 단계를 뛰어넘기 위함
	    	while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1];   // j 에 해당 이전 값을 인덱스로 처리해준다....
	        
	        if(pattern[i] == pattern[j]) pi[i] = ++j; // pi는 접두사와 접미사가 동일한 패턴을 가진 문자열의 최대 길이를 저장하는 배열이다.
	        else pi[i] = 0;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터 
		for(int i=0,j=0; i<tLength; ++i) { 
			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1]; 
			
			if(text[i] == pattern[j]) { //두 글자 일치
				if(j == pLength-1) { // j가 패턴의 마지막 인덱스라면 
					cnt++; // 카운트 증가
					list.add(i-j);  
					j=pi[j]; 
				}else { 
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		if(cnt>0) {
			System.out.println(list);
		}
	}
}
