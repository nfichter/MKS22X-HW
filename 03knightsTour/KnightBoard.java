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

    public boolean solveH(int r, int c, int step) {
	if (step > (size-4)*(size-4)) {
	    return true;
	}
	for (int r2 = 2; r2 < size-3; r2++) {
	    for (int c2 = 2; c2 < size-3; c2++) {
		if ((r2-r == 2 || r2-r == 3 || c2-c == 2 || c2-c == 3) && ((!(r2-r == 2 && c2-c == 2)) || (!(r2-r == 3 && c2-c == 3)))) {
		    return true; //FIX
		}
	    }
	}
	if (move(1,2,r,c,step)) {
	    step++;
	    if (solveH(r+1,c+2,step) || solveH(r+1,c+2,step) || solveH(r-1,c+2,step) || solveH(r-2,c+1,step) || solveH(r+1,c-2,step) || solveH(r+2,c-1,step) || solveH(r-1,c-2,step) || solveH(r-2,c-1,step)) {
		return true;
	    }
	    else {
		step--;
		move(-1,-2,r,c,step);
	    }
	}
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
