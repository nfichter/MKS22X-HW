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
		System.out.println(index);
		swap(data,index,right);
		int curLeft = left;
		int curRight = right-1;
		int current = curLeft;
		while (curLeft != curRight) {
			System.out.println("cL: " + curLeft);
			System.out.println("cR: " + curRight);
			System.out.println("c: " + current);
			printArray(data);
			if (current == curLeft) {
				if (data[current] > num) {
					swap(data, current, curRight);
				}
				curLeft++;
				current = curRight;
			}
			else {
				if (data[current] < num) {
					swap(data, current, curLeft);
				}
				curRight--;
				current = curLeft;
			}
		}
		return index;
	}
	
	public static void printArray(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] data = {1, 4, 5, 99, 2, 40, 420, 60, 32, -1};
		System.out.println(partition(data,0,data.length-1));
		printArray(data);
	}
}