package yue_version.fibonacci;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests to automate the checks for correctness of algorithm
 * implementation.
 * 
 * @author Yue
 * @version These tests are designed for testing the correctness of the
 *          fibonacci functions. The reason behind of this is to improve the
 *          testing processes
 */
public class FibonacciCorrectnessTest {

	private Fibonacci fib;

	/**
	 * setup value controls how many test cases to be tested for each function.
	 * It initially set to 20 considering function 1 grows exponentially.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		fib = new Fibonacci();
		fib.generateFibTestCaseAnsLst(20);
	}

	@After
	public void tearDown() throws Exception {
		fib = null;
	}

	@Test
	public void testFib1WithininRangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < fib.fibLstAns.size(); i++) {
			assertTrue(
					"the actual out differs. Expected " + fib.fibLstAns.get(i)
							+ " was "
							+ fib.fib1(new BigInteger(Integer.toString(i))),
					fib.fibLstAns.get(i).equals(
							fib.fib1(new BigInteger(Integer.toString(i)))));
		}
		long result = (System.nanoTime() - time) / 1000;
		System.out.println("fib1 took " + result
				+ " mircoseconds to finish the job");
	}

	@Test
	public void testFib2WithinInRangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < fib.fibLstAns.size(); i++) {
			assertTrue(
					"the actual out differs. Expected " + fib.fibLstAns.get(i)
							+ " was "
							+ fib.fib2(new BigInteger(Integer.toString(i))),
					fib.fibLstAns.get(i).equals(
							fib.fib2(new BigInteger(Integer.toString(i)))));
		}
		long result = (System.nanoTime() - time) / 1000;
		System.out.println("fib2 took " + result
				+ " mircoseconds to finish the job");
	}

	@Test
	public void testFib3WithinRangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < fib.fibLstAns.size(); i++) {
			assertTrue(
					"the actual out differs. Expected " + fib.fibLstAns.get(i)
							+ " was "
							+ fib.fib3(new BigInteger(Integer.toString(i))),
					fib.fibLstAns.get(i).equals(
							fib.fib3(new BigInteger(Integer.toString(i)))));
		}
		long result = (System.nanoTime() - time) / 1000;
		System.out.println("fib3 took " + result
				+ " mircoseconds to finish the job");
	}

	@Test
	public void testFib4WithinRangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < fib.fibLstAns.size(); i++) {
			assertTrue(
					"the actual out differs. Expected " + fib.fibLstAns.get(i)
							+ " was "
							+ fib.fib4(new BigInteger(Integer.toString(i))),
					fib.fibLstAns.get(i).equals(
							fib.fib4(new BigInteger(Integer.toString(i)))));
		}
		long result = (System.nanoTime() - time) / 1000;
		System.out.println("fib4 took " + result
				+ " mircoseconds to finish the job");
	}
}
