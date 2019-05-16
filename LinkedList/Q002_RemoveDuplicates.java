package LinkedList;

import java.util.Scanner;

public class Q002_RemoveDuplicates {
	
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	
	private static void solve() {
		
	}
	
	/*
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * 
	 For example,
	 Given 1->1->2, return 1->2.
	 Given 1->1->2->3->3, return 1->2->3.
	 */


	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode A) {

		ListNode curr=A;
		ListNode forw=curr.next;
		
		while(forw!=null){
			if(curr.val==forw.val){
				curr.next=forw.next;
				forw=forw.next;
			}else{
				curr=forw;
				forw=forw.next;
			}
		}
		
		
		return A;
		
		
		
	}

}
