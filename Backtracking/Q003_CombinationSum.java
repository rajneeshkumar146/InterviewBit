package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Q003_CombinationSum {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
		Collections.sort(list);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		combinationSum(list, 28, Integer.MIN_VALUE, 0, new ArrayList<>(), ans);
		System.out.println(ans);

	}

	private static void combinationSum(ArrayList<Integer> list, int target, int currEle, int idx,
			ArrayList<Integer> smallAns, ArrayList<ArrayList<Integer>> ans) {
		if (target < 0 || idx >= list.size()) {
			return;
		}

		if (target == 0) {
			ArrayList<Integer> sans = new ArrayList<>();
			for (Integer i : smallAns) {
				sans.add(i);
			}
			ans.add(sans);
			return;
		}

		HashSet<Integer> isdone = new HashSet<>();
		for (int i = idx; i < list.size(); i++) {
			if (list.get(i) >= currEle && !isdone.contains(list.get(i))) {
				smallAns.add(list.get(i));
				isdone.add(list.get(i));
				combinationSum(list, target - list.get(i), list.get(i), i, smallAns, ans);
				smallAns.remove(smallAns.size() - 1);
			}
		}

	}

}
