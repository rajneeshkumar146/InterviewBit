package Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class Q002_ColorFullNumbers {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		System.out.println(colorfull(23));

	}

	private static int colorfull(int n) {
		HashSet<Integer> record = new HashSet<>();
		String str = n +"";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String s = str.substring(i, j);
				int mul = 1;
				for (int k = 0; k < s.length(); k++) {
					mul *= s.charAt(k) - '0';
				}
				
				if (record.contains(mul)) {
					return 0;
				}
				record.add(mul);
			}
		}

		return 1;

	}

}
