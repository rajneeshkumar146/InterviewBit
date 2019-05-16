package LinkedList;

import java.util.Scanner;

import LinkedList.Q004_MergeTwoLL.ListNode;

public class Q005_RemoveNthNodeFromLast {
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

	private ListNode removeNthNode(ListNode node, int n) {
		int size = size(node);
		if (n == size || n > size) {
			return node.next;
		}

		ListNode slow = node;
		ListNode fast = node;
		int count = 1;
		while (count <= n) {
			fast = fast.next;
			count++;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		
		slow.next = fast;
		return node;
	}

	private int size(ListNode node) {
		int size = 0;

		while (node != null) {
			node = node.next;
			size++;
		}

		return size;
	}
}
