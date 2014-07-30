package yue_version.modular;

/**
 * Modular class for Modular arithmetics
 * 
 * @author Yue
 *
 */
public class Modular {

	public int add(int a, int b, int modular) {
		int first = a + b;
		if (first < 0)
			first += modular;
		else
			first %= modular;
		return first;
	}

	public int minus(int a, int b, int modular) {
		return (a - b) % modular;
	}

	public static void main(String[] args) {
		Modular mod = new Modular();
		System.out.println(mod.add(2, -11, 12));
		System.out.println(mod.minus(3, 7, 17));
	}
}
