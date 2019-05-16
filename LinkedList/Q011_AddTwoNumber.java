package LinkedList;

import java.util.Scanner;

import LinkedList.Q007_ReoderList.ListNode;

public class Q011_AddTwoNumber {
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

	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		int carry = 0;
		ListNode head = null;
		ListNode move = null;
		while (A != null && B != null) {
			int sum = carry + A.val + B.val;
			int rem = sum % 10;
			carry = sum / 10;
			A = A.next;
			B = B.next;

			ListNode node = new ListNode(rem);

			if (head == null) {
				head = node;
				move = node;
			} else {
				move.next = node;
				move = move.next;
			}
		}

		while (A != null) {
			int sum = carry + A.val;
			int rem = sum % 10;
			carry = sum / 10;
			A = A.next;
			ListNode node = new ListNode(rem);
			move.next = node;
			move = move.next;
		}

		while (B != null) {
			int sum = carry + B.val;
			int rem = sum % 10;
			carry = sum / 10;
			B = B.next;
			ListNode node = new ListNode(rem);
			move.next = node;
			move = move.next;
		}
		
		if(carry!=0){
			ListNode node = new ListNode(carry);
			move.next = node;
			move = move.next;
		}

		return head;
	}

}
