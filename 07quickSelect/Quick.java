import java.util.*;

public class Quick {
    private static void swap(int[] data, int firstIndex, int secondIndex) {
	int hold = data[firstIndex];
	data[firstIndex] = data[secondIndex];
	data[secondIndex] = hold;
    }
	
    private static int partitionUno(int[] data, int left, int right) {
	int index = (int)(Math.random()*(right-left)) + left;
	int num = data[index];
		
	swap(data,index,left);
		
	int cLeft = left+1;
	int cRight = right;
		
	while(cRight > cLeft) {
	    if (data[cLeft] > num) {
		swap(data,cLeft,cRight);
		cRight--;
	    }
	    else {
		cLeft++;
	    }
	}
		
	if (data[cRight] > data[left]) {
	    swap(data,left,cRight-1);
	    index = cRight-1;
	}
	else {
	    swap(data,left,cRight);
	    index = cRight;
	}
		
	return index;
    }
	
    private static int quickselectUno(int[] data, int k, int left, int right) {
	int index = partitionUno(data,left,right);
		
	if (index == k) {
	    return data[k];
	}
		
	if (index >= k) {
	    return quickselectUno(data,k,left,index);
	}
		
	else {
	    return quickselectUno(data,k,index,right);
	}
    }
	
    public static int quickselectUno(int[] data, int k) {
	return quickselectUno(data,k,0,data.length-1);
    }
	
    public static void quickSortUno(int[] data, int left, int right) {
		System.out.println(left + " " + right);
	if (right-left >= 1) {
	    int index = partitionUno(data,left,right);
	    quickSortUno(data,left,index-1);
	    quickSortUno(data,index+1,right);
	}
    }
	
    public static void quickSortUno(int[] data) {
	quickSortUno(data,0,data.length-1);
    }

    private static int partition(int[] data, int left, int right) {
	int index = (int)(Math.random()*(right-left)) + left;
	int num = data[index];
		
	swap(data,index,left);
		
	int cLeft = left+1;
	int cRight = right;

	while(cRight > cLeft) {
	    if (data[cLeft] > num) {
		swap(data,cLeft,cRight);
		cRight--;
	    }
	    else {
		cLeft++;
	    }
	}

	int swapperR = index+1;
	int swapperL = index-1;

	for (int i = 0; i < data.length; i++) {
	    if (data[i] == num) {
		if (swapperR < data.length) {
		    swap(data,i,swapperR);
		    if (data[i] == num) {
			i--;
		    }
		    swapperR++;
		}
		else if (swapperL > 0) {
		    swap(data,i,swapperL);
		    if (data[i] == num) {
			i--;
		    }
		    swapperL--;
		}
	    }
	}
		
	if (data[cRight] > data[left]) {
	    swap(data,left,cRight-1);
	    index = cRight-1;
	}
	else {
	    swap(data,left,cRight);
	    index = cRight;
	}
		
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
	if (right-left >= 1) {
	    int index = partition(data,left,right);
	    quickSort(data,left,index-1);
	    quickSort(data,index+1,right);
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
	
    }
}
