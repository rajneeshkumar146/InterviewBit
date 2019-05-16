package TwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q008_ThreeSumClosest {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	private static int ClosestSum(ArrayList<Integer> arr, int target) {
		Collections.sort(arr);
		int n = arr.size();

		int res = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n - 2; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = arr.get(i) + arr.get(j) + arr.get(k);
				int diff = Math.abs(sum - target);

				if (diff == 0) {
					return sum;
				} else if (diff < min) {
					min = diff;
					res = sum;
				}

				if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}

		return res;
	}

}
