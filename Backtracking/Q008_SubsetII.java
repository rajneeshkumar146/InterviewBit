package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Q008_SubsetII {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2));
		ans.add(new ArrayList<>());
		Collections.sort(list);

		subset(list, new ArrayList<>(), ans, new boolean[list.size()], 0, Integer.MIN_VALUE);

		System.out.println(ans);
	}

	private static void subset(ArrayList<Integer> list, ArrayList<Integer> euler, ArrayList<ArrayList<Integer>> ans,
			boolean[] isdone, int idx, int currEle) {
		if (idx == list.size()) {
			return;
		}

		HashSet<Integer> spot = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			if (!isdone[i] && !spot.contains(list.get(i)) && list.get(i) >= currEle) {
				euler.add(list.get(i));
				isdone[i] = true;
				spot.add(list.get(i));
				ArrayList<Integer> smallAns = new ArrayList<>();
				for (Integer el : euler) {
					smallAns.add(el);
				}
				ans.add(smallAns);
				subset(list, euler, ans, isdone, idx + 1, list.get(i));
				isdone[i] = false;
				euler.remove(list.get(i));
			}

		}

	}

}
