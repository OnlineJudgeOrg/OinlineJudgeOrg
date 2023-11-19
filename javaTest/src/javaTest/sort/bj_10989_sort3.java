package javaTest.sort;

import java.util.*;
import java.io.*;
//10,000,000, 메모리 512일 경우, ArrayList를 사용하면 메모리 초과 발생
public class bj_10989_sort3{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	//ArrayList<Integer> inputs = new ArrayList<>();
    	int[] inputs = new int[n];
    	
    	for(int i=0; i<n; i++) {
    		//int input = Integer.parseInt(br.readLine());
    		//inputs.add(input);
    		inputs[i] = (Integer.parseInt(br.readLine()));
    	}
    	/*
    	Collections.sort(inputs, new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			return o1 - o2;
    		}
    	});
    	*/
    	//Collections.sort(inputs);
    	Arrays.sort(inputs);
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<inputs.length; i++) {
    		sb.append(inputs[i]).append('\n'); // 메모리 초과
    		//bw.write(inputs.get(i).toString() + '\n');
    		//bw.write(inputs.get(i).toString());
    		//bw.newLine();
    		
    	}
    	//bw.write(sb.toString());
    	System.out.println(sb);
    }
}

