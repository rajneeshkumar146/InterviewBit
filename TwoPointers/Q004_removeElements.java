package TwoPointers;

import java.util.ArrayList;
import java.util.Scanner;

public class Q004_removeElements {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public int removeElement(ArrayList<Integer> a, int b) {
		ArrayList<Integer> ans = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < a.size(); i++) {
			if (!a.get(i).equals(b)) {

				a.set(count, a.get(i));
				count++;
			}
		}

		return count;
	}

}
