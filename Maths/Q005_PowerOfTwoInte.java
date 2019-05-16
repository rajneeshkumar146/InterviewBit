package Maths;

import java.util.Scanner;

public class Q005_PowerOfTwoInte {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static void solve() throws Exception {
		System.out.println(powerOf2Int_1(50));
	}

	private static boolean powerOf2Int(int num) {
		num = Math.abs(num);
		for (int i = 2; i * i <= num; i++) {
			for (int j = 2; Math.pow(i, j) <= num; j++) {
				if (Math.pow(i, j) == num) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean powerOf2Int_1(int num) {
		if (num == 1) {
			return true;
		}
		num = Math.abs(num);
		for (int i = 2; i * i <= num; i++) {
			int p = num;
			while (p % i == 0) {
				p /= i;
			}

			if (p == 1) {
				return true;
			}

		}
		return false;
	}

	private static boolean powerOf2Int_2(int a) {
		if (a == 1) {
			return true;
		}
		a = Math.abs(a);
		  for (int i = 2; i * i <= a; i++) { 
		        double val = Math.log(a) / Math.log(i); 
		        if ((val - (int)val) < 0.00000001) 
		            return true; 
		    } 
		  
		    return false; 
	}

}
