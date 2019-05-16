package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Q004_MaximumAbsoluteDifference {
	final int mod = 1000000000 + 7;
	static int max = Integer.MAX_VALUE;
	static int min = Integer.MIN_VALUE;

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	private static int maxDiff(ArrayList<Integer> arr) {

		int maxplus = min, maxminus = min, minplus = max, minminus = max;

		for (int i = 1; i <= arr.size(); i++) {
			int val = arr.get(i - 1);
			maxplus = Math.max(maxplus, val + i);
			maxminus = Math.max(maxminus, val - i);
			minplus = Math.min(minplus, val + i);
			minminus = Math.min(minminus, val - i);
		}

		return Math.max(maxplus - minplus, maxminus - minminus);

	}

}
