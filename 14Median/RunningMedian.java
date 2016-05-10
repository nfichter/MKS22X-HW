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
			    System.out.println("0x: " + x + ", del: " + min.peek());
			    max.add(min.delete());
			} else {
			    System.out.println("1x: " + x + ", del: " + max.peek());
			    min.add(max.delete());
			}
		    }
		}
		size++;
	}
	
	public double getMedian() {
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
		m.add(0);
		m.add(2);
		m.add(3);
		m.add(4);
		m.add(-1);
		m.add(7);
		m.add(1);
		System.out.println(m);
		System.out.println(m.getMedian());
		m.add(5);
		System.out.println(m);
		System.out.println(m.getMedian());
	}
}
