public class KnightBoard {
    private int[][] board;
    private int size;

    public KnightBoard(int size) {
	board = new int[size+2][size+2];
	this.size = size + 4;
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
	return solveH(2,2,0);
    }

    public boolean solveH(int r, int c, int n) {
	if (move(r+1,c+2,r,c,n) && solveH(r+1,c+2,n+1)) {
	    return true;
	}
	if (move(r+1,c-2,r,c,n) && solveH(r+1,c-2,n+1)) {
	    return true;
	}
	if (move(r-1,c+2,r,c,n) && solveH(r-1,c+2,n+1)) {
	    return true;
	}
	if (move(r-1,c-2,r,c,n) && solveH(r-1,c-2,n+1)) {
	    return true;
	}
	if (move(r+2,c+1,r,c,n) && solveH(r+2,c+1,n+1)) {
	    return true;
	}
	if (move(r+2,c-1,r,c,n) && solveH(r+2,c-1,n+1)) {
	    return true;
	}
	if (move(r-2,c+1,r,c,n) && solveH(r-2,c+1,n+1)) {
	    return true;
	}
	if (move(r-2,c-1,r,c,n) && solveH(r-2,c-1,n+1)) {
	    return true;
	}
	board[r][c] = 0;
	n--;
	return false;
    }

    public void printSolution() {
	for (int r = 2; r < size - 2; r++) {
	    System.out.println();
	    for (int c = 2; c < size - 2; c++) {
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

    public boolean move(int rChange, int cChange, int r, int c, int step) {
        if (board[r+rChange][c+cChange] != 0) {
	    return false;
	}
	board[r+rChange][c+cChange] = step;
	return true;
    }

    public static void main(String[] args) {
	KnightBoard b = new KnightBoard(6);
	b.solve();
	b.printSolution();
    }
}
