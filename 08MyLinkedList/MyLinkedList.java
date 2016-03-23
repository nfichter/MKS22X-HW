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
	if (size == index) {
	    return add(thing);
	}
	if (index == 0) {
	    next.setNext(start);
	    start = next;
	    size++;
	    return true;
	}
	LNode current = start;
	for (int i = 0; i < index-1; i++) {
	    current = current.getNext();
	}
        next.setNext(current.getNext());
	current.setNext(next);
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
	    size--;
	    return ret;
	}
	LNode current = start;
	for (int i = 0; i < index-1; i++) {
	    current = current.getNext();
	}
	
	if (index < size-1) {
	    current.setNext(current.getNext().getNext());
	}
	else {
	    end = current;
	}
	T ret = current.getNext().getData();
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
	
	public class MyLinkedListIterator implements Iterator<T> {
		int pos;
		LNode current;
		
		public MyLinkedListIterator(MyLinkedList<T> L) {
			pos = 0;
			current = L.start;
		}
		
		public boolean hasNext() {
			if (current.getNext() != null) {
				return true;
			}
			return false;
		}
		public T next() {
			pos = 1;
			T ret = current.getData();
			current = current.getNext();
			return ret;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

    private class LNode {
	T data;
	LNode next;

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
		for (int i = 0; i < 100; i++) {
			L.add(i+"");
		}
		
	}
}
