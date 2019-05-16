package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q001_SmallestSequenceWithPrime {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {

		System.out.println(solve(1,2, 5, 8));

	}

	public static ArrayList<Integer> solve(int A, int B, int C, int D) {
		HashSet<Integer> ans = new HashSet<>();
		PriorityQueue<Integer> que=new PriorityQueue<>();
		
        que.add(A);
		que.add(B);
		que.add(C);

		while (!que.isEmpty() && ans.size() != D) {
				int mul = que.remove();

				que.add(mul * A);
				que.add(mul * B);
				que.add(mul * C);

				ans.add(mul);
		}

		ArrayList<Integer> list = new ArrayList<>(ans);
		Collections.sort(list);

		return list;

	}

}
