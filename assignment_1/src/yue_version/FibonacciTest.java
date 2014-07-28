package yue_version;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

	private Fibonacci fib;
	private final long[] expected = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
			144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711,
			28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040,
			1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817,
			39088169, 63245986, 102334155, 165580141, 267914296, 433494437,
			701408733, 1134903170, 1836311903,  };

	@Before
	public void setUp() throws Exception {
		fib = new Fibonacci(47);
	}

	@After
	public void tearDown() throws Exception {
		fib = null;
	}

	@Test
	public void testFib1WithinIntRangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < expected.length; i++) {
			assertTrue("the actual out differs. Expected " + expected[i]
					+ " was " + fib.fib1(i), expected[i] == fib.fib1(i));
		}
		System.out.println(System.nanoTime() - time);
	}

	@Test
	public void testFib2WithinIntRangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < expected.length; i++) {
			assertTrue("the actual out differs. Expected " + expected[i]
					+ " was " + fib.fib1(i), expected[i] == fib.fib2(i));
		}
		System.out.println(System.nanoTime() - time);
	}

	@Test
	public void testFib3WithinRangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < expected.length; i++) {
			assertTrue("the actual out differs. Expected " + expected[i]
					+ " was " + fib.fib1(i), expected[i] == fib.fib3(i));
		}
		System.out.println(System.nanoTime() - time);
	}

	@Test
	public void testFib4WithinRangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < expected.length; i++) {
			assertTrue("the actual out differs. Expected " + expected[i]
					+ " was " + fib.fib1(i), expected[i] == fib.fib2(i));
		}
		System.out.println(System.nanoTime() - time);
	}
}
