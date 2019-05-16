package LinkedList;

import java.util.Scanner;

public class Q015_InsertionSort {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		String str = "5 -> 66 -> 68 -> 42 -> 73 -> 25 -> 84 -> 63 -> 72 -> 20 -> 77 -> 38 -> 8 -> 99 -> 92 -> 49 -> 74 -> 45 -> 30 -> 51 -> 50 -> 95 -> 56 -> 19 -> 31 -> 26 -> 98 -> 67 -> 100 -> 2 -> 24 -> 6 -> 37 -> 69 -> 11 -> 16 -> 61 -> 23 -> 78 -> 27 -> 64 -> 87 -> 3 -> 85 -> 55 -> 22 -> 33 -> 62";
		StringBuilder res = new StringBuilder();
		int count = 0;
		for (int i = 0; i < str.length();) {
			int j = i;
			StringBuilder sres = new StringBuilder();
			while (j < str.length()) {
				if (str.charAt(j) == ' ') {
					j += 4;
					break;
				}

				sres.append(str.charAt(j));
				j++;
			}

			res.append(Integer.parseInt(sres.toString()));
			count++;
			res.append(" ");
			i = j;
		}

		System.out.println(count);
		System.out.println(res.toString());

		ListNode head = new ListNode(0);
		ListNode curr = head;
		for (int i = 1; i < count; i++) {
			curr.next = new ListNode(scn.nextInt());
			curr = curr.next;
		}
		solve(head.next);
	}

	public static void solve(ListNode node) throws Exception {
		ListNode res = insertionSortList(node);

		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}

	}

	static class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		@Override
		public String toString() {
			return this.val + "";
		}
	}

	public static ListNode insertionSortList(ListNode A) {
		ListNode head = new ListNode(A.val);
		A = A.next;
		while (A != null) {
			ListNode temp = new ListNode(A.val);
			ListNode currtemp = head;
			ListNode prev = null;
			while (currtemp != null) {
				if (currtemp.val < temp.val) {
					prev = currtemp;
					if (currtemp.next == null) {
						currtemp.next = temp;
						break;
					}
					currtemp = currtemp.next;
				} else {
					temp.next = currtemp;
					if (prev != null)
						prev.next = temp;
					if (currtemp == head) {
						head = temp;
					}

					break;
				}
			}

			A = A.next;
		}

		return head;

	}

}
