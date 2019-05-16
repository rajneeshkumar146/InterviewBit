package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Q001_MinStepsInInfiniteGrid {
	final int mod = 1000000000 + 7;
	final int max = Integer.MAX_VALUE;
	final int min = Integer.MIN_VALUE;

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

		int ans = 0;
		int x = A.get(0);
		int y = B.get(0);

		for (int i = 1; i < A.size(); i++) {

			ans += Math.max(Math.abs(x - A.get(i)), Math.abs(y - B.get(i)));

			x = A.get(i);
			y = B.get(i);

		}

		return ans;

	}

}
