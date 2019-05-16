package TwoPointers;

import java.util.ArrayList;
import java.util.Scanner;

public class Q007_SortColor {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(0);
		a.add(0);
		a.add(2);
		a.add(1);
		a.add(2);
		a.add(0);
		a.add(1);

		SortColor(a);
	}

	private static void SortColor(ArrayList<Integer> a) {
		int one = -1;
		int last = a.size();
		int itr = 0;

		while (itr < last) {

			if (a.get(itr).equals(0)) {
				one++;
				swap(a, one, itr);
				itr++;
			} else if (a.get(itr).equals(1)) {
				itr++;
			} else {
				last--;
				swap(a, itr, last);
			}
		}

		System.out.println(a);

	}

	private static void swap(ArrayList<Integer> a, int i, int j) {
		int el1 = a.get(i);
		int el2 = a.get(j);

		a.set(i, el2);
		a.set(j, el1);

	}

}
