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
    	HashMap map = new HashMap<String, String>();
    	
    	for(int i=0; i<n; i++) {
    		String[] inputs = br.readLine().split(" ");
    		String name = inputs[0];
    		String status = inputs[1];
    		
    		if(status.equals("enter")) {
    			map.put(name, status);
    		}else { // leave
    			if(map.containsKey(name)) {
    				map.remove(name);
    			}
    		}
    	}
    	//System.out.println(map);
    	ArrayList<String> list =  new ArrayList<String>( map.keySet());
    	Collections.sort(list, Collections.reverseOrder());
    	for(String key : list) {
    		System.out.println(key);
    	}
    }
}

