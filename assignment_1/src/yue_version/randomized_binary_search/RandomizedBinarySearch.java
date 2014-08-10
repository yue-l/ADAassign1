package yue_version.randomized_binary_search;

import java.util.Random;

public class RandomizedBinarySearch {
	private int[] keys;
	private Random ran;

	public RandomizedBinarySearch(int capacity) {
		initializeKeys(capacity);
		ran = new Random();
	}

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

	public static void main(String[] args) {
		RandomizedBinarySearch rbs = new RandomizedBinarySearch(100);
		System.out.println(rbs.search(110));
	}
}
