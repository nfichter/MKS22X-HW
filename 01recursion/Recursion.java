public class Recursion implements hw01 {
	//1.1
	public String name() {
		return "Fichter,Noah";
	}
	//1.2
	public double recSqrt(double n, double guess) {
		if (Math.abs(n - guess*guess) <= 0.00000000001) {
			return guess;
		}
		else {
			guess = ((n / guess) + guess) / 2;
			return recSqrt(n, guess);
		}
	}
	
	public double sqrt(double n) {
		double guess = 1;
		return recSqrt(n, guess);
	}
}