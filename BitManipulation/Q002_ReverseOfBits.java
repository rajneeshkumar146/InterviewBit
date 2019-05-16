package BitManipulation;

import java.util.Scanner;

public class Q002_ReverseOfBits {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		System.out.println(ReverseOfBitsOfLength(3));
		System.out.println(ReverseOfBits(3));
	}

	private static long ReverseOfBits(int n) {
		long rev = 0;

		for (int i = 0; i < 32; i++) {
			rev <<= 1;
			if ((n & (1 << i)) != 0)
				rev |= 1;
		}

		return rev;

	}

	private static long ReverseOfBitsOfLength(int n) {

		long res = 0;
		int count = 0;
		while (n != 0) {

			res <<= 1;
			count++;
			if ((n & 1) == 1) {
				res ^= 1;
			}
			n >>= 1;
		}

		// as per question requirment.
		res <<= (32 - count);

		return res;
	}

}
