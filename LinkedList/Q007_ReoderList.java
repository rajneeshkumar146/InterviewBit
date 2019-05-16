package LinkedList;

import java.util.Scanner;

public class Q007_ReoderList {
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

	private ListNode Reoder(ListNode node) {
		ListNode slow = node;
		ListNode fast = node;

		// find Mid..
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// reverse List from mid to last
		ListNode rever = Reverse(slow.next);
		slow.next = null;

		// start combining them..
		slow = node;
		while (slow != null && rever != null) {
			ListNode temp = slow.next;
			slow.next = rever;
			rever = rever.next;
			slow.next.next = temp;
			slow = temp;
		}

		return node;

	}

	private ListNode Reverse(ListNode node) {
		if (node == null) {
			return node;
		}

		ListNode prev = null;
		ListNode curr = node;

		while (curr != null) {
			ListNode forw = curr.next;
			curr.next = prev;
			prev = curr;
			curr = forw;
		}

		return prev;
	}
}
