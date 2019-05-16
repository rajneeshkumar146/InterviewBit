/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
 *  1 if path exist else return 0.
 For example:
 Given the below binary tree and sum = 22,
 
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 
 1

 */


package Tree;

import java.util.Scanner;

public class Q005_PathSum {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = { 5, 1000, 200, -1, -1, -1 };
		TreeNode[] tree = new TreeNode[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1) {
				tree[i] = new TreeNode(arr[i]);
				if (i > 0) {
					int pi = (i - 1) >> 1;

					if (i == (pi << 1) + 1)
						tree[pi].left = tree[i];
					else
						tree[pi].right = tree[i];
				}
			}
		}

		TreeNode root = tree[0];
		System.out.println(root.toString());

		System.out.println(hasPathSum(root, 1000));

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

		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append(left == null ? "." : left.val);
			sb.append(" => " + val + " <= ");
			sb.append(right == null ? "." : right.val);
			sb.append("\n");

			if (left != null) {
				sb.append(left.toString());
			}

			if (right != null) {
				sb.append(right.toString());
			}

			return sb.toString();
		}

	}

	public static int hasPathSum(TreeNode A, int B) {
		if (A == null) {
			return 0;
		}

		if (A.val == B && A.left == null && A.right == null) { // leaf check.
			return 1;
		}

		return Math.max(hasPathSum(A.left, B - A.val), hasPathSum(A.right, B - A.val));
	}

}
