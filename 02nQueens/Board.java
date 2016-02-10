public class Board {
	private int size;
	private int[][] board;
	
	public Board(int size) {
		this.size = size;
		board = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				board[row][col] = 0;
			}
		}
	}
	
	public void addQueen(int row, int col) {
		for (int c = col; c < size; c++) {
			board[row][c] -= 1;
		}
		int i = 0;
		int c = col;
		for (int r = row+1; r < size && c < size; r++) {
			c++;
			board[r][c] -= 1;
		}
		c = col;
		for (int r = row-1; r >= 0 && c < size; r--) {
			c++;
			board[r][c] -= 1;
		}
		board[row][col] = 1;
	}
	
	public void remQueen(int row, int col) {
		for (int c = col; c < size; c++) {
			board[row][c] += 1;
		}
		int i = 0;
		int c = col;
		for (int r = row+1; r < size && c < size; r++) {
			c++;
			board[r][c] += 1;
		}
		c = col;
		for (int r = row-1; r >= 0 && c < size; r--) {
			c++;
			board[r][c] += 1;
		}
		board[row][col] = 0;
	}
	
	public void printArray() {
		for (int row = 0; row < size; row++) {
			System.out.print("[ ");
			for (int col = 0; col < size; col++) {
				System.out.print(board[row][col]);
				System.out.print(", ");
			}
			System.out.println("]");
		}
	}
	
	public static void main(String[] args) {
		Board test = new Board(4);
		test.addQueen(2,0);
		test.printArray();
		System.out.println();
		test.addQueen(0,1);
		test.printArray();
		System.out.println();
		test.remQueen(2,0);
		test.printArray();
	}
}