public class Median {
	private MyHeap min, max;
	private int size;
	
	public Median() {
		min = new MyHeap<Integer>(false);
		max = new MyHeap<Integer>(true);
		size = 0;
	}
	
	public void add(int x) {
		if (size == 0) {
			min.add(x);
		}
		else {
			if (size % 2 == 0) {
				min.add(x);
			} else {
				if (min.size() > max.size()) {
					max.add(x);
				} else {
					min.add(x);
				}
			}
		}
		size++;
	}
	
	public double median() {
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
		Median m = new Median();
		m.add(0);
		m.add(3);
		m.add(3);
		m.add(4);
		m.add(-1);
		m.add(7);
		m.add(2);
		System.out.println(m);
		System.out.println(m.median());
		m.add(5);
		System.out.println(m);
		System.out.println(m.median());
	}
}