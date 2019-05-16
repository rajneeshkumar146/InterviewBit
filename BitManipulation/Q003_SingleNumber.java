package BitManipulation;

import java.util.List;
import java.util.Scanner;

public class Q003_SingleNumber {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public int singleNumber(final List<Integer> n) {

		int res = 0;
		for (Integer i : n) {
			res ^= i;
		}

		return res;

	}

}
