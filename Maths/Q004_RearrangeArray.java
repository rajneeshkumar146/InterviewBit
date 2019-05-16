package Maths;

import java.util.ArrayList;
import java.util.Scanner;

public class Q004_RearrangeArray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public void arrange(ArrayList<Integer> arr) {
		int[] res = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			res[i] = arr.get(arr.get(i));
		}

		for (int i = 0; i < res.length; i++) {
			arr.set(i, res[i]);
		}
	}

	public void arrangeInPlace(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			arr.set(i, arr.get(i) + arr.get(arr.get(i)) % arr.size() * arr.size());
		}

		// By modulus we get old value and by divison we get new value.

		for (int i = 0; i < arr.size(); i++) {
			arr.set(i, arr.get(i) / arr.size());
		}
	}

}
