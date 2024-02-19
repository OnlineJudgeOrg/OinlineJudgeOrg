package javaTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_1463_oneMaker {
	// dfs로 모든 경우의 수 탐색하고 
	// dp 사용하기 
	// 10을 예로 들었을 때 ,
	/*
	 * 1. dp[10]을 찾아본다. 
	 * 2. 3으로 딱 나누어 떨어지는 수인가? 
	 * 3. 2로 딱 나누어 떨어지는 수인가? 
	 * 4. 1을 뺀다. 
	 * 5. dp[10-1]의 값을 채운다. 
	 * 
	 * 해당 과정을 반복한다. 
	 */

	public static int[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int targetNumber = Integer.parseInt(br.readLine());
		
		
		// 초기화 
		dp = new int [targetNumber+1];
		
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
//		dp[4] = 2;
//		dp[5] = 3;
		dp[6] = 2;
		
		int idx = 0;
		for(int i=4; i<dp.length; i++) {
			int cnt = 0;
			int tmp = i;
			int idx3 = 0;
			int idx2 = 0;
			int idx1 = 0;
			
			int divide3 = 0;
			int divide2 = 0;
			int subtract1 = 0;
			
			if(tmp%3 == 0) {
				idx3 = tmp/3;
				divide3 = dp[idx3] + 1;
			}else {
				divide3 = Integer.MAX_VALUE;
			}
			if(tmp%2 == 0) {
				idx2 = tmp/2;
				divide2 = dp[idx2] + 1;
			}else {
				divide2 = Integer.MAX_VALUE;
			}
			if(tmp-1 > 0) {
				idx1 = tmp-1;
				subtract1 = dp[idx1] + 1;
			}
//			System.out.println("i : " + i);
//			System.out.println("tmp : " + tmp);
//			System.out.println("dp[idx3] : " + dp[idx3]);
//			System.out.println("dp[idx2] : " + dp[idx2]);
//			System.out.println("dp[idx1] : " + dp[idx1]);
			
//			if(dp[tmp] >= 0) {
//				cnt += dp[tmp];
//			}
//			System.out.println("cnt+dp[tmp] : " + cnt);
			dp[i] = Math.min(divide3, Math.min(divide2, subtract1));
		}
//		for(int i=0; i<dp.length; i++) {
//			System.out.println("dp["+i+"] : " + dp[i]);
//		}
		System.out.println(dp[targetNumber]);
	}
}
