package 스터디문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침 {  // 95퍼까지 올라왔읍니다....
	// 가르침을 받아 가르침을 해결...
	private static int N,K;
	private static String [] words;
	private static boolean [] visited = new boolean[26];
	private static int max = 0, s_count = 0;
	
	
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken())-5;  // 애초에 5를 빼준다.
		words = new String[N];
		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;  // 이 문자들은 꼭 들어가 있어야 한다.
		
		
		if(K < 0) {  // 5 아래는 0
			System.out.print(0);
			return;
		} else if(K >= 21) {  // 다 배울 수 있으면 모든 단어 가능 
			System.out.println(N);
			return;
		}else {
			for (int i = 0; i < N; i++) {
				String arr = br.readLine();
				words[i] = arr.substring(4,arr.length()-4);  // 접두사랑 접미사 없애준다.
			}  // 입력부 완 
			
			
			
			for (int i=0; i < 26; i++) {
				if (visited[i] == false) {
					dfs(i);
				}
			}
			boolean ccheck = false;
			for (int i = 0; i < N; i++) {
				if(words[i].length() == 0) {
					ccheck = true;
				}
			}
			if(ccheck) {
				max += 1;
			}
			System.out.println(max);
		}
	}
 	
 	
 	

 	
 	static void dfs(int index) {
 		visited[index] = true; // 방문 처리
 		s_count++;  // 배운 문자의 수 올려준다.
		if (s_count == K) {  // K 만큼 했으면 
			max = Math.max(check(), max);  // 최댓값 비교
		} else {
			for (int i = index + 1; i < 26; i++) {
				if (visited[i] == false) {
					dfs(i);
				}
			}
		}// 특정 알파벳에 대해 다 돌리고 나면 
		visited[index] = false; // 방문체크 없애주고 
		s_count--; // 배운 문자 수 하나 빼준다.
		
	}
 	
 	static int check() {
		int count = 0;
		for (int i=0; i < N; i++) { 
			boolean in = true;
			String word = words[i];
			for (int j=0; j < word.length(); j++) {
				if (visited[word.charAt(j) - 'a'] == false) {
					// 이제 단어들을 돌면서 배운 적이 없는 문자로 되어 있으면 그건 더하면 안된다. 
					in = false;
					break;
				}
			}
			if (in == true) {  // 전부 다 배운 문자로 이루어진 단어면 count ++
				count++;
			}
		}
		return count;
	}
 	
}