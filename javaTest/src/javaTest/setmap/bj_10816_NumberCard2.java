package javaTest.setmap;

import java.util.*;
import java.io.*;

/*
 * 10816번 숫자 카드2
 * 숫자 N개 배열에 적혀있는 숫자와 M개 배열의 숫자를 비교해
 * 숫자 N이 배열 M에 존재하는 개수를 출력
 * 
 * 시간 제한 : 2초
 * 메모리 제한 : 256 MB
 * 시간초과
 */
public class bj_10816_NumberCard2{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	// 첫번째 입력 값의 수
    	int n = Integer.parseInt(br.readLine());
    	// 첫번째 기준 배열의 입력과 동시에 숫자를 체크한다.
    	HashMap<Integer, Integer> nMap = new HashMap<Integer, Integer>();
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	for(int i=0; i<n; i++) {
    		int key = Integer.parseInt(st.nextToken());
    		nMap.put(key, nMap.getOrDefault(key, 0)+1);
    	}
    	
    	// 두번째 입력 값의 개수
    	int m = Integer.parseInt(br.readLine());
    	
    	st = new StringTokenizer(br.readLine(), " ");
    	
    	StringBuilder sb = new StringBuilder();
    	// 두번째 배열의 입력을 key로 사용하여 기존 배열에서 개수를 찾는다.
    	for(int j=0; j<m; j++) {
    		int key = Integer.parseInt(st.nextToken());
    		sb.append(nMap.getOrDefault(key,0)).append(" ");
    	}
    	
    	System.out.println(sb);
    }
}

