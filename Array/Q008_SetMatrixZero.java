package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Q008_SetMatrixZero {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public void setZeroes1(ArrayList<ArrayList<Integer>> a) {

		int[] x = new int[a.size()];
		int[] y = new int[a.get(0).size()];

		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(0).size(); j++) {
				if (a.get(i).get(j) == 0) {
					x[i] = 1;
					y[j] = 1;
				}
			}
		}

		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.get(0).size(); j++) {
				if (x[i] == 1 || y[j] == 1) {
					a.get(i).set(j, 0);
				}
			}
		}
	}

	public static void setZero(ArrayList<Integer> a) {

	}

}
