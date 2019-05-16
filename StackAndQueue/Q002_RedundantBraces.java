package StackAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Q002_RedundantBraces {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<Character> list = new ArrayList<>();
		String str = "(a+b)";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				list.add(str.charAt(i));
			}
		}

		System.out.println(Redundant(list));
	}

	static ArrayList<Character> oper = new ArrayList<>(Arrays.asList('+', '-', '*', '/','('));

	private static int Redundant(ArrayList<Character> list) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		Iterator<Character> li = list.iterator();

		while (li.hasNext()) {
			while (li.hasNext()) {
				char ch = li.next();
				if (ch == (')')) {
					break;
				}
				if (oper.contains(ch))
					stack.addFirst(ch);
			}

			if (!stack.isEmpty() && stack.getFirst() == ('(')) {
				return 1;
			}

			while (!stack.isEmpty()) {
				char ch = stack.removeFirst();
				if (ch == '(') {
					break;
				}

			}

		}

		if (!stack.isEmpty() && (stack.getFirst() == '(' || stack.getFirst() == ')')) {
			return 1;
		}

		return 0;

	}

}
