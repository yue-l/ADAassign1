package yue_version.modular;

/**
 * Algorithms Design and Analysis. Assignment 1 Q5b
 * 
 * @author Yue Li & Ximei Liu
 * @version 17-08-14 fixed logic mistakes which were caused my misunderstanding
 *
 */
public class Modulo {

	public static int[] euclid(int p, int q) {
		// found p as gcd
		if (q == 0) {
			return new int[] { 1, 0, p };
		}
		// shall keep recursing when gcd is not found
		int[] resultsFromRecursion = euclid(q, p % q);
		// reassign return values for the terms.
		int a = resultsFromRecursion[1];
		int b = resultsFromRecursion[0] - (p / q) * resultsFromRecursion[1];
		return new int[] { a, b, resultsFromRecursion[2] };
	}

	public static int gcd(int x, int y) {
		if (y == 0)
			return x;
		return gcd(y, x % y);
	}

	public static void main(String[] args) {
		int[] q1 = euclid(1346, 386);
		System.out.println(q1[0] + " " + q1[1] + " " + q1[2]);
		int[] q2 = euclid(3669, 354);
		System.out.println(q2[0] + " " + q2[1] + " " + q2[2]);
		int[] q12 = euclid(9, 6);
		System.out.println(q12[0] + " " + q12[1] + " " + q12[2]);
	}
}
