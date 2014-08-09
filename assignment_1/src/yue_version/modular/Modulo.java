package yue_version.modular;

/**
 * Modular class for Modular arithmetics
 * 
 * @author Yue
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
		for (int i : modulo(1346, 368))
			System.out.println(i);
	}
}
