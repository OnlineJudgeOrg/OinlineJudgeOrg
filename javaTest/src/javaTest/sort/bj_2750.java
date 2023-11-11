package javaTest;

import java.util.*;
import java.io.*;

// [정렬] 백준 2750번, 수 정렬하기 
public class bj_2750{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] inputs = new int[n];
    	
    	for(int i=0; i<n; i++) {
    		inputs[i] = Integer.parseInt(br.readLine());
    	}
    	/*
    	for(int i=0; i<inputs.length; i++) {
    		System.out.println(inputs[i]);
    	}
    	System.out.println();
    	*/
    	Arrays.sort(inputs); // 배열 오름차순 정렬
    	
    	/* 내림차순
    	Arrays.sort(inputs, new Comparator<Integer>() {
    		@Override
    		public int compare(Integer i1, Integer i2) {
    			return i2 - i1;
    		}
    	});
    	*/
    	
    
    	for(int i=0; i<inputs.length; i++) {
    		System.out.println(inputs[i]);
    	}
    }
}

