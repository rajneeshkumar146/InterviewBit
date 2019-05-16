package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class Q005_CopyList {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	private static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode temp = head;
		RandomListNode newHead = new RandomListNode(head.label);
		RandomListNode temp1 = newHead;

		map.put(temp, temp1);
		temp = temp.next;

		while (temp != null) {
			temp1.next = new RandomListNode(temp.label);
			map.put(temp, temp1.next);
			temp = temp.next;
			temp1 = temp1.next;
		}

		temp = head;
		temp1 = newHead;
		while (temp != null) {
			if (temp.random != null) {
				temp1.random = map.get(temp.random);
			}
			temp = temp.next;
			temp1 = temp1.next;
		}

		return newHead;
	}

}
