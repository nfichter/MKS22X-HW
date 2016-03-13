import java.util.*;

public class Driver2{
    public static int[] fillRandom(int[] ary){
	for (int i = 0; i < ary.length; i++){
	    ary[i] = (int)(Math.random() * 10000 / (Math.random() * 100));
	}
        return ary;
    }
    public static int[] fillRandom3(int[] ary) {
	for (int i = 0; i < ary.length; i++) {
	    ary[i] = (int)(Math.random() * 3);
	}
	return ary;
    }

    public static void main(String[]args){
        int size = 10000;
        String choice = "quick";

        if(args.length >= 1){
            choice = args[0];
        }

        if(args.length >= 2){
            size = Integer.parseInt(args[1]);
        }

	int[] ary = new int[100000];
	int[] ary1 = new int[100000];
	int[] arraysary = new int[100000];
	fillRandom3(ary);
	for (int i = 0; i < ary1.length; i++) {
		ary1[i] = ary[i];
	}
	for (int i = 0; i < arraysary.length; i++) {
		arraysary[i] = ary[i];
	}

	long startarrays = System.currentTimeMillis();
	Arrays.sort(arraysary);
	long endarrays = System.currentTimeMillis();

	System.out.println("Arrays.sort - Time:" + (endarrays-startarrays)/1000.0 + " seconds. Size = "+arraysary.length);


        long start = System.currentTimeMillis();
        if(choice.equals("quick")){
            Quick.quickSortUno(ary);
        }
        long end = System.currentTimeMillis();

        System.out.println("Sorts.quickSortUno - Time:"+ (end-start)/1000.0 + " seconds. Size = "+ary.length + " Sorted? " + Arrays.equals(arraysary,ary));


	long start1 = System.currentTimeMillis();
	if(choice.equals("quick")){
            Quick.quickSort(ary1);
        }
        long end1 = System.currentTimeMillis();

        System.out.println("Sorts.quickSort - Time:"+ (end1-start1)/1000.0 + " seconds. Size = "+ary1.length + " Sorted? " + Arrays.equals(arraysary,ary1));
    }
}
