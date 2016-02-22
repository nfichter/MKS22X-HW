import java.util.*;
import java.io.*;

public class makelake {
    int[][] board;
    int[][] instructions;
    public makelake(int r, int c, Scanner in) {
	board = new int[r][c];
	in.next();
	in.next();
	for (int row = 0; row < r; row++) {
	    for (int col = 0; col < c; col++) {
		board[row][col] = Integer.parseInt(in.next());
	    }
	}
    }

    private stomp_dig(int r, int c, int e) {
	int max = 0;
	for (int r = 0; r < r+3; r++) {
	    for (int c = 0; c < c+3; c++) {
		if (board[r][c] > max) {
		    max = board[r][c];
		}
	    }
	}
    }

    public static void main(String[] args) {
	try {
	    Scanner in = new Scanner(new File("makelake.in"));
	    makelake a = new makelake(Integer.parseInt(in.next()),Integer.parseInt(in.next()), in);
	}
	catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }
}
