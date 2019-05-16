package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q004_MaximumPointOnStraightLine {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

	}

	public static class Pair {
		private int x;
		private int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {

			if (this == obj) {
				return true;
			}

			if (!(obj instanceof Pair)) {
				return false;
			}

			// typeCast
			Pair p = (Pair) (obj);

			return Integer.compare(this.y, p.y) == 0 && Integer.compare(this.x, p.x) == 0;
		}
	}

	private static int gcd(int n, int m) {
		if (n == 0) {
			return m;
		}
		return gcd(m % n, n);
	}

	private static int MaxiPoint(ArrayList<Pair> points) {
		if (points.size() < 2) {
			return points.size();
		}

		int maxPoint = 0;
		HashMap<Pair, Integer> map = new HashMap<>();

		for (int i = 0; i < points.size(); i++) {
			int currMax = 0, VerticalMax = 0, OverlappedMax = 0;

			Pair one = points.get(i);
			for (int j = i + 1; j < points.size(); j++) {
				Pair two = points.get(j);

				if (one.equals(two)) {
					OverlappedMax++;
				} else if (one.x == two.x || one.y == two.y) {
					VerticalMax++;
				} else {
					int yDiff = (two.y - one.y);
					int xDiff = (two.x - one.x);

					int gcd = gcd(xDiff, yDiff);

					xDiff /= gcd;
					yDiff /= gcd;

					Pair pair = new Pair(xDiff, yDiff);
					if (!map.containsKey(pair)) {
						map.put(pair, 1);
					} else {
						map.put(pair, map.get(pair) + 1);
					}

					currMax = Math.max(currMax, map.get(pair));
				}
				currMax = Math.max(currMax, VerticalMax);
			}
			maxPoint = Math.max(maxPoint, currMax + OverlappedMax + 1);
		}

		return maxPoint;

	}

}
