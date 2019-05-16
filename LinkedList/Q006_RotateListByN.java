package LinkedList;

import java.util.List;
import java.util.Scanner;

import LinkedList.Q005_RemoveNthNodeFromLast.ListNode;

public class Q006_RotateListByN {
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

	private ListNode RotateList(ListNode node, int n) {
		int size = 0;
		ListNode tail = null;
		ListNode curr = node;

		while (curr != null) {
			tail = curr;
			curr = curr.next;
			size++;
		}

		if (n > size) {
			n %= size;
		}
		n = size - n;

		if (n == 0 || n == size) {
			return node;
		}

		curr = node;
		int count = 1;
		while (count < n) {
			count++;
			curr = curr.next;
		}

		ListNode head = curr.next;

		tail.next = node;
		curr.next = null;
		return head;

	}

}
