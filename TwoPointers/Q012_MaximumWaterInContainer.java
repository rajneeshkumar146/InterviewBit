package TwoPointers;

import java.util.ArrayList;
import java.util.Scanner;

public class Q012_MaximumWaterInContainer {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public static int maxArea(ArrayList<Integer> A) {

		int i = 0;
		int j = A.size() - 1;
		int ans = Integer.MIN_VALUE;
		while (i <= j) {
			int min = Math.min(A.get(i), A.get(j));

			int temp = (min) * Math.abs(j - i);
			ans = Math.max(temp, ans);

			if (min == A.get(i))
				i++;
			else
				j--;

		}

		return ans;

	}
}
