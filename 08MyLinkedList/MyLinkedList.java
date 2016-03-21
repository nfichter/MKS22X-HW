public class MyLinkedList<T> {
    LNode<T> start;
    LNode<T> end;
    int size;

    public MyLinkedList() {
	size = 0;
    }

    public boolean addOld(T thing) {
	if (size == 0) {
	    start = new LNode<T>(thing);
	    end = start;
	    size++;
	}
	else {
	    LNode<T> next = new LNode<T>(thing);
	    LNode<T> current = start;
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
	    start = new LNode<T>(thing);
	    end = start;
	    size++;
	}
	else {
	    LNode<T> next = new LNode<T>(thing);
	    end.setNext(next);
	    size++;
	}
	return true;
    }

    public boolean add(int index, T thing) {
	if (index < 0 || index > size) {
	    return false;
	}
	LNode<T> next = new LNode<T>(thing);
	if (size == index) {
	    return add(thing);
	}
	if (index == 0) {
	    next.setNext(start);
	    start = next;
	    return true;
	}
	LNode<T> current = start;
	for (int i = 0; i < index-1; i++) {
	    current = current.getNext();
	}
        next.setNext(current.getNext());
	current.setNext(next);
	return true;
    }

    public T get(int index) {
	LNode<T> current = start;
	for (int i = 0; i < index; i++) {
	    current = current.getNext();
	}
	return current.getData();
    }

    public T set(int index, T newThing) {
	LNode<T> current = start;
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
	if (index == 0) {
	    T ret = start.getData();
	    start = start.getNext();
	    size--;
	    return ret;
	}
	LNode<T> current = start;
	for (int i = 0; i < index; i++) {
	    current = current.getNext();
	}
	T ret = current.getData();
	current = current.getNext();
	size--;
	return ret;
    }

    /*public int indexOf(T thing) {
	LNode<T> current = start;
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
	LNode<T> current = start;
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

    private class LNode<T> {
	T data;
	LNode<T> next;

	public LNode(T data) {
	    this.data = data;
	}

	public LNode<T> getNext() {
	    return next;
	}

	public LNode<T> setNext(LNode<T> next) {
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
	MyLinkedList<Integer> L = new MyLinkedList<Integer>();
	for (int i = 0; i < 10000000; i++) {
	    L.add(new Integer(i));
	}
	
	long start,end;
	start = System.currentTimeMillis();
	for (int i = 0; i < 100000; i++) {
	    L.addOld(new Integer(i));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for addOld(): " + (end-start)/1000.0 + "seconds.");

	start = System.currentTimeMillis();
	for (int i = 0; i < 100000; i++) {
	    L.add(new Integer(i));
	}
	end = System.currentTimeMillis();
	System.out.println("Time for add(): " + (end-start)/1000.0 + "seconds.");
    }
}
