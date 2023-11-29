package javaTest.setmap;

import java.util.*;
import java.io.*;

/*
 * 1764번 듣보잡
 * 숫자 N개 배열에 적혀있는 문자와 M개 배열의 문자를 비교해
 * 양쪽 모두에 존재하는 문자를 출력
 * 
 * 시간 제한 : 2초
 * 메모리 제한 : 256 MB
 * 시간초과
 */
public class bj_1764_FindCommonStrings{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] nm = br.readLine().split(" ");
    	int n = Integer.parseInt( nm[0] );
    	int m = Integer.parseInt( nm[1] );
    	
    	HashMap<String, Integer> hmap = new HashMap<String, Integer>();
    	
    	// 입력 값을 map으로 저장하기
    	for(int i=0; i<n; i++) {
    		String keyN = br.readLine();
    		hmap.put(keyN, 1);
    	}
    	
    	// 동일한 문자열을 저장할 리스트
    	ArrayList<String> list = new ArrayList<String>();
    	for(int j=0; j<m; j++) {
    		String keyM = br.readLine();
    		if(hmap.get(keyM) != null) {
    			list.add(keyM);
    		}
    	}
    	
    	// 사전순으로 정렬하기
    	Collections.sort(list, new Comparator<String>() {
    		@Override
    		public int compare(String o1, String o2) {
    			return o1.compareTo(o2);
    		}
    	});
    	
    	// 출력하기
    	StringBuilder sb = new StringBuilder();
    	for(String str : list) {
    		sb.append(str).append("\n");
    	}
    	System.out.println(list.size());
    	System.out.println(sb);
    	
    }
}

