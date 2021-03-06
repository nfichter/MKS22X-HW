import java.util.*;
import java.io.*;

public class BetterMaze{
	private char[][] maze;
	private int[]    solution;
	private int      startRow,startCol;
	private Frontier<Node> placesToGo;
	private boolean  animate;

	public int[] solutionCoordinates(){
		return solution;
	}    

	public boolean solveBFS(){  
		placesToGo = new FrontierQueue<Node>();     
		return solve();
	}   

	public boolean solveDFS(){  
		placesToGo = new FrontierStack<Node>();
		return solve();
	}    

	private boolean canMove(int x, int y) {
		return maze[y][x] == ' ';
	}

	private boolean move(Node n) {
		int x = n.getCoord().getX();
		int y = n.getCoord().getY();
		boolean ret = false;
		if (canMove(x+1,y)) {
			placesToGo.add(new Node(new Coordinate(x+1,y),n));
			ret = true;
		}
		if (canMove(x-1,y)) {
			placesToGo.add(new Node(new Coordinate(x-1,y),n));
			ret = true;
		}
		if (canMove(x,y+1)) {
			placesToGo.add(new Node(new Coordinate(x,y+1),n));
			ret = true;
		}
		if (canMove(x,y-1)) {
			placesToGo.add(new Node(new Coordinate(x,y-1),n));
			ret = true;
		}
		maze[y][x] = '*';
		return ret;
	}

	private boolean solve(){
		int x = startCol;
		int y = startRow;
		int dir = 0;
		ArrayList<Integer> solutions = new ArrayList<Integer>();
		Node n = new Node(new Coordinate(x,y));
		move(n);
		while (maze[y][x+1] != 'E' && maze[y-1][x] != 'E' && maze[y][x-1] != 'E' && maze[y+1][x] != 'E') {
			if (animate) {
				clearTerminal();
				System.out.println(toString());
				try {
					Thread.sleep(300);
				}
				catch (Exception e) {
					System.out.println("waiting failed");
				}
			}
			if (!placesToGo.hasNext()) {
				System.out.println(x + "," + y);
				return false;
			}
			n = placesToGo.next();
			x = n.getCoord().getX();
			y = n.getCoord().getY();
			move(n);
		}
		while (n.getLast() != null) {
			x = n.getCoord().getX();
			y = n.getCoord().getY();
			solutions.add(x);
			solutions.add(y);
			n = n.getLast();
		}
		solution = new int[solutions.size()];
		Collections.reverse(solutions);
		for (int i = 0; i < solutions.size(); i+=2) {
			solution[i] = solutions.get(i+1);
			solution[i+1] = solutions.get(i);
		}
		System.out.println(x + "," + y);
		maze[y][x] = '*';
		clearTerminal();
		System.out.println(toString());
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			System.out.println("waiting failed");
		}
		return true;
	}

	public void setAnimate(boolean b){
		animate = b;
	}

	public BetterMaze(String filename){
		animate = false;
		int maxc = 0;
		int maxr = 0;
		startRow = -1;
		startCol = -1;

		String ans = "";
		try{
			Scanner in = new Scanner(new File(filename));
			while(in.hasNext()){
				String line = in.nextLine();
				if(maxr == 0){
					maxc = line.length();
				}
				maxr++;
				ans += line;
			}
		}
		catch(Exception e){
			System.out.println("File: " + filename + " could not be opened.");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println(maxr+" "+maxc);
		maze = new char[maxr][maxc];
		for(int i = 0; i < ans.length(); i++){
			char c = ans.charAt(i);
			maze[i / maxc][i % maxc] = c;
			if(c == 'S'){
				startCol = i % maxc;
				startRow = i / maxc;
			}
		}
	}

	private static final String CLEAR_SCREEN =  "\033[2J";
	private static final String HIDE_CURSOR =  "\033[?25l";
	private static final String SHOW_CURSOR =  "\033[?25h";
	private String go(int x,int y){
		return ("\033[" + x + ";" + y + "H");
	}
	private String color(int foreground,int background){
		return ("\033[0;" + foreground + ";" + background + "m");
	}

	public void clearTerminal(){
		System.out.println(CLEAR_SCREEN);
	}

	public void wait(int millis){
		try {
			Thread.sleep(millis);
		}
		catch (InterruptedException e) {
		}
	}

	public String toString(){
		int maxr = maze.length;
		int maxc = maze[0].length;
		String ans = "";
		if(animate){
			ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
		}
		for(int i = 0; i < maxc * maxr; i++){
			if(i % maxc == 0 && i != 0){
				ans += color(37,40) + "\n";
			}
			char c =  maze[i / maxc][i % maxc];
			if(c == '#'){
				ans += color(38,47)+c;
			}else{
				ans += color(33,40)+c;
			}
		}
		if(animate){
			return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
		}else{
			return ans + color(37,40) + "\n";
		}
	} 

	public static void main(String[] args) {
		BetterMaze a = new BetterMaze("data1.dat");
		a.setAnimate(true);
		System.out.println(a.solveDFS());
		for (int i = 0; i < a.solutionCoordinates().length; i+=2) {
			System.out.println(a.solutionCoordinates()[i] + ", " + a.solutionCoordinates()[i+1]);
		}
		
		try {
			Thread.sleep(5000);
		}
		catch (Exception e) {
			System.out.println("waiting failed");
		}
		
		BetterMaze a2 = new BetterMaze("data1.dat");
		a2.setAnimate(true);
		System.out.println(a2.solveBFS());
		System.out.println(a2.solutionCoordinates());
		
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			System.out.println("waiting failed");
		}
		
		BetterMaze b = new BetterMaze("data2.dat");
		b.setAnimate(true);
		System.out.println(b.solveDFS());
		System.out.println(b.solutionCoordinates());
		
		try {
			Thread.sleep(1000);
		}
		catch (Exception e) {
			System.out.println("waiting failed");
		}
		
		BetterMaze b2 = new BetterMaze("data2.dat");
		b2.setAnimate(true);
		System.out.println(b2.solveBFS());
		for (int i = 0; i < b2.solutionCoordinates().length; i+=2) {
			System.out.println(b2.solutionCoordinates()[i] + ", " + b2.solutionCoordinates()[i+1]);
		}
	}
}
