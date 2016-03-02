import java.util.*;
import java.io.*;

public class Silver {
	private int[][] land;
	private int[][] moves;
	private int time;
	private int xS,yS,xE,yE;

	public Silver(Scanner in) {
		land = new int[Integer.parseInt(in.next())][Integer.parseInt(in.next())];
		moves = new int[land.length][land[0].length];
		time = Integer.parseInt(in.next());
		String lines;
		char cur;
		for (int r = 0; r < land.length; r++) {
			lines = in.next();
			for (int c = 0; c < land[0].length; c++) {
				cur = lines.charAt(c);
				land[r][c] = 0;
				if (cur == '*') {
					land[r][c] = -1;
				}
			}
		}
		yS = Integer.parseInt(in.next())-1;
		xS = Integer.parseInt(in.next())-1;
		
		yE = Integer.parseInt(in.next())-1;
		xE = Integer.parseInt(in.next())-1;
		
		movesReplacedByLand();
		land[yS][xS] = 1;
	}

	public void printLand() {
		for (int r = 0; r < land.length; r++) {
			for (int c = 0; c < land[0].length; c++) {
				System.out.print(land[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	public String answer() {
		return solve() + ",Fichter,Noah,7";
	}
	
	public int solve(){
		for (int steps = 0; steps < time; steps++) {
			resetMoves();
			for (int r = 0; r < land.length; r++) {
				for (int c = 0; c < land[0].length; c++) {
					if (land[r][c] != -1) {
						moves[r][c] = increment(r,c);
					}
				}
			}
			landReplacedByMoves();
		}
		return land[yE][xE];
	}
	
	public int increment(int row, int col) {
		int total = 0;
		if (inLand(row-1,col)) {
			total += land[row-1][col];
		}
		if (inLand(row,col-1)) {
			total += land[row][col-1];
		}
		if (inLand(row+1,col)) {
			total += land[row+1][col];
		}
		if (inLand(row,col+1)) {
			total += land[row][col+1];
		}
		return total;
	}
	
	public void resetMoves() {
		for (int r = 0; r < moves.length; r++) {
			for (int c = 0; c < moves[0].length; c++) {
				if (moves[r][c] != -1) {
					moves[r][c] = 0;
				}
			}
		}
	}
	
	public void movesReplacedByLand() {
		for (int r = 0; r < moves.length; r++) {
			for (int c = 0; c < moves[0].length; c++) {
				moves[r][c] = land[r][c];
			}
		}
	}
	
	public void landReplacedByMoves() {
		for (int r = 0; r < moves.length; r++) {
			for (int c = 0; c < moves[0].length; c++) {
				land[r][c] = moves[r][c];
			}
		}
	}
	
	public boolean inLand(int row, int col) {
		return row >= 0 && row < land.length && col >= 0 && col < land[0].length && land[row][col] != -1;
	}

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("ctravel.in"));
			Silver a = new Silver(in);
			System.out.println(a.answer());
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
	}
}
