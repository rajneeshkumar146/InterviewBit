package LinkedList;

import java.util.Scanner;

import LinkedList.Q013_PartitionList.ListNode;

public class Q014_SortLinkedList {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		for (int i = 1; i <= 10; i++) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}
		solve(head.next);
	}

	public static void solve(ListNode node) throws Exception {
		ListNode res = sortList(node);
	}

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode sortList(ListNode A) {
		return mergeSort(A);
	}

	private static ListNode mergeSort(ListNode node) {
		if (node.next == null) {
			return node;
		}

		ListNode mid = getMid(node);
		ListNode htwo = mid.next;
		mid.next = null;

		ListNode one = mergeSort(node);
		ListNode two = mergeSort(htwo);

		return MergerTwoSortedLL(one, two);
	}

	private static ListNode MergerTwoSortedLL(ListNode one, ListNode two) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while (one != null && two != null) {
			if (one.val < two.val) {
				curr.next = new ListNode(one.val);
				one = one.next;
				curr = curr.next;
			} else {
				curr.next = new ListNode(two.val);
				two = two.next;
				curr = curr.next;
			}
		}

		while (one != null) {
			curr.next = new ListNode(one.val);
			one = one.next;
			curr = curr.next;

		}

		while (two != null) {
			curr.next = new ListNode(two.val);
			two = two.next;
			curr = curr.next;

		}

		return head.next;
	}

	private static ListNode getMid(ListNode node) {
		ListNode slow = node;
		ListNode fast = node;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}
}
