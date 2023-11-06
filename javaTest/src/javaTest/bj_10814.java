package javaTest;

import java.util.*;
import java.io.*;

/*
 * 10814번 나이순 정렬
 */
public class bj_10814{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	ArrayList<Map<String, String>> customerInfo = new ArrayList<Map<String,String>>();
    	
    	for(int i=0; i<n; i++) {
    		Map<String,String> map = new HashMap<String, String>();
    		String[] inputs = br.readLine().split(" ");
    		map.put("age", inputs[0]);
    		map.put("class", inputs[1]);
    		customerInfo.add(map);
    	}
    	
    	//System.out.println(customerInfo);
    	Collections.sort(customerInfo, new Comparator<Map>() {

			@Override
			public int compare(Map o1, Map o2) {
				//System.out.println(o1.get("age"));
				//System.out.println(o1.get("class"));
				//System.out.println(o2.get("age"));
				//System.out.println(o2.get("class"));
				
				int o1Age = Integer.parseInt((String) o1.get("age"));
				int o2Age = Integer.parseInt((String) o2.get("age"));
				//String o1Class = (String) o1.get("class");
				//String o2Class = (String) o2.get("class");
				
				if(o1Age == o2Age) {
					//return -(o1Class.compareTo(o2Class)); // 문장열 내림차순
					return 0; // 가입한 순, 변동 x
					
				}
				return o1Age-o2Age; // 오름차순
			}
    		
    	});
    	
    	for(Map c : customerInfo) {
    		System.out.println(c.get("age") + " " + c.get("class"));
    	}
    	//System.out.println("result : " + customerInfo);
    }
}

