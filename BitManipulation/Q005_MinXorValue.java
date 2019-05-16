package BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q005_MinXorValue {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(9, 5, 3));
		System.out.println(MinXorValue_01(arr));
	}

	private static int MinXorValue_01(ArrayList<Integer> arr) { // O(n2)
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				min = Math.min(min, arr.get(i) ^ arr.get(j));
			}
		}

		return min;

	}

	private static int MinXorValue_02(ArrayList<Integer> arr) { // O(nlogn)
		int min = Integer.MAX_VALUE;
		Collections.sort(arr);
			for (int j = 0; j < arr.size()-1; j++) {
				min = Math.min(min, arr.get(j) ^ arr.get(j+1));
			}
		

		return min;

	}

}
