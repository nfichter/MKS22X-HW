import java.util.*;

public class Driver {
	public static void main(String[] args) {
		MyDeque<Integer> d = new MyDeque<Integer>();
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();

		// Limit the number of times addFirst and addLast is done

		int limit = 10000;

		if (args.length > 0) {
			limit = Integer.parseInt(args[0]);
		}

		// Add to the head and to the tail

		for (int i = 0; i < limit/2; i++) {
			Integer r1 = (int) (Math.random() * 10000);

			// Add first
			d.addFirst(r1);
			ad.addFirst(r1);
		}
		
		for (int i = 0; i < limit/2; i++) {
			Integer r2 = (int) (Math.random() * 10000);
			// Add last
			d.addLast(r2);
			ad.addLast(r2);
		}

		// Test if adding worked by removing elements

		for (int i = 0; i < limit/2; i++) {
			System.out.println(d.getFirst() + " " + ad.getFirst());
			if (!d.getFirst().equals(ad.getFirst())) {
				System.out.println("Test #0 (addFirst) failed at: " + i + "!");
				System.exit(0);
			}

			if (!d.getLast().equals(ad.getLast())) {
				System.out.println("Test #1 (addLast) failed at: " + i + "!");
				System.exit(0);
			}

			if (!d.removeFirst().equals(ad.removeFirst())) {
				System.out.println("Test #2 (removeFirst) failed at: " + i + "!");
				System.exit(0);
			}

			if (!d.removeLast().equals(ad.removeLast())) {
				System.out.println("Test #3 (removeLast) failed at: " + i + "!");
				System.exit(0);
			}
		}

		// Sizes should be equal

		if (d.size() != ad.size()) {
			System.out.println("Not equal sizes. Error!");
			System.exit(0);
		}

		System.out.println("Success!");
	}

}