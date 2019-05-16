package LinkedList;

import java.util.Scanner;

public class Q001_PalindromeList {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	
	private static void solve() {
		
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

	public int lPalin(ListNode A) {

		int size = size(A);
		ListNode mid = getNode(A,size / 2);
		ListNode Reverse = reverse(A, mid);

		mid = (size & 1) == 0 ? mid : mid.next;

		while (Reverse != null && mid != null) {
			if (Reverse.val != mid.val) {
				return 0;
			}

			Reverse = Reverse.next;
			mid = mid.next;
		}
		
		return 1;
	}

	public int size(ListNode A) {
		ListNode node = A;
		int i = 0;
		while (node != null) {
			node = node.next;
			i++;
		}

		return i;
	}

	public ListNode getNode(ListNode A, int idx) {
		ListNode node = A;
		int i = 0;
		while (i < idx) {
			node = node.next;
			i++;
		}

		return node;
	}

	public ListNode reverse(ListNode A, ListNode Stop) {
		ListNode prev = null;
		ListNode curr = A;
		while (curr != Stop) {
			ListNode forw = curr.next;
			curr.next = prev;
			prev = curr;
			curr = forw;
		}

		return prev;

	}
}
