public class MyLinkedList {
    LNode start;
    int size;

    public MyLinkedList() {
	size = 0;
    }

    public boolean add(int value) {
	if (size == 0) {
	    start = new LNode(value);
	    size++;
	}
	else {
	    LNode next = new LNode(value);
	    LNode current = start;
	    while (current.getNext() != null) {
		current = current.getNext();
	    }
	    current.setNext(next);
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
	int[] a = new int[100];
	for (int i = 0; i < 100; i++) {
	    a[i] = i;
	}
	for (int i = 0; i < 100; i++) {
	    L.add(i);
	}
	System.out.println(L.toString());
	int getTest = -1;
	for (int i = 0; i < 100; i++) {
	    if (L.get(i) != i) {
		getTest = i;
	    }
	}
        System.out.println(getTest);
	
    }
}
