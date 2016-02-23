import java.util.*;
import java.io.*;

public class Bronze {
	int[][] land;
	int[][] instructions;
	int E;
	int N;
	
	public Bronze(int r, int c, Scanner in) {
		land = new int[r][c];
		E = Integer.parseInt(in.next());
		N = Integer.parseInt(in.next());
		for (int row = 0; row < r; row++) {
			for (int col = 0; col < c; col++) {
				land[row][col] = Integer.parseInt(in.next());
			}
		}
		instructions = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				instructions[i][j] = Integer.parseInt(in.next())-1;
			}
			instructions[i][2] = Integer.parseInt(in.next());
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
	
	public int findMax(int r, int c) {
		int max = 0;
		for (int row = r; row < r+3; row++) {
			for (int col = c; col < c+3; col++) {
				if (land[row][col] > max) {
					max = land[row][col];
				}
			}
		}
		return max;
	}
	
	public void stompDig(int r, int c, int e) {
		int max = findMax(r,c);
		for (int row = r; row < r+3; row++) {
			for (int col = c; col < c+3; col++) {
				if (land[row][col] > max - e) {
					land[row][col] = max - e;
				}
			}
		}
	}
	
	public void doInstructions() {
		for (int j = 0; j < instructions.length; j++) {
			stompDig(instructions[j][0],instructions[j][1],instructions[j][2]);
		}
	}
	
	public int solve() {
		doInstructions();
		int totalDepth = 0;
		for (int r = 0; r < land.length; r++) {
			for (int c = 0; c < land[0].length; c++) {
				if (land[r][c] - E < 0) {
					totalDepth -= (land[r][c] - E);
				}
			}
		}
		return 72 * 72 * totalDepth;
	}

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new File("makelake.in"));
			Bronze a = new Bronze(Integer.parseInt(in.next()),Integer.parseInt(in.next()), in);
			System.out.println(a.solve()+"7,Fichter,Noah");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
