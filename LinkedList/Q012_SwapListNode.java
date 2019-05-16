package LinkedList;

import java.util.Scanner;

import LinkedList.Q009_KReversed.ListNode;

public class Q012_SwapListNode {
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

	public static ListNode swapPairs(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}

		ListNode head = A.next;
		ListNode prev = null;

		while (A != null && A.next != null) {
			ListNode temp = A.next;
			A.next = A.next.next;
			temp.next = A;

			if (prev != null)
				prev.next = temp;

			prev = A;

			A = A.next;
		}

		return head;

	}

}
