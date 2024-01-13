package javaTest.backtracking;

import java.io.*;
import java.util.*;
/*
	길이가 m인 수열을 모두 구한다
	1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
*/

public class bj_15650_nAndm2 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] availableNumber = new int[n+1];
		for(int i=0; i<availableNumber.length; i++) {
			availableNumber[i] = i;
		}
		int[] resultNumber = new int[m];
		
		int depth = 0;
		int start = 1;
		
		dfs(depth, m, n, availableNumber, resultNumber, start);
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth, int m, int n, int[] availableNumber, int[] resultNumber, int start) {
		if (depth == m) {
			// 출력
			for(int i=0; i<resultNumber.length; i++) {
				sb.append(resultNumber[i]).append(" ");
			}
			sb.append("\n");
			return ;
		}
		for(int i=start; i<availableNumber.length; i++) {
			resultNumber[depth] = i;
			dfs(depth+1, m, n, availableNumber, resultNumber, i+1);
		}
	}
}
