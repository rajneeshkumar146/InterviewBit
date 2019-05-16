package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q003_MaxSumContigiousSubArray {
	final int mod = 1000000000 + 7;
	final int max = Integer.MAX_VALUE;
	final int min = Integer.MIN_VALUE;

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3));
		MaxLen(arr);
	}

	private static void MaxLen(ArrayList<Integer> arr) {
		int maxlen = 0, omax = 0, cmax = 0, len = 0;

		for (int i = 0; i < arr.size(); i++) {
			if (cmax + arr.get(i) > arr.get(i)) {
				len++;
				cmax += arr.get(i);
			} else {
				len = 1;
				cmax = arr.get(i);
			}

			if (cmax > omax) {
				maxlen = len;
				omax = cmax;
			}
		}

		System.out.println(maxlen);
		System.out.println(omax);

	}

}
