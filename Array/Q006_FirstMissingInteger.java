package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q006_FirstMissingInteger {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, -1, 0, 3, 4, -5, -8, -9, 19, 20, -98, 5));
		int ans = FirstPsoitiveMissing1(list);
		System.out.println(ans);
	}

	private static int FirstPsoitiveMissing(ArrayList<Integer> arr) {
		Collections.sort(arr);
		int val = 1;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) > 0) {
				if (val == arr.get(i)) {
					val += 1;
				} else {
					break;
				}
			}
		}

		return val;
	}

	private static int FirstPsoitiveMissing1(ArrayList<Integer> arr) { // O(n)
		int idx = 0;
		int itr = 0;
		while (itr < arr.size()) {
			if (arr.get(itr) > 0) {
				swap(arr, idx, itr);

				idx++;

			}
			itr++;
		}

		// System.out.println(arr);
		// System.out.println(i); //index

		for (int i = 0; i < idx; i++) {
			if (Math.abs(arr.get(i)) <= idx) {
				int vidx = Math.abs(arr.get(i));
				arr.set(vidx - 1, -arr.get(vidx - 1));
			}
		}

		// System.out.println(arr);

		int i = 0;
		while (i < idx) {
			if (arr.get(i) > 0) {
				break;
			}

			i++;
		}

		return i + 1;

	}

	private static void swap(ArrayList<Integer> arr, int i, int j) {
		Integer val1 = arr.get(i);
		Integer val2 = arr.get(j);
		arr.set(j, val1);
		arr.set(i, val2);
	}

}
