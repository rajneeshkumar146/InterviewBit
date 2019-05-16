package LinkedList;

import java.util.Scanner;

public class Q009_KReversed {
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

	public static ListNode reverseList(ListNode A, int B) {

		ListNode node = null;

		ListNode temp_head = null;
		ListNode temp_tail = null;

		ListNode nhead = null;
		ListNode ntail = null;

		int temp = B;
		while (A != null) {
			node = A;
			A = A.next;
			node.next = null;
			if (temp != 0) {
				if (temp_head == null) {
					temp_head = node;
					temp_tail = node;
				} else {
					node.next = temp_head;
					temp_head = node;
				}
				temp--;
			}

			if (temp == 0) {
				temp = B;
				if (nhead == null) {
					nhead = temp_head;
					ntail = temp_tail;
				} else {
					ntail.next = temp_head;
					ntail = temp_tail;
				}

				temp_head = null;
				temp_tail = null;
			}

		}

		return nhead;
	}

}
