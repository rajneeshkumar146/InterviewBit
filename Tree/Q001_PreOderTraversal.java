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
 
 5 4 11 7 2 8 13 4 5 1 
 

 */



package Tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Q001_PreOderTraversal {
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

	public ArrayList<Integer> preorderTraversal(TreeNode A) {
		if (A == null) {
			return new ArrayList<>();
		}

		ArrayList<Integer> myans = new ArrayList<>();
		myans.add(A.val);
		myans.addAll(preorderTraversal(A.left));
		myans.addAll(preorderTraversal(A.right));

		return myans;

	}

}
