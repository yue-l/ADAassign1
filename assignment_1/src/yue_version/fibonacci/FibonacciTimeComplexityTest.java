package yue_version.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * A general test client for examining the complexity of each function. The
 * output are used for spreadsheet data entries.
 * 
 * @author Yue
 * @version 30-07-14
 *
 */
public class FibonacciTimeComplexityTest {

	private static ArrayList<BigInteger> TEST_CASES;

	/**
	 * main test functions on time efficiency of the algorithms. From the
	 * results, func1 outgrows the others quite soon.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciTimeComplexityTest f = new FibonacciTimeComplexityTest();
		// exponential times
		f.functionOneTime(100);
		// linear
		// f.functionTwoTime(30);
		// f.functionFiveTime(10000);
		// f.functionThreeTime(10000);
		// f.functionFourTime(30);
		// logarithm
		// f.functionFourTime(10000);
	}

	/**
	 * create test cases within the limit
	 */
	public static void CASES_INIT(int limit) {
		TEST_CASES = new ArrayList<BigInteger>();
		int nth = 1;
		for (int i = 0; i < limit; i++) {
			BigInteger gi = new BigInteger(Integer.toString(i + 1));
			FibonacciTimeComplexityTest.TEST_CASES.add(gi);
		}
	}

	public void functionOneTime(int n) {
		CASES_INIT(n);
		Fibonacci fibo = new Fibonacci();
		for (int index = 0; index < TEST_CASES.size(); index++) {
			long time = System.nanoTime();
			fibo.fib1(index);
			System.out.println(System.nanoTime() - time);
		}
	}

	public void functionTwoTime(int n) {
		// CASES_INIT(n);
		Fibonacci fibo = new Fibonacci();
		fibo.fibLst = new ArrayList<>();
		for (int index = 0; index < n; index++) {
			BigInteger bi = new BigInteger(Integer.toString(index));
			long time = System.nanoTime();
			fibo.fib2(index);
			System.out.println(System.nanoTime() - time);
		}

	}

	public void functionThreeTime(int n) {
		CASES_INIT(n);
		Fibonacci fibo = new Fibonacci();
		for (int index = 0; index < TEST_CASES.size(); index++) {
			long time = System.nanoTime();
			fibo.fib3(index);
			System.out.println(System.nanoTime() - time);
		}

	}

	public void functionFourTime(int n) {
		CASES_INIT(n);
		Fibonacci fibo = new Fibonacci();
		for (int index = 0; index < TEST_CASES.size(); index++) {
			long time = System.nanoTime();
			fibo.fib4(index);
			System.out.println(System.nanoTime() - time);
		}
	}
}
