package javaTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9461_padovan {

	static Long[] dp = new Long[101]; // 배열 비어있는 표시는 -1이라고 가정

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		dp[0] = 0L;
		dp[1] = 1L;
		dp[2] = 1L;
		dp[3] = 1L;
		
		
		while(n-->0) {
			sb.append(padovan(Integer.parseInt(br.readLine()))).append('\n');
		}
		System.out.println(sb);
		
	}
	public static long padovan(int n) {
		if(dp[n] == null) {
			dp[n] = (padovan(n-2) + padovan(n-3));
		}
		return dp[n];
	}

}
