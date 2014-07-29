package yue_version;

import java.math.BigInteger;

public class FibonacciTimeComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fibo = new Fibonacci();
		fibo.prepareFibLst(10);
		BigInteger bigInt = new BigInteger("10");
		long time = System.currentTimeMillis();
		fibo.fib1(bigInt);
		System.out.println(System.currentTimeMillis() - time);
	}
}
