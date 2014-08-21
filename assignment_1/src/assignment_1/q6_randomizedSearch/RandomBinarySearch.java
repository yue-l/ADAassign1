/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1.q6_randomizedSearch;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author krc3046
 */
public class RandomBinarySearch {

	// GraphingData plot;
	Random random = new Random();
	ArrayList arrayY = new ArrayList();
	static int loopCount = 1000;

	/*
	 * using random binary search algorithm to judge if item is included in
	 * array[n]
	 * 
	 * @param array: the input sorted array[n]
	 * 
	 * @param n: the size of the array
	 * 
	 * @param item: the item that need to judge
	 */
	public boolean randomBinarySearch(int[] a, int start, int end, int item) {
		if (start > end) {
			return false;
		}
		if (start == end) {
			if (a[start] == item) {
				return true;
			} else {
				return false;
			}

		}
		int pivot = random.nextInt(end - start + 1) + start;

		if (a[pivot] == item) {
			return true;
		} else if (a[pivot] < item) {
			randomBinarySearch(a, pivot + 1, end, item);
		} else {
			randomBinarySearch(a, start, pivot - 1, item);
		}
		return false;
	}

	public double timeComplexity(int capacity) {
		int[] data = new int[capacity];
		long startTime;
		long finishTime;
		double average = 0.0;

		int v = 1;
		for (int i = 0; i < capacity; i++) {
			data[i] = v++;
		}
		for (int j = 0; j < loopCount; j++) {
			int value = random.nextInt(capacity) + 1;
			startTime = System.nanoTime();
			randomBinarySearch(data, 0, capacity - 1, value);
			finishTime = System.nanoTime();
			arrayY.add((finishTime - startTime) * Math.pow(10, -9));
		}
		for (int j = 0; j < arrayY.size(); j++) {
			average += (double) arrayY.get(j);
		}
		return average / loopCount;

	}

	public static void main(String[] args) {
		RandomBinarySearch obj = new RandomBinarySearch();
		// GraphingData data;

		ArrayList xList = new ArrayList();
		ArrayList yList = new ArrayList();
		// *****************************
		for (int n = 0; n < loopCount; n++) {
			xList.add(n + 10);
			yList.add(obj.timeComplexity((int) xList.get(n)));

		}

		for (int i = 0; i < xList.size(); i++) {
			System.out.print(xList.get(i) + " ");
		}
		System.out.println();

		for (int i = 0; i < yList.size(); i++) {
			System.out.print(yList.get(i) + " ");
		}

	}
}
