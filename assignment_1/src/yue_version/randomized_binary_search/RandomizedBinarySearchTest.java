package yue_version.randomized_binary_search;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * RandomizedBinarySearch test client. test range is set to 100. This is an
 * accuracy test to ensure the class does what it's meant to do
 * 
 * @author Yue
 * @version 1.0
 *
 */
public class RandomizedBinarySearchTest {

	RandomizedBinarySearch rbs;

	@Before
	public void setUp() throws Exception {
		this.rbs = new RandomizedBinarySearch(100);
	}

	@After
	public void tearDown() throws Exception {
		this.rbs = null;
	}

	@Test
	public void testRandomizedSearchFailToFindOutUpperboundValue() {
		assertFalse(rbs.search(123));
		assertFalse(rbs.search(1900));
		assertFalse(rbs.search(101));
		assertFalse(rbs.search(200));
	}

	public void testRandomizedSearchFailToFindOutLowerboundValue() {
		assertFalse(rbs.search(0));
		assertFalse(rbs.search(-1));
		assertFalse(rbs.search(-100));
	}

	public void testRandomizedSearchSuccessfulFoundValues() {
		assertTrue(rbs.search(1));
		assertTrue(rbs.search(3));
		assertTrue(rbs.search(16));
		assertTrue(rbs.search(75));
		assertTrue(rbs.search(90));
		assertTrue(rbs.search(100));
		assertTrue(rbs.search(38));
		assertTrue(rbs.search(67));
		assertTrue(rbs.search(45));
		assertTrue(rbs.search(49));
		assertTrue(rbs.search(25));
	}
}
