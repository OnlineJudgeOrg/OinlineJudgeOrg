package javaTest.sort;

import java.util.*;
import java.io.*;
import java.sql.Array;

/*
 * 18870번 좌표압축
 */
public class bj_18870{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	String[] origin = br.readLine().split(" "); // 원본 배열
    	int[] sorted = new int[n]; // 정렬 할 배열
    	
    	for(int i=0; i<n; i++) {
    		sorted[i] = Integer.parseInt(origin[i]);
    	}
    	
    	Arrays.sort(sorted); // 정렬
    	
    	HashMap rankingMap = new HashMap<String, Integer>();
    	int rank  = 0;
    	for(int i=0; i<n; i++){
    		if(!rankingMap.containsKey(sorted[i])) { // 키가 중복되지 않을 때만 순위를 넣어준다. 
    		//if( map.get(inputsInt[i]) == null) {
    			rankingMap.put(sorted[i], rank);
    			rank++;
    		}
    	}
    	
    	// 원본 배열에 대한 순위를 출력한다.
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<n; i++) {
    		int key = Integer.parseInt(origin[i]);
    		int value = (int) rankingMap.get(key);
    		sb.append(value).append(" ");
    	}
    	System.out.println(sb);
    	
    }
}

