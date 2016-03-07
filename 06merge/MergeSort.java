public class MergeSort {
	public static int[] merge(int[] a, int[] b) {
		int[] ret = new int[a.length+b.length];
		int aCount = 0;
		int bCount = 0;
		int rCount = 0;
		while (aCount < a.length && bCount < a.length) {
			if (a[aCount] > b[bCount]) {
				ret[rCount] = a[aCount];
				aCount++;
				rCount++;
			}
			else {
				ret[rCount] = b[bCount];
				bCount++;
				rCount++;
			}
		}
		
		if (aCount == a.length) {
			for (int i = bCount; i < b.length; i++) {
				ret[rCount] = b[i];
				rCount++;
			}
		}
		else {
			for (int i = aCount; i < a.length; i++) {
				ret[rCount] = a[i];
				rCount++;
			}
		}
		
		return ret;
	}
	
	public static int[] mergeSort(int[] data) {
		if (data.length <= 1) {
			return data;
		}
		
		int[] one = new int[data.length/2];
		int[] two = new int[data.length-one.length];
		
		int count = 0;
		
		for (int i = 0; i < one.length; i++) {
			one[i] = data[count];
			count++;
		}
		
		for (int j = count; j < data.length; j++) {
			two[j-count] = data[j];
			count++;
		}
		
		mergeSort(one);
		mergeSort(two);
		
		data = merge(one,two);
		return data;
	}
	
	public static void printArray(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] test = {4, 3, 0, 4, 9, 2, 11};
		MergeSort.printArray(MergeSort.mergeSort(test));
	}
}