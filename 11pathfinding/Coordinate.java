public class Coordinate {
    int x;
    int y;

    public Coordinate() {
	x = 0;
	y = 0;
    }
    public Coordinate(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public void setX(int x) {
	this.x = x;
    }
    public void setY(int y) {
	this.y = y;
    }

    public int getX() {
	return x;
    }
    public void getY() {
	return y;
    }
}
