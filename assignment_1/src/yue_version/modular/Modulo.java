package yue_version.modular;

/**
 * Algorithms Design and Analysis. Assignment 1 Q5b
 * 
 * @author Yue Li & Ximei Liu
 *
 */
public class Modulo {

	public static int[] modulo(int x, int y) {
		int c = gcd(x, y);
		int a = x / c;
		int b = y / c;
		return new int[] { a, b, c };
	}

	public static int gcd(int x, int y) {
		if (y == 0)
			return x;
		return gcd(y, x % y);
	}

	public static void main(String[] args) {
		int[] q1 = modulo(1346, 386);
		System.out.println("a " + q1[0] + " b " + q1[1] + " c " + q1[2]);
		int[] q2 = modulo(3669, 354);
		System.out.println("a " + q2[0] + " b " + q2[1] + " c " + q2[2]);

	}
}
