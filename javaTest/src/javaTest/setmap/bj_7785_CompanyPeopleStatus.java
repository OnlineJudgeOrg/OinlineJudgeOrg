package javaTest.setmap;

import java.util.*;
import java.io.*;

/*
 * 7785번 회사에 있는 사람
 * 
 * 시간 제한 : 1초
 * 메모리 제한 : 256 MB
 * 
 */
public class bj_7785_CompanyPeopleStatus{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	HashMap<String,Integer> hMap = new HashMap<String, Integer>();
    	
    	for(int i=0; i<n; i++) {
    		String[] inputs = br.readLine().split(" ");
    		String key = inputs[0];
    		if(hMap.get(key) != null) {
    			hMap.remove(key);
    		}else {
    			hMap.put(key, 0);
    		}
    	}
    	
    	//System.out.println(hMap.keySet());
    	ArrayList<String> list = new ArrayList<>(hMap.keySet());
    	
    	Collections.sort(list, new Comparator<String>() {
    		@Override
    		public int compare(String o1, String o2) {
    			return -(o1.compareTo(o2));
    		}
    	});
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<list.size(); i++) {
    		sb.append(list.get(i)).append('\n');
    	}
    	System.out.println(sb);
    }
}

