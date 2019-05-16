package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q002_Combination {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		Collections.sort(list);

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		combination(list, 2, Integer.MIN_VALUE, 0, new ArrayList<>(), ans);
		System.out.println(ans);

	}

	private static void combination(ArrayList<Integer> list, int k, int currEle, int idx, ArrayList<Integer> smallAns,
			ArrayList<ArrayList<Integer>> ans) {
		if (k == 0) {
			ArrayList<Integer> sans = new ArrayList<>();
			for (Integer i : smallAns) {
				sans.add(i);
			}
			ans.add(sans);
			return;
		}

		for (int i = idx; i < list.size(); i++) {
			if (list.get(i) > currEle) {
				smallAns.add(list.get(i));
				combination(list, k - 1, list.get(i), i + 1, smallAns, ans);
				smallAns.remove(smallAns.size() - 1);
			}

		}

	}

}
