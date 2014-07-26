package assignment_1;

public class Fibonacci {

	public Fibonacci() {
	}

	public int fib1(int nth) {
		if (nth == 0)
			return 0;
		else if (nth == 1)
			return 1;
		return fib1(nth - 1) + fib1(nth - 2);
	}

	public int fib2(int nth) {
		int size = nth + 1;
		int[] nums = new int[size];
		if (nth == 0) {
			return 0;
		} else {
			nums[0] = 0;
			nums[1] = 1;
			for (int i = 2; i < size; i++) {
				nums[i] = nums[i - 1] + nums[i - 2];
			}
		}
		return nums[nth];
	}

	private int[][] multi2by2(int[][] first, int[][] second) {
		int[][] result = new int[2][2];
		result[0][0] = first[0][0] * second[0][0] + first[0][1] * second[1][0];
		result[0][1] = first[0][0] * second[0][1] + first[0][1] * second[1][1];
		result[1][0] = first[1][0] * second[0][0] + first[1][1] * second[1][0];
		result[1][1] = first[1][0] * second[0][1] + first[1][1] * second[1][1];
		return result;
	}

	public int fib3(int nth) {
		if (nth == 0)
			return 0;
		else if (nth == 1)
			return 1;
		else {
			int[][] first = new int[][] { { 0, 1 }, { 1, 1 } };
			int[][] second = new int[][] { { 0, 1 }, { 1, 0 } };
			for (int i = 1; i < nth; i++) {
				second = multi2by2(second, first);
			}
			return second[0][1];
		}
	}

	public int fib4(int nth) {
		if (nth == 0)
			return 0;
		else if (nth == 1)
			return 1;
		int[][] result = new int[][] { { 0, 1 }, { 1, 1 } };
		int times = 1;
		int limit = (int) (Math.log(nth) / Math.log(2));
		while (times++ <= limit) {
			System.out.println("result is " + result[0][1]);
			result = multi2by2(result, result);
			for (int[] is : result) {
				System.out.print("[");
				for (int i : is) {
					System.out.print(i + " ");
				}
				System.out.println("]");
			}
		}
		return result[0][1];
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.print("[ ");
		for (int i = 0; i < 21; i++) {
			System.out.print(f.fib1(i));
			if (i + 1 != 21)
				System.out.print(", ");
		}
		System.out.println("]");
		for (int i = 0; i < 10; i++) {
			System.out.println("case " + i + ": " + f.fib2(i));
		}
		for (int i = 0; i < 47; i++) {
			System.out.println("case " + i + ": " + f.fib3(i));
		}
		for (int i = 2; i <= 50; i *= 2) {
			System.out.println("case " + i + ": " + f.fib4(i));
		}
	}
}
