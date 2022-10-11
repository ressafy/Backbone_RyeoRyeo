package 스터디문제풀이;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * 내부에서 추월했으면 이거 순서가 그대로 나와야 하는 것인데
 * 순서가 달라졌다면 앞에 있는 녀석보다 뒤에 들어간 녀석이 먼저 나오면
 * 추월한 것이다.
 * 
 * **/
public class 추월 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result=0;
		int N=Integer.parseInt(br.readLine());
		
		String [] in = new String[N];
		String [] out = new String[N];
		// N 대씩 들어가고 나가니까 
		
		
		boolean check[]=new boolean[N];
		for(int i = 0; i < N; i++) {
			in[i]=br.readLine();
		}
		for(int i=0; i<N; i++) {
			out[i]=br.readLine();
		}  // 입력부 완
		
		
		
		for(int i = 0; i < N; i++) {
			String carNum = in[i];  // in 에 있는 
			for(int j = 0; j < N; j++) {
				if(out[j].equals(carNum)) {  // 
					check[j] = true;
					break;
				}
				if(check[j]) continue; // 순서에 맞게 들어온다면 넘겨버려
				result++; // 추월한 놈 있는 것 ++
				check[j]=true;
			}
		}

		System.out.println(result);
		

	}

}
