package javaTest.sort;

import java.util.*;
import java.io.*;
//소트인사이드
//숫자의 각 자리수를 내림차순으로 정렬
public class bj_1427_SortInside{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String input = br.readLine();
    	ArrayList<Integer> inputList = new ArrayList<>();
    	int n = Integer.parseInt(input);
    	
    	for(int i=0; i<input.length(); i++) {
    		
    		int divisor = 10; 			 // 나누는 수는 10으로 고정
    		int remainder = (n/divisor); // 몫
    		int mod = (n%divisor);		 // 나머지는 일의 자리수
    		n = remainder;				 // 다음 나눠지는 수 = 몫으로 변경
    		
    		inputList.add(mod);
    			
    	}
    	// 내림차순 정렬
    	Collections.sort(inputList, new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			return -(o1-o2);
    		}
    	});
    	
    	//System.out.println(inputList);
    	StringBuilder sb = new StringBuilder();
    	for(int num : inputList) {
    		//sb.append(num).append('\n');
    		sb.append(num);
    	}
    	System.out.println(sb.toString());
    }
}

