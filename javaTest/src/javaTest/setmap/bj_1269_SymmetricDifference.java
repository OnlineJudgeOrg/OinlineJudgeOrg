package javaTest.setmap;

import java.util.*;
import java.io.*;

/*
 * 1269번 대칭 차집합
 * A집합과 B집합에서 공통된 수를 제외하고 
 * A집합의 개수와 B집합의 개수를 더한다.
 * 
 * 시간 제한 : 2초
 * 메모리 제한 : 256 MB
 * 
 */
public class bj_1269_SymmetricDifference{
    public static void main(String args[]) throws IOException{
    	
    	//입력 받기
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	// A집합 입력 받기
    	st = new StringTokenizer(br.readLine(), " ");
    	HashMap<Integer, Integer> aMap = new HashMap<Integer, Integer>();
    	for(int i=0; i<n; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		aMap.put(num, 0);
    	}
    	
    	// B집합 입력 받기
    	st = new StringTokenizer(br.readLine(), " ");
    	HashMap<Integer, Integer> bMap = new HashMap<Integer, Integer>();
    	
    	// A집합에 존재하는 값은 제거, 존재하지 않으면 B집합에 추가
    	for(int i=0; i<m; i++) {
    		int num = Integer.parseInt(st.nextToken());
    		if(aMap.get(num) != null) {
    			aMap.remove(num);
    		}else {
    			bMap.put(num, 0);
    		}
    	}
    	
    	// 공통된 값이 없는 A집합과 B집합의 개수를 더한다.
    	int nSize = aMap.size();
    	int mSize = bMap.size();
    	
    	System.out.println(nSize + mSize);
    	
    }
}

