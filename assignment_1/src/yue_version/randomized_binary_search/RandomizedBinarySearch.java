package yue_version.randomized_binary_search;

import java.util.Random;

/**
 * Q6 a randomized binary search function.
 * 
 * @author Yue Li & Ximei Liu
 *
 */
public class RandomizedBinarySearch {
	private int[] keys;
	private Random ran;

	public RandomizedBinarySearch(int capacity) {
		initializeKeys(capacity);
		ran = new Random();
	}

	public RandomizedBinarySearch() {
		ran = new Random();
	}

	/**
	 * initiate an int array according to its size
	 * 
	 * @param capacity
	 */
	public void initializeKeys(int capacity) {
		keys = new int[capacity];
		int startVal = 1;
		for (int i = 0; i < capacity; i++)
			keys[i] = startVal++;
	}

	public boolean search(int lookup) {
		return searchRecursively(0, keys.length, lookup);

	}

	public boolean searchRecursively(int start, int end, int lookUp) {
		if (start >= this.keys.length || end <= 0)
			return false;
		int generatedEnd = this.ran.nextInt(end) - start;
		// do while loop to ensure the end part >= 0
		// as randomly generated number - start can be negative
		do {
			generatedEnd = this.ran.nextInt(end) - start;
		} while (generatedEnd < 0);

		int index = start + generatedEnd;
		if (this.keys[index] == lookUp) {
			return true;
		} else if (lookUp > this.keys[index]) {
			return searchRecursively(index + 1, end, lookUp);
		} else {
			return searchRecursively(start, index, lookUp);
		}
	}

	/**
	 * 
	 * @param arraySize
	 */
	public long analyzeTimeComplexity(int arraySize) {
		initializeKeys(arraySize);
		int randomlyTarget = this.ran.nextInt(arraySize) + 1;
		long start = System.nanoTime();
		search(randomlyTarget);
		return System.nanoTime() - start;
	}

	public static void main(String[] args) {
		RandomizedBinarySearch rbs = new RandomizedBinarySearch();
		for (int i = 1; i <= 1000; i++) {
			System.out.println(rbs.analyzeTimeComplexity(i));
		}
	}
}
