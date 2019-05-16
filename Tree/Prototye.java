package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Prototye {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public static class BinaryTree {

		public TreeNode Construction() {
			ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
			
			TreeNode root = null;
			TreeNode[] tree = new TreeNode[list.size()];
			tree[0] = new TreeNode(list.get(0));
			root = tree[0];

			for (int i = 1; i < list.size(); i++) {
				if (list.get(i) == -1)
					continue;

				tree[i] = new TreeNode(list.get(i));
				int par = (i - 1) >> 1;

				if (((par << 1) + 1) == i)
					tree[par].left = tree[i];
				if (((par << 1) + 2) == i)
					tree[par].right = tree[i];

			}
			System.out.println(root);
			return root;
		}

		public static class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;

			TreeNode(int x) {
				val = x;
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
	}

}
