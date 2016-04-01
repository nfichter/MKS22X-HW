public class MyDeque<T> {
    private T[] circle;
    private int size;
    private int start;
    private int end;

    public MyDeque() {
	circle = new T[1];
	size = 0;
    }
    
    public void grow() {
	T[] hold = new T[circle.length*2];
	for (int i = start; i < end; i++) {
	    hold[i-start] = T[i];
	}
    }

    public void addFirst(T value) {
	if (size == circle.length) {
	    grow();
	}
	if (start == 0) {
	    circle[size-1] = value;
	    start = size-1;
	}
	else {
	    circle[start-1] = value;
	    start--;
	}
	size ++;
	if (size == 1) {
	    end = start;
	}
    }

    public void addLast(T value) {
	if (size == circle.length) {
	    grow();
	}
	if (start == size-1) {
	    circle[0] = value;
	    end = 0;
	}
	else {
	    circle[end+1] = value;
	    end++;
	}
	size++;
	if (size == 1) {
	    start = end;
	}
    }

    public T removeFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
        circle[start] = null;
	size--;
	if (start == size-1) {
	    start = 0;
	}
	else {
	    start++;
	}
    }

    public T removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	circle[end] = null;
	size--;
	if (end == 0) {
	    end = size-1;
	}
	else {
	    end--;
	}
    }

    public T getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return circle[start];
    }

    public T getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return circle[end];
    }

    public String toString() {
	String ret = "[";
	for (int i = 0; i < circle.size-2; i++) {
	    ret += circle[i] + ", "
	}
	ret += circle[circle.size-1] + "]";
	ret += "\nSize: " + size + ", Pos of start: " + start + ", Start: " + circle[start] + ", Pos of end: " + end + ", End: " + circle[end];
	return ret;
    }

    public static void main(String[] args) {
	MyDeque<Integer> md = new MyDeque<Integer>();
    }
}
