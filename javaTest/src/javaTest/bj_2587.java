package javaTest;

import java.util.*;
import java.io.*;

public class bj_2587{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	ArrayList<Integer> inputs = new ArrayList<Integer>();
    	int sum = 0; 
    	
    	for(int i=0; i<5; i++) {
    		int n = Integer.parseInt(br.readLine());
    		sum += n; // input과 동시에 합을 구한다.
    		inputs.add(n);
    	}
    	//Collections.sort(inputs);
    	inputs.sort(Comparator.naturalOrder()); // 정렬
    	System.out.println(sum / inputs.size()); // 평균값 출력
    	System.out.println(inputs.get(2)); // 중앙값 출력
    }
}

