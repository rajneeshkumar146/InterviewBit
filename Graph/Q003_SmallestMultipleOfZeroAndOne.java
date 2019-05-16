package Graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

public class Q003_SmallestMultipleOfZeroAndOne {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		System.out.println(multipleBest(scn.nextInt()));
		// System.out.println(multiple(scn.nextInt()));
	}

	private static class Node {
		private boolean isOne;
		private int val;
		private Node prevNode;

		public Node(boolean isOne, int val, Node prevNode) {
			this.isOne = isOne;
			this.val = val;
			this.prevNode = prevNode;
		}

		@Override
		public String toString() {
			return (this.isOne + "-> rem:" + this.val + "\n");
		}
	}

	public static String multipleBest(int A) {
		if (A == 1 || A == 0)
			return A + "";

		Node res = null;
		Node start = new Node(true, 1, null);
		ArrayDeque<Node> que = new ArrayDeque<>();
		que.addLast(start);
		boolean[] isdone = new boolean[A + 1];

		while (!que.isEmpty()) {
			Node node = que.removeFirst();

			int val = (node.val * 10) % A;

			if (!isdone[val]) {
				isdone[val] = true;
				que.addLast(new Node(false, val, node));

				if (val == 0) {
					res = que.getLast();
					break;
				}
			}

			if (!isdone[(val + 1) % A]) {
				isdone[(val + 1) % A] = true;
				que.addLast(new Node(true, val + 1, node));

				if ((val + 1) % A == 0) {
					res = que.getLast();
					break;
				}
			}

		}

		if (res == null)
			return "";

		StringBuilder str = new StringBuilder();
		while (res != null) {
			str.append(res.isOne ? "1" : "0");
			res = res.prevNode;
		}

		return str.reverse().toString();

	}

	private static int mod(String str, int a) {
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			res = res * 10 + (str.charAt(i) - '0');
			res %= a;
		}

		return res;
	}

	public static String multiple(int A) {

		LinkedList<String> que = new LinkedList<>();
		que.addLast("1");
		boolean[] arr = new boolean[A];

		while (!que.isEmpty()) {
			String str = que.removeFirst();
			int mod = mod(str, A);

			if (mod == 0)
				return str;

			if (arr[mod])
				continue;
			arr[mod] = true;

			que.addLast(str + '0');
			que.addLast(str + '1');
		}

		return "";
	}
}