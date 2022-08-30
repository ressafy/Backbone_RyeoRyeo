
public class SsafyStack<E> implements IStack<E>{
	
	private Node<E> top; // 첫번째 노드를 기억해야 하기 때문이다.

	@Override
	public void push(E data) { // 첫노드 삽입하는 알고리즘
		top = new Node<E>(data, top);
	}

	@Override
	public E pop() {
		if(isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가능합니다.");
			return null;
		}
		
		Node<E> popNode = top;
		top = popNode.link; // 빼려고 하는 노드의 다음 노드?
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if(isEmpty()) {
			System.out.println("공백스택이어서 작업이 불가능합니다.");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {  // 끝까지 탐색한 노드의 개수가 size 이다.
		int cnt = 0;
		for (Node<E> temp = top; temp != null; temp = temp.link) {
			++cnt;
		}
		return cnt;
	}

}
