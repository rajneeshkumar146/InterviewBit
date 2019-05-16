package BitManipulation;

import java.util.Scanner;

public class Q006_DivideTwoNumber {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		System.out.println(divide(2147483647, 1));
	}

	private static int divide(long a, long b) {
		if (a == Integer.MIN_VALUE && b == -1) {
			return Integer.MAX_VALUE;
		}

		int sing1 = a < 0 ? -1 : 1;
		int sing2 = b < 0 ? -1 : 1;

		a = Math.abs(a);
		b = Math.abs(b);

		long add = 1;
		while (b < a) {
			add <<= 1;
			b <<= 1;
		}

		long res = 0;
		while (add != 0 && a != 0) {
			if (b <= a) {
				a = a - b;
				res += add;
			}
			add >>= 1;
			b >>= 1;
			// System.out.println(add);
			System.out.println(add + "  " + b);
		}

		return (int) (sing2 * sing1 < 0 ? -res : res);

		// From Solution
		/*
		 * We can keep subtract divisor from dividend until dividend is smaller
		 * than 0, than count the subtract numbers. But it will costs a very
		 * long time if the divisor is very small comparing to dividend. Shift
		 * can be used to solve this problem. We shift the divisor left until it
		 * just smaller than dividend but if we keep shifting one more bit, it’s
		 * larger than dividend. Than we can add the shifted value to the result
		 * and subtract the shifted value from dividend. Keep doing this until
		 * dividend is smaller than divisor. In fact, every integer can be
		 * represented by a set of base 2 so that shifting can be used.
		 * 
		 * One thing needs to be mentioned is that we need to convert the
		 * integer to long type. Otherwise the Math.abs() value of
		 * Integer.MIN_VALUE will be quite strange.
		 */

	}

}
