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
 * @version This tests are designed for getting run time complexity of different
 *          algorithms
 */
public class FibonacciCorrectnessTest {

	private Fibonacci fib;

	@Before
	public void setUp() throws Exception {
		fib = new Fibonacci();
		fib.prepareFibLst(35);
	}

	@After
	public void tearDown() throws Exception {
		fib = null;
	}

	@Test
	public void testFib1WithinIntRangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < fib.fibLst.size(); i++) {
			assertTrue(
					"the actual out differs. Expected " + fib.fibLst.get(i)
							+ " was "
							+ fib.fib1(new BigInteger(Integer.toString(i))),
					fib.fibLst.get(i).equals(
							(fib.fib1(new BigInteger(Integer.toString(i))))));
		}
		long result = (System.nanoTime() - time) / 1000;
		System.out.println("fib1 took " + result
				+ " mircoseconds to finish the job");
	}

	@Test
	public void testFib2WithinInt47RangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < fib.fibLst.size(); i++) {
			assertTrue(
					"the actual out differs. Expected " + fib.fibLst.get(i)
							+ " was "
							+ fib.fib2(new BigInteger(Integer.toString(i))),
					fib.fibLst.get(i).equals(
							fib.fib2(new BigInteger(Integer.toString(i)))));
		}
		long result = (System.nanoTime() - time) / 1000;
		System.out.println("fib2 took " + result
				+ " mircoseconds to finish the job");
	}

	@Test
	public void testFib3Within47RangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < fib.fibLst.size(); i++) {
			assertTrue(
					"the actual out differs. Expected " + fib.fibLst.get(i)
							+ " was "
							+ fib.fib3(new BigInteger(Integer.toString(i))),
					fib.fibLst.get(i).equals(
							fib.fib3(new BigInteger(Integer.toString(i)))));
		}
		long result = (System.nanoTime() - time) / 1000;
		System.out.println("fib3 took " + result
				+ " mircoseconds to finish the job");
	}

	@Test
	public void testFib4Within47RangePass() {
		long time = System.nanoTime();
		for (int i = 0; i < fib.fibLst.size(); i++) {
			assertTrue(
					"the actual out differs. Expected " + fib.fibLst.get(i)
							+ " was "
							+ fib.fib4(new BigInteger(Integer.toString(i))),
					fib.fibLst.get(i).equals(
							fib.fib4(new BigInteger(Integer.toString(i)))));
		}
		long result = (System.nanoTime() - time) / 1000;
		System.out.println("fib4 took " + result
				+ " mircoseconds to finish the job");
	}
}
