package BitManipulation;

import java.util.Scanner;

public class Q001_NumberOfOnneBits {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		System.out.println(OneBits(scn.nextInt()));
	}

	private static int OneBits(int n) {
		int res = 0;
		while (n != 0) {
			n = n & (n - 1);
			res++;
		}

		return res;
	}

}
