package StackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q003_RainWaterTapped {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		ArrayList<Integer> list = ArrayInput(scn.nextInt());
		System.out.println(TappedRain(list));
	}

	private static int TappedRain(ArrayList<Integer> list) {
		int[] left = new int[list.size() + 1];
		int[] right = new int[list.size() + 1];

		for (int i = 0; i < list.size(); i++) {
			left[i + 1] = Math.max(left[i], list.get(i));
			right[list.size() - 1 - i] = Math.max(right[list.size() - i], list.get(list.size() - 1 - i));
		}
		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			ans += Math.abs(Math.min(left[i + 1], right[i]) - list.get(i));
		}

		return ans;

	}

	private static ArrayList<Integer> ArrayInput(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(scn.nextInt());
		}
		return list;
	}

}
