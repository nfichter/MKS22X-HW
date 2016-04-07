import java.util.*;

public class MyDeque<T> {
    private Object[] circle;
    private int size;
    private int start;
    private int end;

    public MyDeque() {
		circle = new Object[1];
		size = 0;
		start = 0;
		end = 0;
    }
	
	public int size() {
		return size;
	}
    
	public void grow() {
		Object[] hold = new Object[circle.length*2];
		int x = 0;
		if (end < start) {
			for (int i = start; i <= size; i++) {
				hold[i-start] = circle[i];
				x = i;
			}
			x--;
			for (int i = 0; i <= end; i++) {
				hold[x+i] = circle[i];
			}
			start = 0;
			if (size > 0) {
				end = size-1;
			}
			else {
				end = 0;
			}
			circle = hold;
		}
		else {
			for (int i = start; i <= end; i++) {
				hold[i-start] = circle[i];
			}
			start = 0;
			if (size > 0) {
				end = size-1;
			}
			else {
				end = 0;
			}
			circle = hold;
		}
	}

    public void addFirst(T value) {
	if (size >= circle.length-1) {
	    grow();
	}
	if (size == 0) {
		circle[0] = value;
	}
	else if (start == 0) {
	    circle[circle.length-1] = value;
	    start = circle.length-1;
	}
	else {
	    circle[start-1] = value;
	    start--;
	}
	size ++;
    }

    public void addLast(T value) {
	if (size >= circle.length-1) {
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
	if (start == circle.length-1) {
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
	if (end < start) {
		for (int i = start; i < circle.length; i++) {
			ret += circle[i] + ", ";
		}
		for (int i = 0; i < end; i++) {
			ret += circle[i] + ", ";
		}
	}
	else {
		for (int i = start; i < end; i++) {
			ret += circle[i] + ", ";
		}
	}
	if (size > 0) {
		ret += circle[end] + "]";
	}
	else {
		ret += "]";
	}
	ret += "\nSize: " + size;
	ret += ", Length: " + circle.length;
	ret += ", Pos of start: " + start;
	ret += ", Start: " + circle[start];
	ret += ", Pos of end: " + end;
	ret += ", End: " + circle[end];
	return ret;
    }

    /*public static void main(String[] args) {
	MyDeque<Integer> md = new MyDeque<Integer>();
	System.out.println(md.toString());
	md.addFirst(3);
	System.out.println(md.toString());
	md.grow();
	System.out.println(md.toString());
	md.addFirst(4);
	System.out.println(md.toString());
	md.addFirst(2);
	System.out.println(md.toString());
	md.addFirst(6);
	System.out.println(md.toString());
	md.addLast(6);
	System.out.println(md.toString());
	md.addLast(7);
	System.out.println(md.toString());
	System.out.println("removeFirst: " + md.removeFirst());
	System.out.println(md.toString());
	System.out.println("removeLast: " + md.removeLast());
	System.out.println(md.toString());
	System.out.println(md.getFirst());
	System.out.println(md.getLast());
    }*/
}
