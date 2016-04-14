public class Node {
	Coordinate loc;
	Node last;

	public Node() {
		loc = new Coordinate();
		last = null;
	}
	public Node(Coordinate loc) {
		this.loc = loc;
		last = null;
	}
	public Node(Node last) {
		loc = new Coordinate();
		this.last = last;
	}
	public Node(Coordinate loc, Node last) {
		this.loc = loc;
		this.last = last;
	}

	public Node getLast() {
		return last;
	}
	public Coordinate getCoord() {
		return loc;
	}
	
	public String toString() {
		return loc.getX() + ", " + loc.getY();
	}
}
