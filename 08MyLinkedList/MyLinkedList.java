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
	    end = next;
	    size++;
	}
	return true;
    }

    public boolean add(int index, T thing) {
	if (index < 0 || index > size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> next = new LNode<T>(thing);
	if (size == index) {
	    return add(thing);
	}
	if (index == 0) {
	    next.setNext(start);
	    start = next;
	    size++;
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
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode<T> current = start;
	for (int i = 0; i < index; i++) {
	    current = current.getNext();
	}
	return current.getData();
    }

    public T set(int index, T newThing) {
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
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
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
	}
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
	LNode<T> cur2 = start;
	for (int i = 0; i < index-1; i++) {
	    cur2 = cur2.getNext();
	}
	if (index == size-1) {
	    end = cur2.getNext();
	}
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

    public String toString(boolean debug) {
	String ret = toString();
	if (debug) {
	    ret += "\nstart: " + start.getData().toString() + " end: " + end.getData().toString() + " size: " + size;
	}
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
}
