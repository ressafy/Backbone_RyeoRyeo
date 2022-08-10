
public class Node <T>{
	public T data;
	public Node<T> link;
	
	public Node(T data, Node<T> link) {
		super();
		this.data = data;
		this.link = link;
	}
	public Node() {
		super();
		this.data = data;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	
	
	

}
