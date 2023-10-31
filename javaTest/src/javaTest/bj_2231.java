package javaTest;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] nm = br.readLine().split(" ");
    	int n = Integer.parseInt(nm[0]); // 입력 받을 수의 개수
    	int m = Integer.parseInt(nm[1]); // 타겟 숫자
    	
    	ArrayList<Integer> inputs = new ArrayList<>();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	for(int i=0; i<n; i++) {
    		inputs.add(Integer.parseInt(st.nextToken()));
    	}
    	
    	int result = 0;
    	// 완전탐색을 활용해서 3중 for문으로 돌린다.
    	for(int i=0; i<n-2; i++) {
    		for(int j=i+1; j<n-1; j++) {
    			for(int k=j+1; k<n; k++) {
    				int tmp = inputs.get(i) + inputs.get(j) + inputs.get(k);
    				
    				if (tmp == m) {
    					result = m;
    					break;
    				}else if (result < tmp && tmp < m) {
    					result = tmp;
    				}
    				
    			}
    		}
    	}
    	System.out.println(result);
    
    }
}

