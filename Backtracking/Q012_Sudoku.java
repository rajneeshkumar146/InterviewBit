package Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class Q012_Sudoku {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	private static int[] rBit = new int[9];
	private static int[] cBit = new int[9];
	private static int[][] matBit = new int[3][3];
	private static ArrayList<ArrayList<Character>> ans = new ArrayList<>();

	public static void solve() throws Exception {

		ArrayList<ArrayList<Character>> list = new ArrayList<>();
		int[][] board = new int[9][9];
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				board[i][j] = list.get(i).get(j) == '.' ? 0 : list.get(i).get(j) - '0';
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				rBit[i] |= (1 << board[i][j]);
				cBit[j] |= (1 << board[i][j]);
				matBit[i / 3][j / 3] |= (1 << board[i][j]);
			}
		}

		Sudoku(board, 1);
		// System.out.println(ans);
		for (int i = 0; i < 9; i++) {
			list.get(i).addAll(new ArrayList<>());
		}

	}

	private static void Sudoku(int[][] board, int cellNo) {
		if (cellNo == board.length * board[0].length) {
			for (int i = 0; i < board.length; i++) {
				ArrayList<Character> res = new ArrayList<>();
				for (int j = 0; j < board[0].length; j++) {
					String ele = board[i][j] + "";
					res.add(ele.charAt(0));
				}
				ans.add(res);
			}

			return;
		}

		int r = (cellNo - 1) / board.length;
		int c = (cellNo - 1) % board.length;
		if (board[r][c] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isSafe(board, i, cellNo)) {
					setNumber(board, i, cellNo);
					Sudoku(board, cellNo + 1);
					UnsetNumber(board, i, cellNo);
				}
			}
		} else {
			Sudoku(board, cellNo + 1);
		}

	}

	private static boolean isSafe(int[][] board, int num, int cellNo) {
		int r = (cellNo - 1) / board.length;
		int c = (cellNo - 1) % board.length;

		int mask = (1 << num);
		if (((rBit[r] & mask) == 0) && ((cBit[c] & mask) == 0) && (matBit[r / 3][c / 3] & mask) == 0) {
			return true;
		}
		return false;
	}

	private static void setNumber(int[][] board, int num, int cellNo) {

		int r = (cellNo - 1) / board.length;
		int c = (cellNo - 1) % board.length;

		board[r][c] = num;
		rBit[r] |= (1 << num);
		cBit[c] |= (1 << num);
		matBit[r / 3][c / 3] |= (1 << num);
	}

	private static void UnsetNumber(int[][] board, int num, int cellNo) {

		int r = (cellNo - 1) / board.length;
		int c = (cellNo - 1) % board.length;

		board[r][c] = 0;
		rBit[r] ^= (1 << num);
		cBit[c] ^= (1 << num);
		matBit[r / 3][c / 3] ^= (1 << num);
	}

}
