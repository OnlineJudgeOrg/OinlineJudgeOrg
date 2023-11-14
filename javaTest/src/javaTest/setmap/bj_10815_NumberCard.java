package javaTest.setmap;

import java.util.*;
import java.io.*;

/*
 * 10815번 숫자 카드
 * 숫자 N개 배열에 적혀있는 숫자와 M개 배열의 숫자를 비교해
 * 숫자 N이 배열 M에 존재하면 1출력, 아니면 0출력
 * 
 * 시간 제한 : 2초
 * 메모리 제한 : 256 MB
 * 시간초과
 */
public class bj_10815_NumberCard{
    public static void main(String args[]) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt(br.readLine());
    	String[] inputArrN = br.readLine().split(" ");
    	
    	int m = Integer.parseInt(br.readLine());
    	String[] inputArrM = br.readLine().split(" ");
    	
    	// 숫자 배열로 변경
    	int[] inputArrN_int = new int[n];
    	for(int i=0; i<n; i++) {
    		inputArrN_int[i] = Integer.parseInt(inputArrN[i]);
    	}
    	//이분탐색을 하기 위해서는 배열이 정렬되어 있어야한다. 
    	Arrays.sort(inputArrN_int);
    	
    	StringBuilder sb = new StringBuilder();
    	
    	// M의 값이 N에 존재하는지 확인 
    	for(String str : inputArrM) {
    		int target = Integer.parseInt(str);
    		int result = binarySearch(inputArrN_int, target);
    		sb.append(result).append(" ");
    	}
    	System.out.println(sb);
    }
    
    public static int binarySearch(int[] inputArrN_int, int target) {
    	// 이분탐색을 하기 위해 변수 선언 
    	int pivot, left, right;
    	left = 0; // 시작 인덱스
    	right = inputArrN_int.length; // 마지막 인덱스
    	pivot = (left + right) /2 ; //중앙 인덱스
    	
    	while(true) {
    		// 동일한 값을 찾으면 종료
    		if(target == inputArrN_int[pivot]) {
    			return 1;
    		}else if(target > inputArrN_int[pivot]) {
    			// 다음은 pivot ~ right까지 탐색
    			left = pivot+1; 
    			pivot = (left + right)/2;
    		}else if(target < inputArrN_int[pivot]) {
    			// 다음은 left ~ pivot까지 탐색
    			right = pivot;
    			pivot = (left + right)/2;
    		}
    		//존재하지 않는 경우, 종료 조건 
    		if(left >= right) break;
    	}
    	return 0;
    }
}

