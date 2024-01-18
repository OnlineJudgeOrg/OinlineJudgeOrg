package javaTest.backtracking;

import java.io.*;
import java.util.*;
/*
	
*/

public class bj_14888_operatorInsertion {
	public static int MAX = Integer.MIN_VALUE;
	public static int MIN = Integer.MAX_VALUE;
	public static int[] operator = new int[4];
	public static int[] number;
	public static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// n의 수 입력
		n = Integer.parseInt(br.readLine());
		// n 입력
		number = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 수 입력
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
//		int idx = 1;
//		int start = number[0];
		
		dfs(number[0], 1);
		System.out.println(MAX);
		System.out.println(MIN);
		
	}
	public static void dfs(int num, int idx) {
		if(idx == n) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		for(int i=0; i<4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				switch(i) {
					case 0 : 
						dfs(num + number[idx], idx + 1);
						break;
					case 1 :
						dfs(num - number[idx], idx + 1);
						break;
					case 2 : 
						dfs(num * number[idx], idx + 1);
						break;
					case 3 : 
						dfs(num / number[idx], idx + 1);
						break;
				}
				// 재귀 호출이 종료되면 다시 해당 연산자 개수를 복구
                operator[i]++;
			}
		}
		
		return ;
	}
}
