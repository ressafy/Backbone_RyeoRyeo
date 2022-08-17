import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomTest {
	static class Meeting implements Comparable<Meeting>{
		int start,end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {  // 오름차순 -> 자연스럽게 오름차순 되려면 
			// 뺼셈의 상황에서는 음수에 양수를 빼면 언더플로우가 일어날 수 있고 양수 빼기 음수하면서 오버플로우가 일어날 수 있다.
			// 그러니까 둘의 부호의 섞임을 잘 파악하고 없다면 그냥 해도 된다.
			// 오름차순이면 this.해서 나를 앞에 두고 상대를 뒤에 둬서 하면 된다.
			
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
//		int N = Integer.parseInt(br.readLine());
		int N = sc.nextInt();
		
		Meeting [] meetings = new Meeting[N];
//		String [] arr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
//			meetings[i] = new Meeting(Integer.parseInt(arr[i]),Integer.parseInt(arr[i+1]));
			meetings[i] = new Meeting(sc.nextInt(),sc.nextInt());
		}
		List<Meeting> result = getSchedule(meetings);
		System.out.println(result.size());
		for(Meeting meeting:result) {
			System.out.println(meeting.start+" "+meeting.end);
		}
	}
	
	private static List<Meeting> getSchedule(Meeting[] meetings){
		List<Meeting> result = new ArrayList<Meeting>();
		Arrays.sort(meetings);
		result.add(meetings[0]);
		
		for (int i = 1, size = meetings.length; i < size; i++) {
			if((result.get(result.size()-1)).end <= meetings[i].start) {
				result.add(meetings[i]);
			}
		}
		
		return result;
	}
}
