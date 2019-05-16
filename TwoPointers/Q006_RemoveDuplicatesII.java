package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q006_RemoveDuplicatesII {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		RemoveDupliII(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3)));
	}

	private static int RemoveDupliII(ArrayList<Integer> a) {
		int equals = 5; // just change it for pattern of equals.
		int idx = equals - 1;
		int i = idx + 1;
		for (; i < a.size(); i++) {
			if (!a.get(i).equals(a.get(idx - (equals - 1)))) {
				idx++;
				a.set(idx, a.get(i));

			}
		}

		System.out.println(a);

		return idx + 1;
	}

}
