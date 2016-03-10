import java.util.*;

public class Quick {
	private static void swap(int[] data, int firstIndex, int secondIndex) {
		int hold = data[firstIndex];
		data[firstIndex] = data[secondIndex];
		data[secondIndex] = hold;
	}
	
	private static int partition(int[] data, int left, int right) {
	    int index = (int)(Math.random()*(right-left+1)) + left;
		int num = data[index];
		
		swap(data,index,right);
		
		int cLeft = left;
		int cRight = right-1;
		
		while(cLeft < cRight) {
			if (data[cRight] > num) {
			    swap(data,cLeft,cRight);
			    cRight--;
			}
			else {
				cLeft++;
			}
		}
		
		if (cRight < num) {
			cRight++;
		}
		swap(data,right,cRight);
		index = cRight;
		
		return index;
	}
	
	private static int quickselect(int[] data, int k, int left, int right) {
		int index = partition(data,left,right);
		
		if (index == k) {
			return data[k];
		}
		
		if (index >= k) {
			return quickselect(data,k,left,index);
		}
		
		else {
			return quickselect(data,k,index,right);
		}
	}
	
	public static int quickselect(int[] data, int k) {
		return quickselect(data,k,0,data.length-1);
	}
	
	public static void quickSort(int[] data, int left, int right) {
	    System.out.println(left + " " + right);
		if (left < right) {
			int index = partition(data,left,right);
			quickSort(data,left,index);
			quickSort(data,index,right);
		}
	}
	
	public static void quickSort(int[] data) {
		quickSort(data,0,data.length-1);
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
	        quickSort(data);
		printArray(data);
	}
}
