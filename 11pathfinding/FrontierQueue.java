import java.util.*;

public class FrontierQueue<T> implements Frontier<T> {
	MyQueue<T> f;
	
	public FrontierQueue() {
		f = new MyQueue<T>();
	}
	
	public void add(T element) {
		f.enqueue(element);
	}
	
	public T next() {
		if (f.isEmpty()) {
			throw new NoSuchElementException();
		}
		return f.dequeue();
	}
	
	public boolean hasNext() {
		return (!f.isEmpty());
	}
}