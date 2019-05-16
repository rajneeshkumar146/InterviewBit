package LinkedList;

import java.util.Scanner;

public class Q004_MergeTwoLL {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode merge1(ListNode A, ListNode B) {
		ListNode poia = A;
		ListNode poib = B;

		ListNode res = null;
		ListNode curr = null;

		while (poia != null && poib != null) {
			ListNode node;
			if (poia.val < poib.val) {

				node = new ListNode(poia.val);
				poia = poia.next;
			} else {
				node = new ListNode(poib.val);
				poib = poib.next;

			}

			if (res == null) {
				res = node;
				curr = node;
			} else {
				curr.next = node;
				curr = curr.next;
			}

		}

		if (poia != null) {
			curr.next = poia;
		}
		if (poib != null) {
			curr.next = poib;
		}

		return res;
	}

	// InPlace_Recursive. but stackOverflow Occurs.
	public ListNode merge2Recursive(ListNode A, ListNode B) {
		if (A == null)
			return B;
		if (B == null)
			return A;

		if (A.val < B.val) {
			A.next = merge2(A.next, B);
			return A;
		} else {
			B.next = merge2(A, B.next);
			return B;
		}
	}

	public ListNode merge2(ListNode A, ListNode B) {
		ListNode poia = A;
		ListNode poib = B;

		ListNode head = new ListNode(0);
		ListNode curr = A;

		while (poia != null && poib != null) {
			if (poia.val < poib.val) {
				curr.next = poia;
			} else {
			}
		}

		return head;
	}

}
