import java.util.*;

public class MyStack<T> {
	private MyLinkedList<T> MLL;
	
	public MyStack() {
		MLL = new MyLinkedList<T>();
	}
	
	public void push(T item) {
		MLL.add(item);
	}
	
	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return MLL.remove(size()-1);
	}
	
	public T peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return MLL.get(size()-1);
	}
	
	public int size() {
		return MLL.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}

	public String toString() {
	    return MLL.toString();
	}

	public static void main(String[] args) {
	    Stack<Integer> s = new Stack<Integer>();
	    s.push(1);
	    s.push(2);
	    s.push(3);
	    System.out.println(s);
	    MyStack<Integer> ms = new Stack<Integer>();
	}
}
