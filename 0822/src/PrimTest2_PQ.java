import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest2_PQ {

	static class Node{
		int vertex,weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
		
	}
	
	static class Vertex{
		int no,weight;
		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] adjList = new Node[V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 무항처리 인접리스트를 만들었다.
			adjList[from] = new Node(to, weight, adjList[from]);  // a 의 인접에 b 넣을  수 있다. 그리고 헤드를 물려준다.
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		//프림 알고리즘에 필요한 자료구조
		int [] minEdge = new int[V]; // 간선 비용 중 최소비용 저장할 것이 필요하다. 각 정점입장에서 신장트리에 포함된 정점과의 간선 비용 중 최소 비용
		boolean[] visited = new boolean[V];  // 신장 트리에 포함되어 있는지 여부
		
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 관리하기 위해 큰 값 세팅해둔다.
		
		// 1. 임의의 시작점 처리
		// 임의의 정점이 시작점이 될 수 있는 전처리를 해야 한다. 0번 정점을 편의상 신장 트리의 구성의 시작점으로 
		minEdge[0] = 0; // 먼저 최소로 해둬야 한다. - 자기가 자신으로의 연결 비용은 없으니
		int result = 0; // 최소 신장트리 비용 누적
		
		
		/////////////////////////////// 추가 ////////////////////////////////////
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>((v1,v2) -> v1.weight - v2.weight);  // 간선의 비용이 작은 순으로 나오게 하였다.
		pQueue.offer(new Vertex(0,minEdge[0]));
		
		// pQ 의 자리조정은 삽입과 삭제가 일어날 때만 된다.
		
		// !!! 여기의 V를 logV의 느낌으로 바꿔보자 -> Priority que를 사용해서
		int cnt = 0;
		while (true) { // V개의 정점 처리하면 끝
			// step 1. 신장 트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
			Vertex minVertex = pQueue.poll();
			
			
			//////////////////////////////////// 변경 ///////////////////////////////
			if(visited[minVertex.no]) continue;
			//step 2. 신장트리에 추가
			visited[minVertex.no] = true;  // from 이 minVertex 로 정해진 것이다.
			result += minVertex.weight;
			if(++cnt == V) break;
			
			
			//step 3. 신장트리에 새롭게 추가되는 정점과 신장트리에 포함되지 않은 정점들의 기존 최소 비용과 비교해서 갱신
			//        신장트리에 새롭게 추가되는 정점의 모든 인접 정점 들여다보며 처리한다.
			for(Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {  // temp.weight 
					minEdge[temp.vertex] = temp.weight;  // 비용을 이렇게 갱신해둔다.
					pQueue.offer(new Vertex(temp.vertex,minEdge[temp.vertex]));
				}
			}  // 여기 돌고 있는건 지금 선택한 인접 리스트들이다.
		}
		System.out.println(result);
	}
	

}