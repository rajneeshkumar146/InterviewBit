package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Q011_nQueen {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		boolean[][] board = new boolean[1][1];
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		nQueen(board, 0, 1, ans);
		System.out.println(ans);

	}

	private static void nQueen(boolean[][] board, int qpsf, int bno, ArrayList<ArrayList<String>> ans) {
		if (qpsf == board.length) {
			ArrayList<String> res = new ArrayList<>();

			for (boolean[] ar : board) {
				StringBuilder sb = new StringBuilder();
				for (boolean r : ar) {
					sb.append(r ? "Q" : ".");
				}

				res.add(sb.toString());
			}
			ans.add(res);
			return;
		}

		if (bno > board.length * board[0].length) {
			return;
		}

		nQueen(board, qpsf, bno + 1, ans); // queen Refuse to come.

		int row = (bno - 1) / board.length;
		int col = (bno - 1) % board.length;

		if (isSafe(board, row, col) && !board[row][col]) {
			board[row][col] = true;
			nQueen(board, qpsf + 1, bno + 1, ans);
			board[row][col] = false;
		}

	}

	private static boolean isSafe(boolean[][] board, int row, int col) {
		int[][] dirc = Eightdirction();

		for (int rad = 1; rad < board.length; rad++) {
			for (int i = 0; i < dirc.length; i++) {
				int r = row + rad * dirc[i][0];
				int c = col + rad * dirc[i][1];

				if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c]) {
					return false;
				}
			}
		}
		return true;

	}

	private static int[][] Eightdirction() {
		int[][] dirc = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

		return dirc;

	}

}
