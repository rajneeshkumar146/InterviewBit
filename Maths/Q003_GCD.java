package Maths;

import java.util.Scanner;

public class Q003_GCD {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		System.out.println(GCD(9, 12));
	}

	private static int GCD(int n, int m) {
		if (n == 0) {
			return m;
		}

		return GCD(m % n, n);

	}

}
