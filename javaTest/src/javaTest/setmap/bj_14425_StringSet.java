package javaTest.setmap;

import java.util.*;
import java.io.*;

/*
 * 14425번 문자열 집합
 * N개의 문자열 집합 S가 있음.
 * 입력으로 들어오는 M개의 문자열 중에서 S에 포함되는 단어의 개수
 * 
 * 시간 제한 : 2초
 * 메모리 제한 : 1536 MB
 * 
 */
public class bj_14425_StringSet{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] nm = br.readLine().split(" ");
    	int n = Integer.parseInt(nm[0]);
    	int m = Integer.parseInt(nm[1]);
    	
    	HashMap<String, Integer> hMap = new HashMap<String, Integer>();
    	
    	//집합 S 입력 받기, 중복은 존재하지 않음.
    	for(int i=0; i<n; i++) {
    		hMap.put(br.readLine(), 0);
    	}
    	
    	//System.out.println(hMap);
    	
    	int cnt = 0;
    	for(int j=0; j<m; j++) {
    		String key = br.readLine();
    		if(hMap.get(key) != null) {
    			cnt++;
    		}
    	}
    	System.out.println(cnt);
    }
}

