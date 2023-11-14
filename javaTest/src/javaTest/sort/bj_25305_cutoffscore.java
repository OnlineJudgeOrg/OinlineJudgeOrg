package javaTest.sort;

import java.util.*;
import java.io.*;

public class bj_25305_cutoffscore{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] nk = br.readLine().split(" ");
    	int n = Integer.parseInt(nk[0]); // 응시자의 수 n 
    	int k = Integer.parseInt(nk[1]); // 상을 받는 사람의 수 k
    	
    	// 응시자의 점수 배열 입력 받기
    	String[] inputs = br.readLine().split(" ");
    	// int 형태로 정렬하기 위해 사용할 list
    	ArrayList<Integer> inputList = new ArrayList<Integer>();
    	
    	
    	for(int i=0; i<inputs.length; i++) {
    		inputList.add(Integer.parseInt(inputs[i]));
    	}
    	
    	Collections.sort(inputList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -(o1 - o2); // 내림차순
			}
    		
    	});
    	
    	System.out.println(inputList.get(k-1)); //인덱스 0부터 시작이기 때문에 k-1해줌
    	
    }
}

