package week2_안려환;

public class 조이스틱 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(String name) {
		  int answer = 0;
		  int len = name.length();

		  int min = len - 1;

		  for (int i = 0; i < len; i++) {
		    // 상, 하 이동
		    char c = name.charAt(i);
		    int mov = (c - 'A' < 'Z' - c + 1) ? (c - 'A') : ('Z' - c + 1);
		    answer += mov;

		    //  좌, 우 이동
		    int nextIndex = i + 1;
		    while (nextIndex < len && name.charAt(nextIndex) == 'A')
		      nextIndex++;

		    min = Math.min(min, (i * 2) + len - nextIndex);
		  }

		  answer += min;

		  return answer;
		}
}
