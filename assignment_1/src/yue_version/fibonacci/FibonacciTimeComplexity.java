package yue_version.fibonacci;

import java.math.BigInteger;

/**
 * A general test client for examining the complexity of each function. The
 * output are used for spreadsheet data entries.
 * 
 * @author Yue
 * @version 30-07-14
 *
 */
public class FibonacciTimeComplexity {

	private static int[] TEST_CASES;

	/**
	 * main test functions on time efficiency of the algorithms. From the
	 * results, func1 outgrows the others quite soon.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciTimeComplexity f = new FibonacciTimeComplexity();
		// exponential times
		// f.functionOneTime(20);
		// linear
		// f.functionTwoTime(30);
		// logarithm
		f.functionThreeTime(1000);
		// f.functionFourTime(50);
	}

	/**
	 * create test cases within the limit
	 */
	public static void CASES_INIT(int limit) {
		TEST_CASES = new int[limit];
		int nth = 0;
		for (int i = 0; i < limit; i++) {
			FibonacciTimeComplexity.TEST_CASES[i] = nth += 2;
		}
	}

	public void functionOneTime(int n) {
		CASES_INIT(n);
		Fibonacci fibo = new Fibonacci();
		fibo.prepareFibLst(n);
		for (int index = 0; index < TEST_CASES.length; index++) {
			long time = System.nanoTime();
			fibo.fib1(new BigInteger(Integer.toString(TEST_CASES[index])));
			System.out.println(System.nanoTime() - time);
		}

	}

	public void functionTwoTime(int n) {
		CASES_INIT(n);
		Fibonacci fibo = new Fibonacci();
		fibo.prepareFibLst(n);
		for (int index = 0; index < TEST_CASES.length; index++) {
			long time = System.nanoTime();
			fibo.fib2(new BigInteger(Integer.toString(TEST_CASES[index])));
			System.out.println(System.nanoTime() - time);
		}

	}

	public void functionThreeTime(int n) {
		CASES_INIT(n);
		Fibonacci fibo = new Fibonacci();
		fibo.prepareFibLst(n);
		for (int index = 0; index < TEST_CASES.length; index++) {
			long time = System.nanoTime();
			fibo.fib3(new BigInteger(Integer.toString(TEST_CASES[index])));
			System.out.println(System.nanoTime() - time);
		}

	}

	public void functionFourTime(int n) {
		CASES_INIT(n);
		Fibonacci fibo = new Fibonacci();
		fibo.prepareFibLst(n);
		for (int index = 0; index < TEST_CASES.length; index++) {
			long time = System.nanoTime();
			fibo.fib3(new BigInteger(Integer.toString(TEST_CASES[index])));
			System.out.println(System.nanoTime() - time);
		}

	}
}
