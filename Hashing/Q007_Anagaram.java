package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q007_Anagaram {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	private static void Anagaram(ArrayList<String> list) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		for (int idx = 0; idx < list.size(); idx++) {
			String str = list.get(idx);
			int[] freMap = FreqMapOfString(str);

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 26; i++) {
				if (freMap[i] != 0) {
					sb.append((char) ('a' + i));
					sb.append(freMap[i]);
				}
			}
			str = sb.toString();
			if (!map.containsKey(str)) {
				map.put(str, new ArrayList<>());
				map.get(str).add(idx);
			} else {
				map.get(str).add(idx);
			}
		}

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (String key : map.keySet()) {
			if (map.get(key).size() > 1) {
				ans.add(map.get(key));
			}
		}

	}

	private static int[] FreqMapOfString(String str) {
		int[] map = new int[26];

		char ch = 'a';
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - ch;
			map[index]++;
		}

		return map;
	}

}
