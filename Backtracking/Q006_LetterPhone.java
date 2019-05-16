package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Q006_LetterPhone {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		String[] codes = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ArrayList<String> ans = new ArrayList<>();
		keyPad(codes, "23", "", ans);
		System.out.println(ans);

	}

	private static void keyPad(String[] codes, String digit, String ansString, ArrayList<String> ans) {
		if (digit.length() == 0) {
			ans.add(ansString);
			return;
		}

		char ch = digit.charAt(0);
		String ros = digit.substring(1);
		String code = codes[ch - '0'];

		for (int i = 0; i < code.length(); i++) {
			keyPad(codes, ros, ansString + code.charAt(i), ans);
		}

	}

}
