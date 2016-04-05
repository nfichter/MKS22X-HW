import java.util.*;

public class MyDeque<T> {
    private Object[] circle;
    private int size;
    private int start;
    private int end;

    public MyDeque() {
		circle = new Object[1];
		size = 0;
    }
    
    public void grow() {
	Object[] hold = new Object[circle.length*2];
	int x = 0;
	for (int i = start; i < end; i++) {
	    hold[i-start] = circle[i];
	    x = i;
	}
	start = 0;
	end = x;
	circle = hold;
    }

    public void addFirst(T value) {
	if (size == circle.length) {
	    grow();
	}
	if (start == 0) {
	    circle[circle.length-1] = value;
	    start = circle.length-1;
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
	Object ret = circle[start];
        circle[start] = null;
	size--;
	if (start == size-1) {
	    start = 0;
	}
	else {
	    start++;
	}
	return (T)ret;
    }

    public T removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	Object ret = circle[end];
	circle[end] = null;
	size--;
	if (end == 0) {
	    end = size-1;
	}
	else {
	    end--;
	}
	return (T)ret;
    }

    public T getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return (T)circle[start];
    }

    public T getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	return (T)circle[end];
    }

    public String toString() {
	String ret = "[";
	for (int i = 0; i < circle.length-2; i++) {
	    ret += circle[i] + ", ";
	}
	ret += circle[circle.length-1] + "]";
	ret += "\nSize: " + size;
	ret += ", Length: " + circle.length;
	ret += ", Pos of start: " + start;
	ret += ", Start: " + circle[start];
	ret += ", Pos of end: " + end;
	ret += ", End: " + circle[end];
	return ret;
    }

    public static void main(String[] args) {
	MyDeque<Integer> md = new MyDeque<Integer>();
	System.out.println(md.toString());
	md.addFirst(3);
	System.out.println(md.toString());
	md.addFirst(4);
	System.out.println(md.toString());
	md.addFirst(2);
	System.out.println(md.toString());
	md.addFirst(6);
	System.out.println(md.toString());
	System.out.println(md.getFirst());
	System.out.println(md.getLast());
    }
}
