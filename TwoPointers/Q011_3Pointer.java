package TwoPointers;

import java.util.List;
import java.util.Scanner;

public class Q011_3Pointer {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public static int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

		int i = 0, j = 0, k = 0;
		int ans = Integer.MIN_VALUE;
		while (i < A.size() && j < B.size() && k < C.size()) {
			int min = Math.min(Math.min(A.get(i), B.get(j)), C.get(k));
			int max = Math.max(Math.max(A.get(i), B.get(j)), C.get(k));

			ans = Math.max(Math.abs(max - min), ans);

			if (A.get(i) == min) {
				i++;
			} else if (B.get(j) == min) {
				j++;
			} else {
				k++;
			}

		}

		return ans;

	}

}
