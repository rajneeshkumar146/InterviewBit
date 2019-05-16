package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q006_Largest_Continuous_Sequence_Zero_Sum {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	private static ArrayList<Integer> largest(ArrayList<Integer> list) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int len = 0;
		int sidx = 0, eidx = -1;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);

			if (sum == 0) {
				if (i + 1 > len) {
					len = i + 1;
					sidx = 0;
					eidx = i;
				}
			} else if (map.containsKey(sum)) {
				if (i - map.get(sum) > len) {
					len = i - map.get(sum);
					sidx = map.get(sum) + 1;
					eidx = i;
				}
			} else {
				map.put(sum, i);
			}

		}

		for (int i = sidx; i <= eidx; i++) {
			ans.add(list.get(i));
		}

		return ans;
	}

}
