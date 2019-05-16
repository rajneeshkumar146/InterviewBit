package BinarySearch;

import java.util.Scanner;

public class Q001_powerFunction {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		System.out.println(-1 % 20);

		// System.out.println(pow(5, 2, (int) 1e6));

	}

	public static int pow(int x, int n, int d) {
		if (x == 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x < 0 ? (x % d + d) % d : x;
		}

		long res = pow(x, n / 2, d);
		res = (res % d * res % d) % d;
		if ((n & 1) == 1) {
			res = (res * x) % d;
		}

		return (int) res % d;

	}

}
