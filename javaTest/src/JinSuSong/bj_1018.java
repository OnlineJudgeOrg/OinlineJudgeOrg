package javaTest;

import java.util.*;
import java.io.*;

public class bj_1018{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] size = br.readLine().split(" ");
    	
    	int n = Integer.parseInt(size[0]);
    	int m = Integer.parseInt(size[1]);
    	
    	// 2차원 체스판으로 사용할 배열 
    	String[][] board = new String[n][m];
    	
    	// 2차원 배열(체스판) 입력 받기 
    	for(int i=0; i<n; i++) {
    		String[] inputs_row = br.readLine().split("");
    		for(int j=0; j<m; j++) {
    			board[i][j] = inputs_row[j];
    		}
    	}
    	int minNum = m*n;
    	
    	for(int i=0; i<n-7; i++) {
    		//System.out.println(" i : " + i);
    		for(int j=0; j<m-7; j++) {
    			//System.out.println(" j : " + j);
    			int tmp = change(board, i, j);
    			//System.out.println("tmp : " + tmp);
    			minNum = Math.min(minNum, tmp);
    		}
    	}
    	System.out.println(minNum);
    	/*
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			System.out.print(board[i][j]);
    		}
    		System.out.println();
    	}
    	*/
    	
    
    	
    	
    }
    public static int change(String[][] board, int start_i, int start_j) {
    	int result = 0;
    	int changeFirstNum = 0;
    	int chagneOtherNum = 0;
    	for(int i=start_i; i<(start_i+8); i++) {
    		for(int j=start_j; j<(start_j+8); j++) {
    			String firstColor = board[0][0];
    			//System.out.println("firstColor : " + firstColor);
    			//System.out.println("board[i][j] : " + board[i][j]);
    			// 첫번째 값이 W인 경우,
    			
    			// 짝수 인 경우,
    			if ((i+j)%2 ==0 ) {
    				if(board[i][j].equals(firstColor)) {
    					// 짝수 값이 W값이 같으면 
    					chagneOtherNum++; 
    				}else {
    					// 짝수 값이 B이면, W가 
    					changeFirstNum++; 
    				}
    			}// 홀수 인 경우,
    			else {
    				if(board[i][j].equals(firstColor)) {
    					// 짝수 값이 W값이 같으면 
    					changeFirstNum++; 
    				}else {
    					// 짝수 값이 B이면, W가 
    					chagneOtherNum++; 
    				}
    			}
    		}
    		result = Math.min(changeFirstNum, chagneOtherNum);
    		//System.out.println("changeFirstNum : " + changeFirstNum);
    		//System.out.println("chagneOtherNum : " + chagneOtherNum);
    		//System.out.println("result : " + result);
    		//System.out.println();
    	}
    	return result;
    }
}

