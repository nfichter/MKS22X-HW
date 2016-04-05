import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
	private LNode start;
	private LNode end;
	private int size;

	public MyLinkedList() {
		size = 0;
	}

	public boolean addOld(T thing) {
		if (size == 0) {
			start = new LNode(thing);
			end = start;
			size++;
		}
		else {
			LNode next = new LNode(thing);
			LNode current = start;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(next);
			end = current.getNext();
			size++;
		}
		return true;
	}

	public boolean add(T thing) {
		if (size == 0) {
			start = new LNode(thing);
			end = start;
			size++;
		}
		else {
			LNode next = new LNode(thing);
			end.setNext(next);
			next.setPrev(end);
			end = next;
			size++;
		}
		return true;
	}

	public boolean add(int index, T thing) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		LNode next = new LNode(thing);
		if (size == index || size == 0) {
			return add(thing);
		}
		if (index == 0) {
			next.setNext(start);
			start.setPrev(next);
			start = next;
			size++;
			return true;
		}
		LNode current = start;
		for (int i = 0; i < index-1; i++) {
			current = current.getNext();
		}
		next.setNext(current.getNext());
		next.setPrev(current);
		current.setNext(next);
		next.getNext().setPrev(next);
		return true;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LNode current = start;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getData();
	}

	public T set(int index, T newThing) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LNode current = start;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		if (index == size-1) {
			end = current;
		}
		return current.setData(newThing);
	}

	public int size() {
		return size;
	}

	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			T ret = start.getData();
			start = start.getNext();
			start.setPrev(null);
			size--;
			return ret;
		}
		LNode current = start;
		for (int i = 0; i < index-1; i++) {
			current = current.getNext();
		}
		
		T ret = null;
		if (index < size-1) {
			current.setNext(current.getNext().getNext());
			current.getNext().setPrev(current);
			ret = current.getNext().getData();
		}
		else {
			end = current;
			ret = current.getNext().getData();
			current.setNext(null);
		}
		size--;
		return ret;
	}

	/*public int indexOf(T thing) {
	LNode current = start;
	for (int i = 0; i < size; i++) {
		if (current.getData().equals(thing)) {
		return i;
		}
		current = current.getNext();
	}
	return -1;
	}*/

	public String toString() {
		String ret = "[";
		LNode current = start;
		while (current != null && current.getNext() != null) {
			ret += current.getData().toString() + ", ";
			current = current.getNext();
		}
		if (current != null) {
			ret += current.getData().toString();
		}
		ret += "]";
		return ret;
	}

	public String toString(boolean debug) {
		String ret = toString();
		if (debug) {
			ret += "\nstart: " + start.getData().toString() + " end: " + end.getData().toString() + " size: " + size;
		}
		return ret;
	}
	
	public Iterator<T> iterator() {
		return new MyLinkedListIterator(this);
	}

	public Iterator<T> iteratorBack() {
	    return new MyLinkedListIteratorBack(this);
	}
	
	public class MyLinkedListIterator implements Iterator<T> {
		LNode current;
		
		public MyLinkedListIterator(MyLinkedList<T> L) {
			current = L.start;
		}
		
		public boolean hasNext() {
			if (current != null) {
				return true;
			}
			return false;
		}
		public T next() {
			T ret = current.getData();
			current = current.getNext();
			return ret;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public class MyLinkedListIteratorBack implements Iterator<T> {
	    LNode current;
	    
	    public MyLinkedListIteratorBack(MyLinkedList<T> L) {
		current = L.end;
	    }
	    
	    public boolean hasNext() {
		if (current == null) {
		    return false;
		}
		return true;
	    }

	    public T next() {
		T ret = current.getData();
		current = current.getPrev();
		return ret;
	    }

	    public void remove() {
		throw new UnsupportedOperationException();
	    }
	}

	private class LNode {
		T data;
		LNode next;
		LNode prev;

		public LNode(T data) {
			this.data = data;
		}

		public LNode getNext() {
			return next;
		}

		public LNode setNext(LNode next) {
			this.next = next;
			return next;
		}
		
		public LNode getPrev() {
			return prev;
		}
		
		public LNode setPrev(LNode prev) {
			this.prev = prev;
			return prev;
		}

		public T getData() {
			return data;
		}

		public T setData(T data) {
			this.data = data;
			return data;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> L = new MyLinkedList<String>();
		for (int i = 0; i < 10; i++) {
			L.add(i+"");
		}
		Iterator forwards = L.iterator();
		while (forwards.hasNext()) {
		    System.out.print(forwards.next() + " ");
		}
		System.out.println();
		System.out.println();
		Iterator backwards = L.iteratorBack();
		while (backwards.hasNext()) {
		    System.out.print(backwards.next() + " ");
		}
		System.out.println();
	}
}
