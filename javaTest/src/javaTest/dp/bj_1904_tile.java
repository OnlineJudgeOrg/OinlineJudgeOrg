package javaTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1904_tile {
	
	public static int[] dp = new int[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		// -1로 초기화 
		for(int i=3; i<dp.length; i++) {
			dp[i] = -1;
		}
		
		System.out.println(Tile(n));
		
	}
	public static int Tile(int n) {
		if(dp[n] == -1) {
			dp[n] = (Tile(n-1) + Tile(n-2)) % 15746;
		}
		return dp[n];
	}

}
