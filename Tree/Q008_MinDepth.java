package Tree;

import java.util.Scanner;

public class Q008_MinDepth {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = { 5, 1000, 200, -1, -1, -1 };
		TreeNode[] tree = new TreeNode[arr.length];
		tree[0] = new TreeNode(arr[0]);
		TreeNode root = tree[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != -1) {
				tree[i] = new TreeNode(arr[i]);
				int pi = (i - 1) >> 1;
				if (i == (pi << 1) + 1)
					tree[pi].left = tree[i];
				else
					tree[pi].right = tree[i];
			}
		}

		System.out.println(root.toString());
		System.out.println(minDepth(root));

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

		@Override
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

	public static int minDepth(TreeNode node) {
		if (node == null) {
			return (int) 1e6;
		}

		if (node.left == null && node.right == null) {
			return 1;
		}

		return Math.min(minDepth(node.left), minDepth(node.right)) + 1;

	}

}
