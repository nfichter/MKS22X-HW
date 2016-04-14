import java.util.*;

public class FrontierQueue<T> implements Frontier<T> {
	MyQueue<T> q;
	
	public FrontierQueue() {
		q = new MyQueue<T>();
	}
	
	public void add(T element) {
		q.enqueue(element);
	}
	
	public T next() {
		if (q.isEmpty()) {
			throw new NoSuchElementException();
		}
		return q.dequeue();
	}
	
	public boolean hasNext() {
		return (!q.isEmpty());
	}
	
	public String toString() {
		return q.toString();
	}
}