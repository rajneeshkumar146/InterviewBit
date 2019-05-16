package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q003_ThreeSumZero {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		System.out.println(
				threeSum(new ArrayList<>(Arrays.asList(-31013930, -31013930, 9784175, 9784175, 9784175, 21229755))));

	}

	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Collections.sort(A);
		int i = 0;
		while (i <= A.size() - 3) {
			if (i == 0 || A.get(i) > A.get(i - 1)) {

				int j = i + 1;
				int k = A.size() - 1;
				ArrayList<Integer> an = new ArrayList<>();
				while (j < k) {
					int sum = A.get(i) + A.get(j) + A.get(k);

					if (sum == 0) {
						an.add(A.get(i));
						an.add(A.get(j));
						an.add(A.get(k));
						ans.add(an);
						an = new ArrayList<>();
						j++;
						k--;

						while (j < k && A.get(j).equals(A.get(j - 1))) {
							j++;
						}

						while (j < k && A.get(k).equals(A.get(k + 1))) {
							k--;
						}

					} else if (sum < 0) {
						j++;
					} else if (sum > 0) {
						k--;
					}

				}
			}
			i++;
//			while ((i <= (A.size() - 3)) && (A.get(i).equals(A.get(i - 1)))) {
//				i++;
//			 }
		}

		return ans;
	}

}
