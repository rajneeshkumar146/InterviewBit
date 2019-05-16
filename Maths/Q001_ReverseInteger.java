package Maths;

import java.util.Scanner;

public class Q001_ReverseInteger {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int n = -1146467285;
		long res = 0;
		while (n != 0) {
			int rem = n % 10;
			res = 10 * res + rem;
			n /= 10;
		}
		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
			System.out.println(0);
		}

		System.out.println(res);
	}

}
