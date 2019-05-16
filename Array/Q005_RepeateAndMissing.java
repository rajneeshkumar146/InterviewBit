package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Q005_RepeateAndMissing {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public ArrayList<Integer> repeatedNumber(ArrayList<Integer> arr) {

		int xor = 0;
		int n = arr.size();
		for (int i = 0; i < arr.size(); i++) {
			int val = arr.get(i);
			xor ^= val;
		}

		for (int i = 1; i <= arr.size(); i++) {
			xor ^= i;
		}

		int setbit = xor & -xor;
		int dupli = 0;
		int miss = 0;

		for (int i = 0; i < n; i++) {
			int val = arr.get(i);
			if ((val & setbit) != 0) {
				dupli ^= val;
			} else {
				miss ^= val;
			}
		}

		for (int i = 1; i <= n; i++) {
			if ((i & setbit) != 0) {
				dupli ^= i;
			} else {
				miss ^= i;
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (dupli == arr.get(i)) {
				ans.add(dupli);
				ans.add(miss);
				break;
			} else if (miss == arr.get(i)) {
				ans.add(miss);
				ans.add(dupli);
				break;

			}
		}

		return ans;

	}

	public ArrayList<Integer> repeatedNumber1(int[] arr) {
		int dupli = 0;
		int miss = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i]) - 1] > 0) {
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
			} else {
				dupli = Math.abs(arr[i]);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				miss = i + 1;
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(dupli);
		ans.add(miss);
		return ans;

	}
}
