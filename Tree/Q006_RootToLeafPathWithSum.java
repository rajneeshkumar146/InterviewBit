/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
 * 
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
 
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */

package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q006_RootToLeafPathWithSum {
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

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		pathSum(A, B, res, new ArrayList<>());
		return res;
	}

	public void pathSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
		if (node == null) {
			return;
		}

		if (node.val == sum && node.left == null && node.right == null) {
			ArrayList<Integer> temp1 = new ArrayList<>(temp);
			temp1.add(node.val);
			result.add(temp1);
			return;
		}
		temp.add(node.val);
		pathSum(node.left, sum - node.val, result, temp);
		pathSum(node.right, sum - node.val, result, temp);
		temp.remove(temp.size() - 1);
	}

	public ArrayList<ArrayList<Integer>> pathSum2(TreeNode node, int sum) {
		if (node == null) {
			return new ArrayList<>();
		}

		if (node.left == null && node.right == null) {
			if (node.val == sum) {
				ArrayList<ArrayList<Integer>> bres = new ArrayList<>();
				ArrayList<Integer> list = new ArrayList<>();
				list.add(sum);
				bres.add(list);
				return bres;
			}

			return new ArrayList<>();
		}

		ArrayList<ArrayList<Integer>> left = pathSum(node.left, sum - node.val);
		ArrayList<ArrayList<Integer>> right = pathSum(node.right, sum - node.val);

		ArrayList<ArrayList<Integer>> myres = new ArrayList<>();
		for (ArrayList<Integer> list : left) {
			list.add(0, node.val);
			myres.add(list);
		}

		for (ArrayList<Integer> list : right) {
			list.add(0, node.val);
			myres.add(list);
		}

		return myres;

	}

}
