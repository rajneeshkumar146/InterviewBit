package LinkedList;

import java.util.Scanner;

public class Q003_RemoveDuplicatesII {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	// Definition for singly-linked list.
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode A) {

		ListNode head = A;
		ListNode prev = A;
		ListNode curr = A;

		boolean flag = false;
		while (curr != null) {
			while (curr.next != null && curr.val == curr.next.val) {
				flag = true;
				curr = curr.next;
			}

			if (flag && head.val == curr.val) {
				head = curr.next;
				prev = curr.next;
				flag = false;
			} else if (flag) {
				prev.next = curr.next;
				flag = false;
			}

			curr = curr.next;
			prev = prev.next;

		}

		return head;

	}

}
