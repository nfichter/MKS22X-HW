import java.util.*;

public class Quick {
	private static void swap(int[] data, int firstIndex, int secondIndex) {
		int hold = data[firstIndex];
		data[firstIndex] = data[secondIndex];
		data[secondIndex] = hold;
	}
	
	public static int partition(int[] data, int left, int right) {
		Random rand = new Random();
		int index = rand.nextInt(right-left) + left;
		int num = data[index];
		swap(data,index,right);
		int[] copy = new int[data.length];
		int cLeft = left;
		int cRight = right-1;
		for (int i = 0; i < data.length-1; i++) {
			if (data[i] < num) {
				copy[cLeft] = data[i];
				cLeft++;
			}
			else {
				copy[cRight] = data[i];
				cRight--;
			}
		}
		copy[copy.length-1] = num;
		swap(copy,cLeft,copy.length-1);
		for (int i = 0; i < data.length; i++) {
			data[i] = copy[i];
		}
		return index;
	}
	
	public static int quickselect(int[] data, int k, int left, int right) {
		int index = partition(data,left,right);
		
		if (index == k) {
			return data[k];
		}
		
		else if (index < k) {
			return quickselect(data,k,index,right);
		}
		
		else {
			return quickselect(data,k,left,index);
		}
	}
	
	public static int quickselect(int[] data, int k) {
		return quickselect(data, k, 0, data.length-1);
	}
	
	public static void printArray(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] data = {1, 4, 5, 99, 2, 40, 420, 60, 32, -1};
		System.out.println(quickselect(data,2));
	}
}