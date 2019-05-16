package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q001_MergeTwoSortedArrays {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		Merge(new ArrayList<>(Arrays.asList(-4, -3)), new ArrayList<>(Arrays.asList(-2, -2)));
	}

	private static void Merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i != list1.size() && j != list2.size()) {
			if (list1.get(i) < list2.get(j)) {
				list.add(list1.get(i));
				i++;
			} else {
				list.add(list2.get(j));
				j++;
			}
		}

		while (i != list1.size()) {
			list.add(list1.get(i));
			i++;
		}

		while (j != list2.size()) {
			list.add(list2.get(j));
			j++;
		}

		i = 0;
		for (; i < list1.size(); i++) {
			list1.set(i, list.get(i));
		}

		for (; i < list.size(); i++) {
			list1.add(list.get(i));
		}

		list1 = list;

	}

}
