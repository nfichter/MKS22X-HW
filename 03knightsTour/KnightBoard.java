public class KnightBoard {
	private int[][] board;
	private int rows;
	private int cols;

	public KnightBoard(int rows, int cols) {
		board = new int[rows][cols];
		this.rows = rows;
		this.cols = cols;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				board[r][c] = 0;
			}
		}
	}

	public boolean solve() {
		return solveH(0,0,0);
	}

	public boolean solveH(int r, int c, int n) {
		board[r][c] = n;
		
		if (n >= rows * cols) {
			return true;
		}
		
		if ((move(r+1,c+2) && solveH(r+1,c+2,n+1)) || (move(r+1,c-2) && solveH(r+1,c-2,n+1)) || (move(r-1,c+2) && solveH(r-1,c+2,n+1)) || (move(r-1,c-2) && solveH(r-1,c-2,n+1)) || (move(r+2,c+1) && solveH(r+2,c+1,n+1)) || (move(r+2,c-1) && solveH(r+2,c-1,n+1)) || (move(r-2,c+1) && solveH(r-2,c+1,n+1)) || (move(r-2,c-1) && solveH(r-2,c-1,n+1))) {
			n++;
			return true;
		}
		board[r][c] = 0;
		n--;
		return false;
	}

	public void printSolution() {
		for (int r = 0; r < rows; r++) {
			System.out.println();
			for (int c = 0; c < cols; c++) {
				if ((board[r][c]+"").length() == 2) {
					System.out.print(board[r][c] + " ");
				}
				else {
					System.out.print(board[r][c] + "  ");
				}
			}
		}
		System.out.println();
	}

	public boolean move(int r, int c) {
		if (r > board.length-1 || r < 0 || c > board[0].length-1 || c < 0) {
			return false;
		}
		if (board[r][c] != 0) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		KnightBoard b = new KnightBoard(6,5);
		b.solve();
		b.printSolution();
	}
}
