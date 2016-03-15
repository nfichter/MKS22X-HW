public class MyLinkedList {
    LNode start;
    int size;

    public MyLinkedList() {
	size = 0;
    }

    public boolean add(int data) {
	if (size == 0) {
	    start = new LNode(data);
	    size++;
	}
	else {
	    LNode next = new LNode(data);
	    LNode current = start;
	    while (current.getNext() != null) {
		current = current.getNext();
	    }
	    current.setNext(next);
	    size++;
	}
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

    public int indexOf() {
	LNode current = start;
	//fix this
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
	System.out.println(L.toString());
	L.add(4);
	L.add(5);
	L.add(2);
	System.out.println(L.toString());
	System.out.println(L.get(2));
	L.set(1,7);
	System.out.println(L.toString());
	System.out.println(L.size());
    }
}
