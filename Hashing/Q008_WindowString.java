package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class Q008_WindowString {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		System.out.println(minWindow("sacjhva", ""));
	}

	public static String minWindow(String A, String B) {
		int[] freMap = FreqMapOfString(B);
		HashMap<Character, Integer> map = new HashMap<>();
		int sidx = 0, eidx = 0;
		for (int i = 0; i < B.length(); i++) {
			add(map, A.charAt(i));
		}

		return "";

	}

	private static void add(HashMap<Character, Integer> map, char ch) {
		if (map.containsKey(ch)) {
			map.put(ch, map.get(ch) + 1);
		} else {
			map.put(ch, 1);
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
