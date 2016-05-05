public class MyHeap<T extends comparable<T>> {
    private boolean isMax;
    private T[] data;
    private int size;

    public MyHeap() {
        isMax = true;
	data = new T[0];
	size = 0;
    }
    public MyHeap(boolean isMax) {
	this.isMax = isMax;
	data = new T[0];
	size = 0;
    }
    public MyHeap(T[] data) {
	isMax = true;
	this.data = new T[data.length];]
	for (int i = 0; i < data.length; i++) {
	    this.data[i+1] = data[i];
	}
        size = data.length;
    }

    private void doubleSize() {
	newData T[] = new T[data.length*2+1];
	for (int i = 0; i < data.length; i++) {
	    newData[i] = data[i];
	}
	data = newData;
    }

    private void pushDown(int k) {
	int down = data[k];
	int downPos = k;
	if (isMax) {
	    if (data[k*2].compareTo(data[k*2+1]) > 0) {
		int up = data[k*2];
		int upPos = k*2;
	    } else {
		int up = data[k*2+1];
		int upPos = k*2+1;
	    }
	} else {
	    if (data[k*2].compareTo(data[k*2+1]) < 0) {
		int up = data[k*2];
		int upPos = k*2;
	    } else {
		int up = data[k*2+1];
		int upPos = data[k*2+1];
	    }
	}

	data[downPos] = up;
	data[upPos] = down;
    }

    private void pushUp(int k) {
	int up = data[k];
	int upPos = k;
        int down = data[k/2];
	int downPos = k/2;
	
	data[upPos] = down;
	data[downPos] = up;
    }

    public void add(T x) {
	if (size == data.length) {
	    doubleSize();
	}
	int pos = size+1;
	while (pos != 1 && x < data[pos/2]) {
	    pushUp(pos);
	    pos = pos/2;
	}
    }

    public String toString() {
	String ret = "[";
	for (int i = 0; i < size-1; i++) {
	    ret += data[i] + ", ";
	}
	if (data.length > 0) {
	    ret += data[size-1];
	}
	ret += "]";
	return ret;
    }
}
