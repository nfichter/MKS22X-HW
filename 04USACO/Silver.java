import java.util.*;
import java.io.*;

public class Silver {
    private int[][] land;
    private int time;
    private int x1,y1,x2,y2;

    public Silver(String file) {
	try {
	    Scanner in = new Scanner(new File(file));
	    land = new int[Integer.parseInt(in.next())][Integer.parseInt(in.next())];
	    time = Integer.parseInt(in.next());
	    for (int r = 0; r < land.length; r++) {
		for (int c = 0; c < land[0].length; c++) {
		    if (in.next() == '.') {
			land[r][c] = 0;
		    }
		    else {
			land[r][c] = -1;
		    }
		}
	    }
	    land[Integer.parseInt(in.next())][Integer.parseInt(in.next())] = -2;
	    land[Integer.parseInt(in.next())][Integer.parseInt(in.next())] = -3;
	}
	catch(IOException e) {
	    System.out.println("File not found");
	}
    }

    public void printLand() {
	for (int r = 0; r < land.length; r++) {
	    for (int c = 0; c < land[0].length; c++) {
		System.out.print(land[r][c] + " ");
	    }
	    System.out.println();
	}
    }

    public static void main(String[] args) {
	Silver a = new Silver("ctravel.in");
    }
}
