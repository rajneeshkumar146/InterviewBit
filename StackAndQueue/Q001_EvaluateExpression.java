package StackAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Q001_EvaluateExpression {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("-1"));
		System.out.println(Evaluate(list));

	}

	private static int Evaluate(ArrayList<String> list) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		Iterator<String> li = list.iterator();
		while (li.hasNext()) {
			String ele = li.next();
			char ch = ele.charAt(0);
			if (ele.length()==1 && (ch == '+' || ch == '/' || ch == '*' || ch == '-')) {
				int el1 = stack.pop();
				int el2 = stack.pop();
				stack.push(operation(ch, el1, el2));
			} else {
				stack.push(Integer.parseInt(ele));
			}
		}

		return stack.pop();

	}

	private static int operation(char ch, int el1, int el2) {
		if (ch == '+') {
			return el1 + el2;
		} else if (ch == '-') {
			return el2 - el1;
		} else if (ch == '*') {
			return el1 * el2;
		} else {
			return el2 / el1;
		}

	}

}
