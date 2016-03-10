import java.util.*;

public class Quick {
	private static void swap(int[] data, int firstIndex, int secondIndex) {
		int hold = data[firstIndex];
		data[firstIndex] = data[secondIndex];
		data[secondIndex] = hold;
	}
	
	private static void numSwap(int[] data, int firstIndex, int secondIndex, int num) {
		data[firstIndex] = data[secondIndex];
		data[secondIndex] = num;
	}
	
	private static int partition(int[] data, int left, int right) {
		Random rand = new Random(4);
		int index = rand.nextInt(right-left+1) + left;
		
		int num = data[index];
		
		numSwap(data,index,right,num);
		
		int cLeft = left;
		int cRight = right-1;
		
		while(cLeft < cRight) {
			if (data[cLeft] < num) {
				cLeft++;
			}
			else {
				swap(data,cLeft,cRight);
				cRight--;
			}
		}
		
		if (cRight < num) {
			cRight++;
		}
		numSwap(data,right,cRight,num);
		index = cRight;
		
		return index;
	}
	
	private static int quickselect(int[] data, int k, int left, int right) {
		int index = partition(data,left,right);
		
		if (index == k) {
			return data[k];
		}
		
		if (index > k) {
			return quickselect(data,k,left,index);
		}
		
		else {
			return quickselect(data,k,index,right);
		}
	}
	
	public static int quickselect(int[] data, int k) {
		return quickselect(data,k,0,data.length-1);
	}
	
	public static void quicksort(int[] data, int left, int right) {
		if (data.length > 1) {
			int index = partition(data,left,right);
			quicksort(data,left,index);
			quicksort(data,index,right);
		}
	}
	
	public static void quicksort(int[] data) {
		quicksort(data,0,data.length-1);
	}
	
	public static void printArray(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		System.out.println();
	}

    public static String name() {
	return "6,Fichter,Noah";
    }
	
	public static void main(String[] args) {
		int[] data = {1, 4, 5, 99, 2, 40, 420, 60, 32, -2};
		printArray(data);
		System.out.println(quickselect(data,1));
		printArray(data);
	}
}
