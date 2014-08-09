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

	public ArrayList<BigInteger> fibLst;

	/**
	 * The simplest way to solve fibonacci. Time complexity is exponential
	 * 
	 * @param nth
	 * @return the nth fibon number
	 */
	public BigInteger fib1(BigInteger nth) {
		if (nth.compareTo(new BigInteger("0")) == 0) {
			return new BigInteger("0");
		} else if (nth.compareTo(new BigInteger("1")) == 0) {
			return new BigInteger("1");
		} else {
			BigInteger a1 = nth.subtract(new BigInteger("1"));
			BigInteger a2 = nth.subtract(new BigInteger("2"));
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
		prepareFibLst(nth.intValue() + 1);
		if (nth.compareTo(new BigInteger("0")) == 0) {
			return new BigInteger("0");
		} else {
			this.fibLst.set(0, new BigInteger("0"));
			this.fibLst.set(1, new BigInteger("1"));
			for (int i = 2; i < this.fibLst.size(); i++) {
				fibLst.set(i, fibLst.get(i - 1).add(fibLst.get(i - 2)));
			}
		}
		return fibLst.get(nth.intValue());
	}

	public void prepareFibLst(int count) {
		this.fibLst = new ArrayList<BigInteger>();
		while (count-- > 0) {
			fibLst.add(new BigInteger("0"));
		}
		generateFibLst();
	}

	private void generateFibLst() {
		for (int i = 0; i < fibLst.size(); i++) {
			fibLst.set(i, fib4(new BigInteger(Integer.toString(i))));
		}
	}

	/**
	 * A fast solution.
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
	 * a faster solution
	 * 
	 * @param nth
	 * @return
	 */
	public BigInteger fib3(BigInteger nth) {
		if (nth.compareTo(new BigInteger("0")) == 0)
			return new BigInteger("0");
		else if (nth.compareTo(new BigInteger("1")) == 0)
			return new BigInteger("1");
		else {
			BigInteger[][] first = new BigInteger[][] {
					{ new BigInteger("0"), new BigInteger("1") },
					{ new BigInteger("1"), new BigInteger("1") } };
			BigInteger[][] second = new BigInteger[][] {
					{ new BigInteger("0"), new BigInteger("1") },
					{ new BigInteger("1"), new BigInteger("0") } };
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
		if (nth.compareTo(new BigInteger("1")) < 0)
			return nth;
		BigInteger[][] theMatrix = new BigInteger[][] {
				{ new BigInteger("0"), new BigInteger("1") },
				{ new BigInteger("1"), new BigInteger("1") } };
		BigInteger[][] result = { { new BigInteger("1"), new BigInteger("0") },
				{ new BigInteger("0"), new BigInteger("1") } };
		while (nth.compareTo(new BigInteger("0")) > 0) {
			BigInteger remainder = nth.remainder(new BigInteger("2"));
			if (remainder.intValue() != 0) {
				result = multi2by2(result, theMatrix);
			}
			nth = nth.divide(new BigInteger("2"));
			theMatrix = multi2by2(theMatrix, theMatrix);
		}
		return result[1][0];
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println("fib1 tests:");
		System.out.print("[ ");
		for (int i = 0; i < 21; i++) {
			System.out.print(f.fib1(new BigInteger(Integer.toString(i))));
			if (i + 1 != 21)
				System.out.print(", ");
		}
		System.out.println("]");
		System.out.println("fib2 tests:");
		System.out.print("[ ");
		for (int i = 0; i < 10; i++) {
			System.out.print(f.fib2(new BigInteger(Integer.toString(i))));
			if (i + 1 != 10)
				System.out.print(", ");
		}
		System.out.println("]");
		System.out.println("fib3 tests:");
		System.out.print("[ ");
		for (int i = 0; i <= 64; i++) {
			System.out.print(f.fib3(new BigInteger(Integer.toString(i))));
			if (i + 1 != 65)
				System.out.print(", ");
		}
		System.out.println("]");
		System.out.println("fib4 tests:");
		for (int i = 0; i <= 64; i++) {
			System.out.println("case " + i + ": "
					+ f.fib4(new BigInteger(Integer.toString(i))));
		}

		Fibonacci fffi = new Fibonacci();
		System.out.println(fffi.fib4(new BigInteger("100000")));
	}
}
