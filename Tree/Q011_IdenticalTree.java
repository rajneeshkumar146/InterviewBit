package Tree;

import java.util.Scanner;

public class Q011_IdenticalTree {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public int isSameTree(TreeNode A, TreeNode B) {
		if (A == null && B == null) {
			return 1;
		} else if (A == null || B == null) {
			return 0;
		}

		if (A.val != B.val) {
			return 0;
		}

		return Math.min(isSameTree(A.left, B.left), isSameTree(A.right, B.right));

	}

}
