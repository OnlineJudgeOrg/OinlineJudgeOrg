package javaTest;

import java.util.*;
import java.io.*;

public class bj_2751_sort2{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	ArrayList<Integer> inputs = new ArrayList<Integer>();
    	
    	for(int i=0; i<n; i++) {
    		inputs.add( Integer.parseInt(br.readLine()));
    	}
    	
    	Collections.sort(inputs, new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			return o1 - o2; // 오름차순
    		}
    	});
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i : inputs) {
    		//sb.append(i).append('\n');
    		//System.out.println(i); 시간초과
    		bw.write(String.valueOf(i)+'\n'); // 172876KB, 1680ms
    	}
    	//System.out.println(sb); // 130520KB, 1435ms
    	//bw.write(sb.toString()); // 130700KB, 1456ms
        bw.flush();
        bw.close();
    }
}

