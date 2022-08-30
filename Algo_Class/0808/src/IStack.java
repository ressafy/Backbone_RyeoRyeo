
public interface IStack<T> {
	void push(T t);
	T pop();
	T peek(); // 알려주기만 하지 삭제는 하지 않는다.
	boolean isEmpty();
	int size();
}
