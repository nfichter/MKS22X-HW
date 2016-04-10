import java.util.*;

public class FrontierStack<T> implements Frontier<T> {
	MyStack<T> f;
	
	public FrontierStack() {
		f = new MyStack<T>();
	}
	
	public void add(T element) {
		f.push(element);
	}
	
	public T next() {
		if (f.isEmpty()) {
			throw new NoSuchElementException();
		}
		return f.pop();
	}
	
	public boolean hasNext() {
		return (!f.isEmpty());
	}
}