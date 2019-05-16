package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Q010_ZigZagOder {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, -1, -1, -1, -1 };
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

	public static ArrayList<ArrayList<Integer>> zigzag(TreeNode node) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();

		LinkedList<TreeNode> st1 = new LinkedList<>();
		LinkedList<TreeNode> st2 = new LinkedList<>();
		st1.addFirst(node);
		boolean flag = false; // false means right to left.
		while (!st1.isEmpty()) {
			TreeNode pr = st1.removeFirst();
			ans.add(pr.val);

			if (!flag) {
				if (pr.left != null)
					st2.addFirst(pr.left);
				if (pr.right != null)
					st2.addFirst(pr.right);
			} else {
				if (pr.right != null)
					st2.addFirst(pr.right);
				if (pr.left != null)
					st2.addFirst(pr.left);
			}

			if (st1.isEmpty()) {
				LinkedList<TreeNode> temp = st1;
				st1 = st2;
				st2 = temp;

				res.add(ans);
				ans = new ArrayList<>();
				flag = !flag;
			}

		}

		return res;
	}

}
