/*
 * Given a binary tree, print its preOder path.
 For example:
 
  5
 /  \
 4    8
 /    / \
 11   13  4
 / \    / \
 7  2  5   1

 
 output:
 
 7 2 11 4 8 13 5 1 4 5 
 */

package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q002_postOder {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public ArrayList<Integer> postorderTraversal(TreeNode A) {
		if (A == null) {
			return new ArrayList<>();
		}

		ArrayList<Integer> myans = new ArrayList<>();

		myans.addAll(postorderTraversal(A.left));
		myans.addAll(postorderTraversal(A.right));
		myans.add(A.val);
		return myans;

	}

}
