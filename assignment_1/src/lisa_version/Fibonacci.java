package lisa_version;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author krc3046
 */
public class Fibonacci {

	public int[][] arrayA = { { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();

		// int n = 15;
		// System.out.println("---------Fibfun1----------");
		// for (int i = 0; i <= n; i++) {
		// System.out.print(fibonacci.Fibfun1(i) + " ");
		// }
		// System.out.println("\n---------Fibfun2----------");
		// for (int i = 0; i <= n; i++) {
		// System.out.print(fibonacci.Fibfun2(i) + " ");
		// }
		// System.out.println("\n---------Fibfun3----------");
		// for (int i = 0; i <= n; i++) {
		// System.out.print(fibonacci.Fibfun3(i) + " ");
		// }
		//
		// System.out.println("\n---------Fibfun4----------");
		// for (int i = 0; i <= n; i++) {
		// System.out.print(fibonacci.Fibfun4(i) + " ");
		// }

		System.out.println("---------Fibfun2 performance ----------");
		long startTime = System.nanoTime();// System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			fibonacci.Fibfun2(i);
		}
		long finishTime = System.nanoTime();// System.currentTimeMillis();
		System.out.println("Fibonacci method2 time performance: "
				+ (finishTime - startTime) * Math.pow(10, -9) + " Seconds");

		System.out.println("---------Fibfun3 performance ----------");
		startTime = System.nanoTime();// System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			fibonacci.Fibfun3(i);
		}
		finishTime = System.nanoTime();// System.currentTimeMillis();
		System.out.println("Fibonacci method3 time performance: "
				+ (finishTime - startTime) * Math.pow(10, -9) + " Seconds");

		System.out.println("---------Fibfun4 performance ----------");
		startTime = System.nanoTime();// System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			fibonacci.Fibfun4(i);
		}
		finishTime = System.nanoTime();// System.currentTimeMillis();
		System.out.println("Fibonacci method4 time performance: "
				+ (finishTime - startTime) * Math.pow(10, -9) + " Seconds");
	}

	public int Fibfun1(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return Fibfun1(n - 1) + Fibfun1(n - 2);

	}

	public int Fibfun2(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] fib = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];

	}

	public int Fibfun3(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[][] arrayB = { { 0, 1 }, { 1, 1 } };
		int[][] arrayC = new int[2][2];
		for (int i = 2; i <= n; i++) {
			arrayC = mult2by2(arrayA, arrayB);
			if (i < n) {
				for (int k = 0; k < arrayC.length; k++) {
					for (int j = 0; j < arrayC[k].length; j++) {
						arrayB[k][j] = arrayC[k][j];
					}
				}
			}
		}
		return arrayC[0][1];
	}

	public int Fibfun4(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[][] arrayC = new int[2][2];
		arrayC = matrixPower(arrayA, n);
		return arrayC[0][1];
	}

	public int[][] matrixPower(int[][] M, int pow) {
		if (pow == 1) {
			return M;
		}
		int[][] R = matrixPower(M, pow / 2);
		R = mult2by2(R, R);
		if (pow % 2 == 1) {
			R = mult2by2(R, arrayA);
		}
		return R;
	}

	public int[][] mult2by2(int[][] A, int[][] B) {
		int[][] C = new int[2][2];
		C[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
		C[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
		C[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
		C[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
		return C;
	}

}
