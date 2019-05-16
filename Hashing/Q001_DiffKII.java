package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q001_DiffKII {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Integer> list = ArrayInput(scn.nextInt());
		System.out.println(diffPossible(list, 2));
	}

	public static int diffPossible(final List<Integer> list, int n) {
		int size = list.size();
		int i = 0, j = 1;
		Collections.sort(list);

		while (i < size && j < size) {
			if (i != j && list.get(j) - list.get(i) == n) {
				return 1;
			} else if (list.get(j) - list.get(i) < n)
				j++;
			else
				i++;
		}

		return 0;
	}

	private static ArrayList<Integer> ArrayInput(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(scn.nextInt());
		}
		return list;
	}
}
