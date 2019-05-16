package TwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q005_RemoveDuplicates {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public int removeDuplicates(ArrayList<Integer> a) {

		Collections.sort(a);
		int idx = 0;
		int i = 1;
		for (; i < a.size(); i++) {
			if (!a.get(i).equals(a.get(i - 1))) {
				a.set(idx, a.get(i - 1));
				idx++;
			}
		}

		if (idx < a.size()) {
			a.set(idx, a.get(i - 1));
			idx++;
		}
		i = a.size() - 1;
		for (; i >= idx; i--) {
			a.remove(i);
		}

		return a.size();

	}

}
