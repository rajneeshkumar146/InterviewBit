package LinkedList;

import java.util.Scanner;

import LinkedList.Q007_ReoderList.ListNode;

public class Q008_ListCycle {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		for (int i = 1; i <= 10; i++) {
			curr.next = new ListNode(1);
			curr = curr.next;
		}
		solve(head);
	}

	public static void solve(ListNode node) throws Exception {
		ListNode res = cycle(node);
		System.out.println(res != null ? res.val : -1);
	}

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode cycle(ListNode node) {
		ListNode slow = node;
		ListNode fast = node;

		do {
			slow = slow.next;
			fast = fast.next;

			if (fast != null) {
				fast = fast.next;
			} else {
				return null;
			}
		} while (fast != null && slow != fast);

		if (fast == null) {
			return null;
		}

		slow = node;
		while (slow != fast) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}

	public ListNode detectCycle(ListNode node) {
		if (node == null || node.next == null) {
			return null;
		}

		ListNode slow = node.next;
		ListNode fast = node.next.next;

		while (fast != null && fast.next != null && !slow.equals(fast)) {
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast == null || fast.next == null || !slow.equals(fast)) {
			return null;
		}

		slow = node;
		while (fast != null && slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;

	}

}
