public class QueenBoard{
    private int[][]board;
    private String[][]bNew;
    private int[]queens;
    
    public QueenBoard(int size) {
	board = new int[size][size];
	bNew = new String[size][size];
	queens = new int[size];
    }

    public boolean solve() {
	return solveH(0);
    }

    public boolean solveH(int c) {
	if (c >= board.length) {
	    return true;
	}
	for (int r = 0; r < board.length; r++) {
	    if (board[r][c] == 0) {
		addQueen(r,c);
		if (solveH(c+1)) {
		    return true;
		}
		else {
		    removeQueen(queens[c],c);
		}
	    }
	}
	return false;
    }

    public void printSolution(){
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board.length; c++) {
		if (board[r][c] != 1) {
		    bNew[r][c] = "_";
		}
		else {
		    bNew[r][c] = "Q";
		}
	    }
	}
	System.out.println(toString());
    }

    public boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	queens[col] = row;
	return true;
    }

    public boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }

    public String toString(){
	String ans = "";
	for(int r = 0; r < bNew.length; r++){
	    for(int c = 0; c < bNew[0].length; c++){
		ans+= bNew[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }

    public static void main(String[]args){
	QueenBoard b = new QueenBoard(7);
	b.solve();
        b.printSolution();
    }   
}
