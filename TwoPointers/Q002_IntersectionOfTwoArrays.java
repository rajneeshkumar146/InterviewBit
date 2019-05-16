package TwoPointers;

import java.util.ArrayList;
import java.util.Scanner;

public class Q002_IntersectionOfTwoArrays {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	private static ArrayList<Integer> Intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < a.size() && j < b.size()) {
			int val1 = a.get(i);
			int val2 = b.get(j);
			if (val1 < val2) {
				i++;
			} else if (val2 < val1) {
				j++;
			} else {
				list.add(val1);
				i++;
				j++;
			}
		}

		return list;

	}

}
