package TwoPointers;

import java.util.ArrayList;
import java.util.Scanner;

public class Q009_DiffK {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	private static boolean DiffK(ArrayList<Integer> arr, int target) {

		int i = 0;
		int j = 1;

		while (i < arr.size() && j < arr.size()) {
			int diff = arr.get(j) - arr.get(i);

			if (diff == target && i != j) {
				return true;
			} else if (diff < target) {
				j++;
			} else {
				i++;
			}
		}

		return false;

	}

}
