package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q013_2SumBinaryTree {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = { 10, 9, 20, -1, -1, -1, -1 };
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
		System.out.println(sumPath2(root, 40));
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

	public static int SumPath1(TreeNode node, int val) {
		ArrayList<Integer> list = new ArrayList<>();
		SumPath1(node, list);
		int i = 0, j = list.size() - 1;
		while (i < j) {
			int sum = list.get(i) + list.get(j);
			if (sum == val)
				return 1;
			else if (sum < val)
				i++;
			else
				j--;
		}

		return 0;

	}

	private static void SumPath1(TreeNode node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}
		SumPath1(node.left, list);
		list.add(node.val);
		SumPath1(node.right, list);

	}

	public static int sumPath2(TreeNode node, int val) {
		return sumPath2(node.left, node, val) | sumPath2(node, node.right, val);
	}

	private static int sumPath2(TreeNode node, TreeNode node1, int val) {
		if (node == null || node1 == null || node.equals(node1))
			return 0;

		int sum = node.val + node1.val;
		if (sum == val) {
			return 1;
		} else if (sum < val) {
			return sumPath2(node.right, node1, val) | sumPath2(node, node1.right, val);
		} else {
			return sumPath2(node.left, node1, val) | sumPath2(node, node1.left, val);
		}
	}
}
