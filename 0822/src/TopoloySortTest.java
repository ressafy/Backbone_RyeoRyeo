import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;



public class TopoloySortTest {
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
		
	}
	static int V,E;
	static Node[] adjList;
	static int [] inDegree;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V+1];
		int [] inDegree = new int[V+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			
			// 유향처리
			adjList[from] = new Node(to, adjList[from]);  // a 의 인접에 b 넣을  수 있다. 그리고 헤드를 물려준다.
			inDegree[to]++;
		}
		ArrayList<Integer> list = topoloySort();
		if(list.size() == V) { // 위상정렬 완성
			for(Integer i : list) {
				System.out.println(i+" ");
			}
		}else {
			System.out.println("cycle");
		}
		

	}
	
	private static ArrayList<Integer> topoloySort(){
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i <= V; i++) {
			if(inDegree[i] ==0) queue.offer(i);
		}
		
		//BFS
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			list.add(cur);
			
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if(--inDegree[temp.vertex] == 0) queue.offer(temp.vertex);
			}
		}
		return list;
	}

}
