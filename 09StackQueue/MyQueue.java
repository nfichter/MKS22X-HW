import java.util.*;

public class MyQueue<T> {
	private MyLinkedList<T> MLL;
	
	public MyQueue() {
		MLL = new MyLinkedList<T>();
	}
	
	public void enqueue(T item) {
		MLL.add(item);
	}
	
	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return MLL.remove(0);
	}
	
	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return MLL.get(0);
	}
	
	public int size() {
		return MLL.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
}