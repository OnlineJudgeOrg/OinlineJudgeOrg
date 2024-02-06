package javaTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_24416_fibonacci {
	public static int cnt1 = 1;
	public static int cnt2 = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		fib(n);
		fibonacci(n);
		System.out.println(cnt1 + "" + cnt2);
	}
	
	public static int fib(int n) {
		if(n <= 2) {
			return 1;
		}
		cnt1++;
		return fib(n-1) + fib(n-2);
	}
	
	public static int fibonacci(int n) {
		int[] f = new int[n+1];
		f[0] = f[1] = 1;
		for(int i=3; i<=n; i++) {
			cnt2++;
			f[i] = f[i-1] + f[i-2];
		}
		return f[n];
	}

}
