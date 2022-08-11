import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 완전 이진트리로 구현할 것이다. -> 마지막 레벨을 제외한 노드에 노드가 이진으로 꽉 차있다.
// 마지막 레벨에 채워가는 것은 좌측부터 채워간다. 중간에 비어있는 경우는 없다.
public class CompleteBinaryTree {
	private char [] nodes;
	private int lastIndex;  // 마지막 인덱스
	private final int SIZE;  // 객체 상수는 반드시 생성자에서 초기화를 해야한다.
	
	public CompleteBinaryTree(int size) {
		super();
		SIZE = size;
		nodes = new char[size + 1];  // 1 인덱스부터 사용
	}
	
	public boolean add (char e) {   // 완전 이진 트리에 맞게 추가
		// 완전 이진트리는 다음에 추가될 위치가 이미 정해져있다.
		if(lastIndex == SIZE) return false;
		nodes[++lastIndex] = e; // 0으로 자동 초기화된 값에다가
		return true;
		
	}
	
//	public void bfs() {
//		Queue<Integer> queue = new LinkedList<Integer>();
//		queue.offer(1); // 루트 노드를 집어넣어야 한다.
//		
//		while(!queue.isEmpty()) {
//			int current = queue.poll();  // 방문대상 정보 꺼내서 
//			System.out.print(nodes[current]+" ");  // 방문해서 해야할 일 처리
//			
//			// 현재 방문 노드의 자식 노드들을 대기열에 넣기
//			if(current*2 <= lastIndex) queue.offer(current*2);  // 왼쪽 자식
//			if(current*2+1 <= lastIndex) queue.offer(current*2+1); // 오른쪽 자식
//		}
//		System.out.println();
//	}
	
	public void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트 노드를 집어넣어야 한다.
		
		while(!queue.isEmpty()) {
			int size = queue.size();  // 큐의 크기 확인
			
			while(--size>= 0) {
				int current = queue.poll(); 
				System.out.print(nodes[current]+" ");
				
				// 현재 방문 노드의 자식 노드들을 대기열에 넣기
				if(current*2 <= lastIndex) queue.offer(current*2);  // 왼쪽 자식
				if(current*2+1 <= lastIndex) queue.offer(current*2+1); // 오른쪽 자식
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void dfs() {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1); // 루트 노드를 집어넣어야 한다.
		
		while(!stack.isEmpty()) {
			int current = stack.pop();  // 방문대상 정보 꺼내서 
			System.out.print(nodes[current]+" ");  // 방문해서 해야할 일 처리
			
			// 현재 방문 노드의 자식 노드들을 대기열에 넣기
			if(current*2 <= lastIndex) stack.push(current*2);  // 왼쪽 자식
			if(current*2+1 <= lastIndex) stack.push(current*2+1); // 오른쪽 자식
		}
		System.out.println();
	}
	
	public void dfsByPreOrder(int current) {  // 위에 while(!stack.isEmpty()) 돌릴 것
		System.out.print(nodes[current]+" ");  // 방문해서 해야할 일 처리
		
		if(current*2 <= lastIndex) dfsByPreOrder(current*2);
		if(current*2+1 <= lastIndex) dfsByPreOrder(current*2+1);
	}
	
	public void dfsByInOrder(int current) {  // 위에 while(!stack.isEmpty()) 돌릴 것
		if(current > lastIndex) return;
		dfsByInOrder(current*2);  // 일단 무조건 태워 보내서 조건 아니면 끝낸다.
		System.out.print(nodes[current]+" ");// 방문해서 해야할 일 처리
		dfsByInOrder(current*2+1);
	}  // 중간개념 가능한 이유는 이진트리이기 때문이다.
	
	public void dfsByPostOrder(int current) {  // 위에 while(!stack.isEmpty()) 돌릴 것
		if(current > lastIndex) return;
		dfsByPostOrder(current*2);  // 일단 무조건 태워 보내서 조건 아니면 끝낸다.
		dfsByPostOrder(current*2+1);
		System.out.print(nodes[current]+" ");// 방문해서 해야할 일 처리
	}// 이렇게 순서만 다르게 하면 된다.
}
