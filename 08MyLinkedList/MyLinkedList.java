public class MyLinkedList {
    LNode start;
    LNode end;
    int size;

    public MyLinkedList() {
	size = 0;
    }

    public boolean addOld(int value) {
	if (size == 0) {
	    start = new LNode(value);
	    end = start;
	    size++;
	}
	else {
	    LNode next = new LNode(value);
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

    public boolean add(int value) {
	if (size == 0) {
	    start = new LNode(value);
	    end = start;
	    size++;
	}
	else {
	    LNode next = new LNode(value);
	    end.setNext(next);
	    size++;
	}
	return true;
    }

    public boolean add(int index, int value) {
	if (index < 0 || index > size) {
	    return false;
	}
	LNode next = new LNode(value);
	if (size == index) {
	    return add(value);
	}
	if (index == 0) {
	    next.setNext(start);
	    start = next;
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

    public int get(int index) {
	LNode current = start;
	for (int i = 0; i < index; i++) {
	    current = current.getNext();
	}
	return current.getData();
    }

    public int set(int index, int newValue) {
	LNode current = start;
	for (int i = 0; i < index; i++) {
	    current = current.getNext();
	}
        if (index == size-1) {
	    end = current;
	}
	return current.setData(newValue);
    }

    public int size() {
	return size;
    }

    public int remove(int index) {
	if (index == 0) {
	    int ret = start.getData();
	    start = start.getNext();
	    size--;
	    return ret;
	}
	LNode current = start;
	for (int i = 0; i < index; i++) {
	    current = current.getNext();
	}
	int ret = current.getData();
	current = current.getNext();
	size--;
	return ret;
    }

    public int indexOf(int value) {
	LNode current = start;
	for (int i = 0; i < size; i++) {
	    if (current.getData() == value) {
		return i;
	    }
	    current = current.getNext();
	}
	return -1;
    }

    public String toString() {
	String ret = "[";
	LNode current = start;
	while (current != null && current.getNext() != null) {
	    ret += current.getData() + ", ";
	    current = current.getNext();
	}
	if (current != null) {
	    ret += current.getData();
	}
	ret += "]";
	return ret;
    }

    private class LNode {
	int data;
	LNode next;

	public LNode(int data) {
	    this.data = data;
	}

	public LNode getNext() {
	    return next;
	}

	public LNode setNext(LNode next) {
	    this.next = next;
	    return next;
	}

	public int getData() {
	    return data;
	}

	public int setData(int data) {
	    this.data = data;
	    return data;
	}
    }

    public static void main(String[] args) {
	MyLinkedList L = new MyLinkedList();
	for (int i = 0; i < 10000000; i++) {
	    L.add(i);
	}
	
	long start,end;
	start = System.currentTimeMillis();
	for (int i = 0; i < 100000; i++) {
	    L.addOld(i);
	}
	end = System.currentTimeMillis();
	System.out.println("Time for addOld(): " + (end-start)/1000.0 + "seconds.");

	start = System.currentTimeMillis();
	for (int i = 0; i < 100000; i++) {
	    L.add(i);
	}
	end = System.currentTimeMillis();
	System.out.println("Time for add(): " + (end-start)/1000.0 + "seconds.");
    }
}
