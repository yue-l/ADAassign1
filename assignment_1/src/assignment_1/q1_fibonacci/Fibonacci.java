package assignment_1.q1_fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Fibonacci finder to help user find out nth fibonacci number.
 * 
 * @author Yue
 * @version 26-07-14 replaced primitive type implementation for checking large
 *          faboncacci number
 * @version 13-08-14 fixed running time performance for fibonacci function 4
 *
 */
public class Fibonacci {

	// a list for array implementation
	public ArrayList<BigInteger> fibLst;
	// a list for recording the correct answers
	public ArrayList<BigInteger> fibLstAns;

	/**
	 * The simplest way to solve fibonacci. Time complexity is exponential
	 * 
	 * @param nth
	 * @return the nth fibon number
	 */
	public BigInteger fib1(int nth) {
		if (nth == 0) {
			return BigInteger.ZERO;
		} else if (nth == 1) {
			return BigInteger.ONE;
		} else {
			BigInteger bigInt = new BigInteger(Integer.toString(nth));
			BigInteger a1 = bigInt.subtract(BigInteger.ONE);
			BigInteger a2 = bigInt.subtract(BigInteger.ONE).subtract(
					BigInteger.ONE);
			return fib1(a1.intValue()).add(fib1(a2.intValue()));
		}
	}

	/**
	 * A better one that takes linear time complexity to solve the problem
	 * 
	 * @param nth
	 * @return nth fibon
	 */
	public BigInteger fib2(int nth) {
		// use a list instead of an array
		prepareFibResultLst(nth);
		if (nth == 0) {
			return BigInteger.ZERO;
		} else {
			this.fibLst.set(0, BigInteger.ZERO);
			this.fibLst.set(1, BigInteger.ONE);
			for (int i = 2; i < this.fibLst.size(); i++) {
				fibLst.set(i, fibLst.get(i - 1).add(fibLst.get(i - 2)));
			}
		}
		return fibLst.get(nth);
	}

	public void prepareFibResultLst(int nth) {
		this.fibLst = new ArrayList<BigInteger>();
		for (int i = 0; i <= nth; i++) {
			fibLst.add(BigInteger.ZERO);
		}
	}

	public void generateFibTestCaseAnsLst(int count) {
		this.fibLstAns = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			fibLstAns.add(fib4(i));
		}
	}

	/**
	 * A matrices multiplication solution.
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	private BigInteger[][] multi2by2(BigInteger[][] first, BigInteger[][] second) {
		BigInteger[][] result = new BigInteger[2][2];
		result[0][0] = first[0][0].multiply(second[0][0]).add(
				first[0][1].multiply(second[1][0]));
		result[0][1] = first[0][0].multiply(second[0][1]).add(
				first[0][1].multiply(second[1][1]));
		result[1][0] = first[1][0].multiply(second[0][0]).add(
				first[1][1].multiply(second[1][0]));
		result[1][1] = first[1][0].multiply(second[0][1]).add(
				first[1][1].multiply(second[1][1]));
		return result;
	}

	/**
	 * a solution using multiplication
	 * 
	 * @param nth
	 * @return
	 */
	public BigInteger fib3(int nth) {
		if (nth == 0)
			return BigInteger.ZERO;
		else if (nth == 1)
			return BigInteger.ONE;
		else {
			BigInteger[][] first = new BigInteger[][] {
					{ BigInteger.ZERO, BigInteger.ONE },
					{ BigInteger.ONE, BigInteger.ONE } };
			BigInteger[][] second = new BigInteger[][] {
					{ BigInteger.ZERO, BigInteger.ONE },
					{ BigInteger.ONE, BigInteger.ZERO } };
			for (int i = 1; i < nth; i++) {
				second = multi2by2(second, first);
			}
			return second[0][1];
		}
	}

	/**
	 * research from Internet.
	 * 
	 * @param nth
	 * @return
	 */
	public long fibFastDoubling(int nth) {
		if (nth == 0)
			return 0;
		if (nth < 3)
			return 1;
		int mid = nth / 2;
		long a = fibFastDoubling(mid + 1);
		long b = fibFastDoubling(mid);
		if (nth % 2 == 1)
			return a * a + b * b;
		else
			return b * (2 * a - b);
	}

	/**
	 * logN performance
	 * 
	 * @param n
	 * @return
	 */
	public BigInteger fib4(int n) {
		BigInteger arr1[][] = { { BigInteger.ONE, BigInteger.ONE },
				{ BigInteger.ONE, BigInteger.ZERO } };
		if (n == 0)
			return BigInteger.ZERO;
		else {
			arr1 = power(arr1, n - 1);
			return arr1[0][0];
		}
	}

	private BigInteger[][] power(BigInteger arr1[][], long n) {
		if (n == 0 || n == 1)
			return arr1;
		BigInteger arr2[][] = { { BigInteger.ONE, BigInteger.ONE },
				{ BigInteger.ONE, BigInteger.ZERO } };
		arr1 = power(arr1, n / 2);
		arr1 = multi2by2(arr1, arr1);
		if (n % 2 != 0)
			arr1 = multi2by2(arr1, arr2);
		return arr1;
	}

	public static void main(String[] args) {
		// Fibonacci f = new Fibonacci();
		// System.out.println("fib1 tests:");
		// System.out.print("[ ");
		// for (int i = 0; i < 20; i++) {
		// System.out.print(f.fib1(new BigInteger(Integer.toString(i))));
		// if (i + 1 != 20)
		// System.out.print(", ");
		// }
		// System.out.println("]");
		// System.out.println("fib2 tests:");
		// System.out.print("[ ");
		// for (int i = 0; i < 20; i++) {
		// System.out.print(f.fib2(new BigInteger(Integer.toString(i))));
		// if (i + 1 != 20)
		// System.out.print(", ");
		// }
		// System.out.println("]");
		// System.out.println("fib3 tests:");
		// System.out.print("[ ");
		// for (int i = 0; i < 20; i++) {
		// System.out.print(f.fib3(new BigInteger(Integer.toString(i))));
		// if (i + 1 != 20)
		// System.out.print(", ");
		// }
		// System.out.println("]");
		// System.out.println("fib4 tests:");
		// System.out.print("[ ");
		// for (int i = 0; i < 20; i++) {
		// System.out.print(f.fib4(new BigInteger(Integer.toString(i))));
		// if (i + 1 != 20)
		// System.out.print(", ");
		// }
		// System.out.println("]");

		Fibonacci fffi = new Fibonacci();
		// System.out.println(fffi.fib2(new BigInteger("50000")));
		System.out.println(fffi.fib4(50));
		// System.out.println(fibonacciNumber(5000));
		// System.out.println(fffi.fibFastDoubling(50));
		// System.out.println(fffi.fib1(40));
	}
}
