package BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class Q004_RotatedSortedSearch {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	private static int rotatedSortedSearch(ArrayList<Integer> a, int b) {

		for (int i = 0, j = a.size() - 1; i <= j;) {
			int mid = (i + j) >> 1;

			if (a.get(mid) == b) {
				return mid;
			} else if (a.get(mid) >= a.get(i)) {
				if (b <= a.get(mid) && a.get(i) <= b) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}

			} else {
				if (a.get(mid) <= b && b <= a.get(j)) {
					i = mid + 1;
				} else {
					j = mid - 1;
				}
			}

		}

		return -1;

	}

}
