public class KnightBoard {
    private int[][] board;
    private int size;

    public KnightBoard(int size) {
	board = new int[size+2][size+2];
	this.size = size + 4
	for (int r = 0; r < size; r++) {
	    for (int c = 0; c < size; c++) {
		if (r < 2 || r > size-3 || c < 2 || c > size-3) {
		    board[r][c] = -1;
		}
		else {
		    board[r][c] = 0;
		}
	    }
	}
    }

    public boolean solve() {
	return solveH(0,0);
    }

    public boolean solveH(int r, int c, int step) {
	return false;
    }

    public boolean move(int rChange, int cChange, int r, int c, int step) {
        if (board[r+rChange][c+cChange] == -1) {
	    return false;
	}
	board[r+rChange][c+Change] = step;
	return true;
    }
}
