package assignment_1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

	private Fibonacci fib;
	private int[] expected = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
			233, 377, 610, 987, 1597, 2584, 4181, 6765 };

	@Before
	public void setUp() throws Exception {
		fib = new Fibonacci();
	}

	@After
	public void tearDown() throws Exception {
		fib = null;
	}

	@Test
	public void testFib1WithinIntRangePass() {
		for (int i = 0; i < expected.length; i++) {
			assertTrue("the actual out differs. Expected " + expected[i]
					+ " was " + fib.fib1(i), expected[i] == fib.fib1(i));
		}
	}

	@Test
	public void testFib2WithinIntRangePass() {
		for (int i = 0; i < expected.length; i++) {
			assertTrue("the actual out differs. Expected " + expected[i]
					+ " was " + fib.fib1(i), expected[i] == fib.fib2(i));
		}
	}

	@Test
	public void testFib3WithinRangePass() {
		for (int i = 0; i < expected.length; i++) {
			assertTrue("the actual out differs. Expected " + expected[i]
					+ " was " + fib.fib1(i), expected[i] == fib.fib3(i));
		}
	}

	@Test
	public void testFib4Pass() {
		for (int num = 2; num <= 32; num *= 2) {
			assertTrue(fib.fib4(num) == fib.fib1(num)
					&& fib.fib4(num) == fib.fib2(num)
					&& fib.fib4(num) == fib.fib3(num));
		}
	}
}
