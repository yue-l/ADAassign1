package yue_version.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Fibonacci finder to help user find out nth fibonacci number.
 * 
 * @author Yue
 * @version 26-07-14 replaced primitive type implementation for checking large
 *          faboncacci number
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
	public BigInteger fib1(BigInteger nth) {
		if (nth.compareTo(BigInteger.ZERO) == 0) {
			return BigInteger.ZERO;
		} else if (nth.compareTo(BigInteger.ONE) == 0) {
			return BigInteger.ONE;
		} else {
			BigInteger a1 = nth.subtract(BigInteger.ONE);
			BigInteger a2 = nth.subtract(BigInteger.ONE).subtract(
					BigInteger.ONE);
			return fib1(a1).add(fib1(a2));
		}
	}

	/**
	 * A better one that takes linear time complexity to solve the problem
	 * 
	 * @param nth
	 * @return nth fibon
	 */
	public BigInteger fib2(BigInteger nth) {
		// use a list instead of an array
		prepareFibResultLst(nth.intValue());
		if (nth.compareTo(BigInteger.ZERO) == 0) {
			return BigInteger.ZERO;
		} else {
			this.fibLst.set(0, BigInteger.ZERO);
			this.fibLst.set(1, BigInteger.ONE);
			for (int i = 2; i < this.fibLst.size(); i++) {
				fibLst.set(i, fibLst.get(i - 1).add(fibLst.get(i - 2)));
			}
		}
		return fibLst.get(nth.intValue());
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
			fibLstAns.add(fib2(new BigInteger(Integer.toString(i))));
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
	public BigInteger fib3(BigInteger nth) {
		if (nth.compareTo(BigInteger.ZERO) == 0)
			return BigInteger.ZERO;
		else if (nth.compareTo(BigInteger.ONE) == 0)
			return BigInteger.ONE;
		else {
			BigInteger[][] first = new BigInteger[][] {
					{ BigInteger.ZERO, BigInteger.ONE },
					{ BigInteger.ONE, BigInteger.ONE } };
			BigInteger[][] second = new BigInteger[][] {
					{ BigInteger.ZERO, BigInteger.ONE },
					{ BigInteger.ONE, BigInteger.ZERO } };
			for (int i = 1; i < nth.intValue(); i++) {
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
		if (mid % 2 == 1)
			return a * a + b * b;
		else
			return b * (2 * a - b);
	}

	/**
	 * Using the idea of reflection, to produce the reflection whenever nth
	 * number is not power of 2
	 * 
	 * @param nth
	 * @return
	 */
	public BigInteger fib4(BigInteger nth) {
		if (nth.compareTo(BigInteger.ONE) == 0)
			return nth;
		if (nth.compareTo(BigInteger.ZERO) == 0)
			return nth;
		BigInteger[][] theMatrix = new BigInteger[][] {
				{ BigInteger.ZERO, BigInteger.ONE },
				{ BigInteger.ONE, BigInteger.ONE } };
		BigInteger[][] result = { { BigInteger.ONE, BigInteger.ZERO },
				{ BigInteger.ZERO, BigInteger.ONE } };
		while (nth.compareTo(BigInteger.ZERO) > 0) {
			BigInteger remainder = nth.remainder(BigInteger.ONE
					.add(BigInteger.ONE));
			if (remainder.intValue() != 0) {
				result = multi2by2(result, theMatrix);
			}
			nth = nth.divide(BigInteger.ONE.add(BigInteger.ONE));
			theMatrix = multi2by2(theMatrix, theMatrix);
		}
		return result[1][0];
	}

	/**
	 * 
	 * @param nth
	 * @return
	 */
	public BigInteger fib5(BigInteger nth) {
		BigInteger[][] result = new BigInteger[][] {
				{ BigInteger.ONE, BigInteger.ONE },
				{ BigInteger.ONE, BigInteger.ZERO } };
		BigInteger[][] scale = new BigInteger[][] {
				{ BigInteger.ONE, BigInteger.ONE },
				{ BigInteger.ONE, BigInteger.ZERO } };
		if (nth.equals(BigInteger.ZERO))
			return BigInteger.ZERO;
		if (nth.equals(BigInteger.ONE))
			return BigInteger.ONE;
		for (int i = 2; i <= nth.intValue() - 1; i++)
			result = multi2by2(result, scale);
		return result[0][0];
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public BigInteger fib6(long n) {
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
		System.out.println(fffi.fib2(new BigInteger("50000")));
		// System.out.println(fffi.fib4(new BigInteger("15")));
		// System.out.println(fibonacciNumber(5000));
		fffi.fibFastDoubling(5000);
		// System.out.println(fffi.fib5(new BigInteger("50000")));
		fffi.fib6(50000);
	}
}
