package LinkedList;

import java.util.Scanner;

public class Q010_ReverseLinkedListII {
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

	public ListNode reverseBetween(ListNode A, int B, int C) {
		if (B == C) {
			return A;
		}

		ListNode shead = A;
		ListNode stail = A;
		ListNode move = A;
		for (int i = 1; i < B; i++) {
			stail = move;
			move = move.next;
		}

		for (int i = B; i < C; i++) {
			move = move.next;
		}

		ListNode fhead = move.next;

		ListNode rtail = B != 1 ? stail.next : stail;
		ListNode rhead = move;

		move = rtail;
		ListNode prev = null;
		while (move != fhead) {
			ListNode temp = move.next;
			move.next = prev;
			prev = move;
			move = temp;
		}

		if (B != 1) {
			stail.next = rhead;
		} else {
			shead = rhead;
		}

		rtail.next = fhead;
		return shead;
	}
}
