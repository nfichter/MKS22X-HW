import java.util.*;

public class RunningMedian {
	private MyHeap min, max;
	private int size;
	
	public RunningMedian() {
		min = new MyHeap<Integer>(false);
		max = new MyHeap<Integer>(true);
		size = 0;
	}
	
	public void add(int x) {
		if (size == 0) {
			min.add(x);
		}
		else {
		    if (getMedian() > x) {
			max.add(x);
		    } else {
			min.add(x);
		    }
		    if (min.size() - max.size() != 0 && min.size() - max.size() != 1) {
			if (min.size() > max.size()) {
			    max.add(min.delete());
			} else {
			    min.add(max.delete());
			}
		    }
		}
		size++;
	}
	
	public double getMedian() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		if (size % 2 == 0) {
			return ((int)min.peek() + (int)max.peek())/2.0;
		} else if (min.size() > max.size()) {
			return 1.0*(int)min.peek();
		}
		return 1.0*(int)max.peek();
	}
	
	public String toString() {
		return min.toString()+" "+max.toString();
	}
	
	public static void main(String[] args) {
		RunningMedian m = new RunningMedian();
		try {
			System.out.println(m);
			System.out.println(m.getMedian());
		}
		catch (NoSuchElementException e) {
			System.out.println("NSEE works");
		}
		m.add(0);
		System.out.println(m);
		System.out.println(m.getMedian());
		m.add(2);
		System.out.println(m);
		System.out.println(m.getMedian());
		m.add(3);
		System.out.println(m);
		System.out.println(m.getMedian());
		m.add(4);
		System.out.println(m);
		System.out.println(m.getMedian());
		m.add(-1);
		System.out.println(m);
		System.out.println(m.getMedian());
		m.add(7);
		System.out.println(m);
		System.out.println(m.getMedian());
		m.add(1);
		System.out.println(m);
		System.out.println(m.getMedian());
		m.add(5);
		System.out.println(m);
		System.out.println(m.getMedian());
	}
}
