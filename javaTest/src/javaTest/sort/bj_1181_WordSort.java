package javaTest.sort;

import java.util.*;
import java.io.*;

/*
 * 1181번 단어 정렬
 * 주어지는 단어 정렬하기 
 * 조건 1. 길이가 짧은 순
 * 조건 2. 사전 순
 * 조건 3. 중복 제거
 */
public class bj_1181_WordSort{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	// 중복제거를 위해 Set에 한번 담는다.
    	Set<String> set = new HashSet<String>();
    	
    	for(int i=0; i<n; i++) {
    		String inputStr = br.readLine();
    		set.add(inputStr);
    	}
    	
    	//정렬을 위해 List로 옮겨담기
    	ArrayList<String> list = new ArrayList<String>(set); 
    	
    	//정렬
    	Collections.sort(list, new Comparator<String>() {
    		@Override
    		public int compare(String o1, String o2) {
    			//System.out.println("o1 : " + o1);
    			//System.out.println("o2 : " + o2);
    			if(o1.length() == o2.length()) {
    				//System.out.println("if 실행");
    				return o1.compareTo(o2);
    			}else {
    				//System.out.println("else 실행");
    				return o1.length() - o2.length();
    			}
    		}
    	});
    	
    	//출력하기
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<list.size(); i++) {
    		sb.append(list.get(i)).append('\n');
    	}
    	System.out.println(sb);
    }
}

