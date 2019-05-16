package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q003_TwoSums {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 7, 11, 2, 15, 10, 11, 1, 1, 1, 1, 2, 7, 7, 2));
		twoSums(list, 9);

	}

	private static ArrayList<Integer> twoSums(ArrayList<Integer> list, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			int val = list.get(i);
			if (map.containsKey(target - val)) {
				ans.add(map.get(target - val));
				ans.add(i + 1);
				break;
			} else if (!map.containsKey(val)) {
				map.put(val, i + 1);
			}
		}

		System.out.println(ans);
		return ans;
	}

}
