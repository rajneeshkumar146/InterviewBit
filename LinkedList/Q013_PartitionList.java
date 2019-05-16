package LinkedList;

import java.util.Scanner;

import LinkedList.Q012_SwapListNode.ListNode;

public class Q013_PartitionList {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode partition(ListNode A, int B) {

		ListNode Headsmall = new ListNode(0);
		ListNode Headgreater = new ListNode(0);

		ListNode Currsmall = Headsmall;
		ListNode Currgreater = Headgreater;

		while (A != null) {

			if (A.val < B) {
				Currsmall.next = new ListNode(A.val);
				Currsmall = Currsmall.next;

			} else {
				Currgreater.next = new ListNode(A.val);
				Currgreater = Currgreater.next;
			}

			A = A.next;
		}

		Currsmall.next = Headgreater.next;
		return Headsmall.next;

	}
}
