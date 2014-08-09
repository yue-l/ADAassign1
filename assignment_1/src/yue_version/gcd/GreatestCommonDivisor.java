package yue_version.gcd;

/**
 * Greatest Common Divisor
 * 
 * @author Yue
 * @version 30-07-14
 *
 */
public class GreatestCommonDivisor {

	public int gcd(int x, int y) {
		if (y == 0)
			return x;
		return gcd(y, x % y);
	}

	public static void main(String[] args) {
		GreatestCommonDivisor gcd = new GreatestCommonDivisor();
		System.out.println("GCD " + 2 + " and " + 4 + " is " + gcd.gcd(2, 4));
		System.out.println("GCD " + 15 + " and " + 7 + " is " + gcd.gcd(15, 7));
	}
}
