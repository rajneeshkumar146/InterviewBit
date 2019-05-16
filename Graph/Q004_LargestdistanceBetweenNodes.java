package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Q004_LargestdistanceBetweenNodes {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0));
		solve(A);

	}

	public static int solve(ArrayList<Integer> A) {

		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		int ans = 0;

		for (int i = 0; i < A.size(); i++) {
			if (!map.containsKey(A.get(i))) {
				map.put(A.get(i), new HashSet<>());
				map.get(A.get(i)).add(i);
			} else {
				map.get(A.get(i)).add(i);
			}
		}

		System.out.println(map);

		ArrayList list = new ArrayList<>(map.get(-1));
		System.out.println(list);

		ans = DFS(map, (int) list.get(0)).dia;

		System.out.println(ans);
		return ans;
	}

	private static class Node {
		private int dia = 0;
		private int height = 0;

		public Node(int dia, int height) {
			this.dia = dia;
			this.height = height;
		}

		public Node() {

		}
	}

	private static int largestDistance(ArrayList<Integer> A, int val) {
		Node[] arr = new Node[A.size()];
		for (int i = 0; i < A.size(); i++) {
			arr[i] = new Node();
		}

		int maxh = 0, maxd = 0;

		for (int i = A.size() - 1; i >= 0; i--) {
			int par = A.get(i);
			if (par == -1)
				continue;

			arr[par].dia = Math.max(arr[par].dia, Math.max(arr[i].dia, arr[i].height + arr[par].height + 1));
			arr[par].height = Math.max(arr[par].height, arr[i].height + 1);

			maxd = Math.max(maxd, arr[par].dia);
		}
		return maxd;

	}

	private static Node DFS(HashMap<Integer, HashSet<Integer>> map, int val) { // fail_for_large_testCases.
		if (!map.containsKey(val))
			return new Node(0, 0);

		ArrayList<Integer> keys = new ArrayList<>(map.get(val));
		int maxDia = -1, maxHei = -1;
		int max1 = -1, max2 = -1;

		for (Integer key : keys) {
			Node node = DFS(map, key);

			maxHei = Math.max(maxHei, node.height + 1);

			if (node.height > max1) {
				max2 = max1;
				max1 = node.height;
			} else if (node.height > max2) {
				max2 = node.height;
			}

			maxDia = Math.max(max1 + max2 + 2, Math.max(node.dia, maxDia));

		}

		return new Node(maxDia, maxHei);

	}

}
