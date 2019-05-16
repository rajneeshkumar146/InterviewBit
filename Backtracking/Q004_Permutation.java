package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Q004_Permutation {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3,4));
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		permutation(list, new HashSet<>(), new ArrayList<>(), ans);
		System.out.println(ans);

	}

	private static void permutation(ArrayList<Integer> list, HashSet<Integer> isdone, ArrayList<Integer> smallAns,
			ArrayList<ArrayList<Integer>> ans) {

		if (isdone.size() == list.size()) {
			ArrayList<Integer> nans = new ArrayList<>();
			nans.addAll(smallAns);
			ans.add(nans);
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (!isdone.contains(i)) {
				smallAns.add(list.get(i));
				isdone.add(i);
				permutation(list, isdone, smallAns, ans);
				isdone.remove(i);
				smallAns.remove(smallAns.size() - 1);
			}
		}

	}

}
