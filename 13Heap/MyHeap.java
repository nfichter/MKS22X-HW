import java.util.*;
import java.util.Arrays.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>> {
    private boolean isMax;
    private T[] data;
    private int size;

    public MyHeap() {
        isMax = true;
	data = (T[])(new Comparable[10]);
	size = 0;
    }
    public MyHeap(boolean isMax) {
	this.isMax = isMax;
        data = (T[])(new Comparable[10]);
	size = 0;
    }
    public MyHeap(T[] data) {
	isMax = true;
	this.data = (T[])(new Comparable[10]);
	for (int i = 0; i < data.length; i++) {
	    this.data[i+1] = data[i];
	}
        size = data.length;
    }

    private void doubleSize() {
	T[] newData = (T[])(new Comparable[data.length*2]);
	for (int i = 0; i < data.length; i++) {
	    newData[i] = data[i];
	}
	data = newData;
    }

    private void pushDown(int k) {
	T down = data[k];
	int downPos = k;
	T up;
	int upPos;
	if (isMax) {
	    if (data[k*2].compareTo(data[k*2+1]) > 0) {
		up = data[k*2];
		upPos = k*2;
	    } else {
		up = data[k*2+1];
		upPos = k*2+1;
	    }
	} else {
	    if (data[k*2].compareTo(data[k*2+1]) < 0) {
		up = data[k*2];
		upPos = k*2;
	    } else {
		up = data[k*2+1];
		upPos = k*2+1;
	    }
	}

	data[downPos] = up;
	data[upPos] = down;
    }

    private void pushUp(int k) {
	T up = data[k];
	int upPos = k;
        T down = data[k/2];
	int downPos = k/2;
	data[upPos] = down;
	data[downPos] = up;
    }

    public void add(T x) {
	if (size == data.length) {
	    doubleSize();
	}
	if (size == 0) {
	    data[1] = x;
	}
	int pos = size+1;
	data[pos] = x;
	while (pos != 1 && x.compareTo(data[pos/2]) > 0) {
	    pushUp(pos);
	    pos = pos/2;
	}
	size++;
    }

    public String toString() {
	String ret = "[";
	for (int i = 1; i < size; i++) {
	    ret += data[i] + ", ";
	}
	if (size > 0) {
	    ret += data[size];
	}
	ret += "]";
	return ret;
    }

    public static void main(String[] args) {
	MyHeap m = new MyHeap<Integer>();
	System.out.println(m);
	m.add(2);
	System.out.println(m);
	m.add(4);
	System.out.println(m);
	m.add(3);
	System.out.println(m);
	m.add(7);
	System.out.println(m);
    }
}
