package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Q002_LevelOrder {
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

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();

		LinkedList<TreeNode> que = new LinkedList<>();
		que.addLast(A);
		que.addLast(null);

		while (que.size() != 1) {
			TreeNode node = que.removeFirst();
			
			if (node.left != null) que.addLast(node.left);
			if (node.right != null) que.addLast(node.right);
			
			list.add(node.val);
			
			if (que.getFirst() == null) {
				que.removeFirst();
				que.addLast(null);
				ans.add(list);
				list = new ArrayList<>();
			}
			
		}

		return ans;

	}
}
