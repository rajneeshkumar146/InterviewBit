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
 
 7 11 2 4 5 13 8 5 4 1
 */


package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q003_InOder {
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

	public ArrayList<Integer> inorderTraversal(TreeNode A) {
		if (A == null) {
			return new ArrayList<>();
		}

		ArrayList<Integer> myans = new ArrayList<>();
		
		myans.addAll(inorderTraversal(A.left));
		myans.add(A.val);
		myans.addAll(inorderTraversal(A.right));

		return myans;

	}

}
