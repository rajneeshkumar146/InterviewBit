package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Q010_generateAllParenthesis {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<String> ans = new ArrayList<>();
		Parenthesis(3, 0, 0, "", ans);
		System.out.println(ans);
	}

	private static void Parenthesis(int n, int open, int close, String res, ArrayList<String> ans) {

		if (close == n) {
			ans.add(res);
			return;
		}

		if (open < n) {
			Parenthesis(n, open + 1, close, res + "(", ans);
		}

		if (close < open) {
			Parenthesis(n, open, close + 1, res + ")", ans);
		}
	}

}
