package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q005_PaintersPartitionProblem {
	public static Scanner scn = new Scanner(System.in);

	public static void solve() throws Exception {
		ArrayList<Integer> board = new ArrayList<>(Arrays.asList(1000000, 1000000));
		System.out.println(paint(1, 1000000, board));
	}

	public static int paint(int painter, int time, ArrayList<Integer> board) {
		int[] prefixSum = new int[board.size() + 1];
		for (int i = 1; i <= board.size(); i++) {
			prefixSum[i] = (prefixSum[i - 1] % 10000003 + board.get(i - 1) % 10000003) % 10000003;
		}

		long res = (paint(1, painter, time, board, prefixSum) % 10000003L) * (time % 10000003L) % 10000003L;
		return (int) res;

	}

	private static int paint(int idx, int painter, int time, ArrayList<Integer> board, int[] prefixSum) {
		if (painter == 0 || idx > board.size()) {
			return Integer.MIN_VALUE;
		}

		if (painter == 1) {
			int res = (prefixSum[board.size()] - prefixSum[idx - 1]);
			return res;
		}

		long res = Integer.MAX_VALUE;
		for (int i = idx; i <= board.size(); i++) {
			long sum = prefixSum[i] - prefixSum[idx - 1];
			int smallRes = paint(i + 1, painter - 1, time, board, prefixSum);
			res = Math.min(Math.max(smallRes, sum), res);
		}

		return (int) res;
	}

	public static void main(String[] args) throws Exception {
		// solve();
		Bag.notes = new Notes();
		Bag.coins = new Coins();

		if (1 == 1) {
			Note n = new Note();
			n.setVal(10);
			Bag.setNotesVal(n);
		} else {
			Coin c = new Coin();
			c.setVal(10);
			Bag.setCoinsVal(c);
		}

		Bag.getNotes().display();
		Bag.getCoins().display();
	}

	private static class Bag {
		public static CInfo notes;
		public static CInfo coins;

		public static CInfo getNotes() {
			return notes;
		}

		public static CInfo getCoins() {
			return coins;
		}

		public static void setNotesVal(Note note) {
			notes.setVal(note);
		}

		public static void setCoinsVal(Coin coin) {
			coins.setVal(coin);
		}
	}

	private interface Info {
		void setVal(int value);

		void display();
	}

	private static class Note implements Info {
		int val;

		@Override
		public void setVal(int value) {
			this.val = value;
		}

		@Override
		public void display() {
			System.out.println(this.val);
		}

	}

	private static class Coin implements Info {
		int val;

		@Override
		public void setVal(int value) {
			this.val = value;
		}

		@Override
		public void display() {
			System.out.println(this.val);
		}

	}

	private interface CInfo {
		void setVal(Info value);

		void display();
	}

	private static class Notes implements CInfo {
		private ArrayList<Info> values = new ArrayList<>();

		public void setVal(Info value) {
			values.add(value);
		}

		public void display() {
			System.out.println("Notes: ");
			for (Info val : values) {
				val.display();
			}
		}
	}

	private static class Coins implements CInfo {
		private ArrayList<Info> values = new ArrayList<>();

		public void setVal(Info value) {
			values.add(value);
		}

		public void display() {
			System.out.println("Coins: ");
			for (Info val : values) {
				val.display();
			}
		}
	}
}