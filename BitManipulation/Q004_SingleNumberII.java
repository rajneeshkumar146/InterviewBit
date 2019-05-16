package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Q004_SingleNumberII {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(890, 992, 172, 479, 973, 901, 417, 215, 901, 283, 788,
				102, 726, 609, 379, 587, 630, 283, 10, 707, 203, 417, 382, 601, 713, 290, 489, 374, 203, 680, 108, 463,
				290, 290, 382, 886, 584, 406, 809, 601, 176, 11, 554, 801, 166, 303, 308, 319, 172, 619, 400, 885, 203,
				463, 303, 303, 885, 308, 460, 283, 406, 64, 584, 973, 572, 194, 383, 630, 395, 901, 992, 973, 938, 609,
				938, 382, 169, 707, 680, 965, 726, 726, 890, 383, 172, 102, 10, 308, 10, 102, 587, 809, 460, 379, 713,
				890, 463, 108, 108, 811, 176, 169, 313, 886, 400, 319, 22, 885, 572, 64, 120, 619, 313, 3, 460, 713,
				811, 965, 479, 3, 247, 886, 120, 707, 120, 176, 374, 609, 395, 811, 406, 809, 801, 554, 3, 194, 11, 587,
				169, 215, 313, 319, 554, 379, 788, 194, 630, 601, 965, 417, 788, 479, 64, 22, 22, 489, 166, 938, 66,
				801, 374, 66, 619, 489, 215, 584, 383, 66, 680, 395, 400, 166, 572, 11, 992));

		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7));
		System.out.println(singleII_2(list));
	}

	private static long singleII_1(ArrayList<Integer> arr) {
		HashSet<Integer> set = new HashSet<>();
		long sum = 0;
		for (Integer i : arr) {
			set.add(i);
			sum += i;
		}

		int setSum = 0;
		for (Integer i : set) {
			setSum += i;
		}

		return (3 * setSum - sum) >> 1;
	}

	private static int singleII_2(ArrayList<Integer> arr) {
		int sum = 0;
		int res = 0;
		for (int i = 0; i < 32; i++) {
			sum = 0;

			int x = (1 << i);
			for (int el : arr) {
				if ((el & x) == 0) {
					sum++;
				}
			}

			if ((sum % 3) == 0) {
				res |= x;
			}
		}

		return res;

	}

}
