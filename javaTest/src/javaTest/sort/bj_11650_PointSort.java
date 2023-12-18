package javaTest.sort;

import java.util.*;
import java.io.*;

/*
 * 11650번 좌표 정렬하기
 * 주어지는 x,y좌표를 정렬하기 
 * 조건 1. x 오름차순
 * 조건 2. y 오름차순
 */
public class bj_11650_PointSort{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	// 입력 값 좌표를 담을 리스트
    	ArrayList<String[]> list = new ArrayList<String[]>();
    	for(int i=0; i<n; i++) {
    		String[] inputs = br.readLine().split(" ");
    		list.add(inputs);
    	}
    	
    	for(String[] str : list) {
    		System.out.println(str[0]);
    	}
    	
    	// 정렬하기
    	Collections.sort(list, new Comparator<String[]>() {
    		@Override
    		public int compare(String[] o1, String[] o2) {
    			// o2가 1~4번 , o1이 2~5번이다.
    			if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
    				// x 좌표가 동일하면 y를 오름차순으로 정렬
    				return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
    			}else {
    				// x좌표를 오름차순으로 정렬
    				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
    			}
    		}
    	});
    	
    	// 출력하기
    	StringBuilder sb = new StringBuilder();
    	for(int i=0; i<list.size(); i++) {
    		String x = list.get(i)[0];
    		String y = list.get(i)[1];
    		sb.append(x).append(" ").append(y).append('\n');
    	}
    	//System.out.println(sb);
    }
}

