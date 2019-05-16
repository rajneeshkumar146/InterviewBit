package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Q009_PalindromicPartioning {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		palindromicPart("aab", new ArrayList<>(), ans);
		System.out.println(ans);
	}

	private static void palindromicPart(String str, ArrayList<String> res, ArrayList<ArrayList<String>> ans) {
		if (str.length() == 0) {
			if (res.size() != 0) {
				ArrayList<String> nres = new ArrayList<>();
				nres.addAll(res);
				ans.add(nres);
			}
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String s1 = str.substring(0, i + 1);
			String s2 = str.substring(i + 1);

			if (Palindrome(s1)) {
				res.add(s1);
				palindromicPart(s2, res, ans);
				res.remove(res.size() - 1);
			}

		}

	}

	private static boolean Palindrome(String str) {
		for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}

		return true;
	}

}
