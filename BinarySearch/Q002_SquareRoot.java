package BinarySearch;

import java.util.Scanner;

public class Q002_SquareRoot {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		System.out.println(sqrt(2147483647));

	}

	public static int sqrt(int a) {
		if (a == 0 || a == 1) {
			return a;
		}

		int left = 0, right = a;
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (mid == a / mid) {
				return mid;
			} else if (mid < a / mid) {
				left = mid + 1;
				ans = mid;
			} else {
				right = mid - 1;
			}
		}

		return ans;
	}
}
