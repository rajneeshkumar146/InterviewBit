package Maths;

import java.util.Scanner;

public class Q002_PalindromicInteger {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int n = scn.nextInt();
		if (n < 0) {
			System.out.println(false);
			return;
		}

		long res = 0;
		int temp = n;
		while (n != 0) {
			int rem = n % 10;
			res = 10 * res + rem;
			n /= 10;
		}

		if (res == temp) {
			System.out.println(true);
			return;
		} else {
			System.out.println(true);
			return;
		}

	}

}
