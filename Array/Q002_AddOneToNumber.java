package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q002_AddOneToNumber {
	final int mod = 1000000000 + 7;
	final int max = Integer.MAX_VALUE;
	final int min = Integer.MIN_VALUE;

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 3, 7, 6, 4, 0, 5, 5, 5));
		AddOneNumber(arr);

	}

	private static void AddOneNumber(ArrayList<Integer> arr) {
		int[] ans = new int[arr.size() + 1];
		int i = arr.size() - 1;
		int k = ans.length - 1;
		int carry = 1;
		while (i >= 0) {
			ans[k] = (arr.get(i) + carry) % 10;
			carry = (arr.get(i) + carry) / 10;
			k--;
			i--;
		}

		ans[0] += carry;
		boolean flag = false;
		ArrayList<Integer> list = new ArrayList<>();

		for (i = 0; i < ans.length; i++) {
			if (ans[i] == 0 && !flag) {
				continue;
			}

			flag = true;
			list.add(ans[i]);
		}

		System.out.println(list);

	}

	private static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
