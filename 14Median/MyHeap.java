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
		heapify();
	}
	public MyHeap(T[] data, boolean isMax) {
	    this(data);
	    this.isMax = isMax;
	}

	private void doubleSize() {
		T[] newData = (T[])(new Comparable[data.length*2]);
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	public boolean inBounds(int index) {
		return (index <= size && index > 0);
	}
	
	private void pushDown(int k) {
		if (isMax) {
			while ((inBounds(k*2) && data[k*2].compareTo(data[k]) > 0) ||
			(inBounds(k*2+1) && data[k*2+1].compareTo(data[k]) > 0)) {
				if (data[k*2].compareTo(data[k*2+1]) < 0) {
					T hold = data[k];
					data[k] = data[k*2+1];
					data[k*2+1] = hold;
					k = k*2+1;
				}
				else {
					T hold = data[k];
					data[k] = data[k*2];
					data[k*2] = hold;
					k = k*2;
				}
			}
		} else {;
		    System.out.println("k:" + k + " k*2:" + k*2 + " k*2+1:" + (k*2+1));
		    System.out.println(toString());
		    System.out.println(data[1]);
		    System.out.println(data[2]);
		    System.out.println(size);
		    while ((inBounds(k*2) && data[k*2].compareTo(data[k]) < 0) ||
			   (inBounds(k*2+1) && data[k*2+1].compareTo(data[k]) < 0)) {
				if (data[k*2].compareTo(data[k*2+1]) < 0) {
					T hold = data[k];
					data[k] = data[k*2+1];
					data[k*2+1] = hold;
					k = k*2+1;
				}
				else {
					T hold = data[k];
					data[k] = data[k*2];
					data[k*2] = hold;
					k = k*2;
				}
				
			}
		}
	}

	private void pushUp(int k) {
		if (isMax) {
			while (inBounds(k/2) && data[k/2].compareTo(data[k]) < 0) {
				T hold = data[k];
				data[k] = data[k/2];
				data[k/2] = hold;
				k /= 2;
			}
		} else {
			while (inBounds(k/2) && data[k/2].compareTo(data[k]) > 0) {
				T hold = data[k];
				data[k] = data[k/2];
				data[k/2] = hold;
				k /= 2;
			}
		}
	}
	
	private void heapify() {
		for (int i = size/2; i > 0; i--) {
			pushDown(i);
			System.out.println(this);
		}
	}
	
	public T delete() {
		T ret = data[1];
		if (size == 1) {
		    data[1] = null;
		    return ret;
		}
		data[1] = data[size];
		data[size] = null;
		size--;
		pushDown(1);
		return ret;
	}

	public void add(T x) {
		if (size == data.length) {
			doubleSize();
		}
		data[size+1] = x;
 		size++;
		pushUp(size);
	}

	public T peek() {
	    if (size == 0) {
		throw new NoSuchElementException();
	    }
	    return data[1];
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
	
	public int size() {
		return size;
	}

	public static void main(String[] args) {
	    MyHeap a = new MyHeap<Integer>();
	    //System.out.println(a);
	    a.add(2);
	    a.add(5);
	    a.add(-1);
	    a.add(7);
	    a.add(9);
	    //System.out.println(a);
	    a.delete();
	    Integer[] bA = {-1, -2, 4, 11, 7, 0, 3};
	    System.out.println("Start: "+Arrays.toString(bA));
	    MyHeap b = new MyHeap<Integer>(bA);
	    System.out.println("End: "+b);
	}
}
