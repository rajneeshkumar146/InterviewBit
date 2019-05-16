package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q003_searchRange {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2,
				2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5,
				5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7,
				7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10,
				10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
		System.out.println(searchRange(a, 10));
	}

	public static ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(-1);
		ans.add(-1);
		for (int i = 0, j = a.size(); i <= j;) {
			int mid = (i + j) >> 1;
			if (a.get(mid) == b) {
				int left = getRange(a, 0, mid - 1, b, true);
				int right = getRange(a, mid + 1, a.size() - 1, b, false);
				ans.set(0, left != -1 ? left : mid);
				ans.set(1, right != -1 ? right : mid);
				break;
			} else if (a.get(mid) < b) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		
		return ans;

	}

	public static int getRange(final List<Integer> a, int sidx, int eidx, int b, boolean left) {
		int ans = -1;
		for (int i = sidx, j = eidx; i <= j;) {
			int mid = (i + j) >> 1;
			if (a.get(mid) == b) {
				ans = mid;

				if (left) {
					j = mid - 1;
				} else {
					i = mid + 1;
				}
			} else if (a.get(mid) < b) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}

		}

		return ans;
	}

}
