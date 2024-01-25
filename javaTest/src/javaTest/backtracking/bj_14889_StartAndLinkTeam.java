package javaTest.backtracking;

import java.io.*;
import java.util.*;
/*
	
*/

public class bj_14889_StartAndLinkTeam {
	
	public static int number;
	public static int[][] array;
	public static boolean[] checkArray;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		number = Integer.parseInt(br.readLine());
		array = new int[number][number];
		checkArray = new boolean[number];
		
		for(int i=0; i<number; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<number; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int depth = 0;
		int idx = 0;
		dfs(depth,idx);
		
		System.out.println(min);
		
	}
	
	public static void dfs(int depth, int idx) {
		if(depth == number/2) {
			diff();
			return;
		}
		
		for(int i=idx; i<number; i++) {
			checkArray[i] = true;
			dfs(depth+1, i+1);
			checkArray[i] = false;
		}
		return ;
	}
	
	public static void diff() {
		int start = 0;
		int link = 0;
		
		for(int i=0; i<number-1; i++) {
			for(int j=i+1; j<number; j++) {
				if(checkArray[i] == true && checkArray[j] == true) {
					start += array[i][j];
					start += array[j][i];
				}else if(checkArray[i] == false && checkArray[j] == false) {
					link += array[i][j];
					link += array[j][i];
				}
			}
		}
		
		int diff = Math.abs(start-link);
		if(diff == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		min = Math.min(min, diff);
	}
}
