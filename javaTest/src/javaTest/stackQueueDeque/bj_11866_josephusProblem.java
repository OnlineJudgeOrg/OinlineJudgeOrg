package javaTest.stackQueueDeque;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
 * 백준 11866_요세푸스 문제 0 
 * 1부터 n까지 반복하며 배수의 boolean 값 변경 
 * 
 * 2초 : 1억 연산 * 2 
 * 128mb 
 * 
 */
public class bj_11866_josephusProblem {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int n = Integer.parseInt(inputs[0]);
		int k = Integer.parseInt(inputs[1]);
		
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=1; i<n+1; i++) {
			deque.addLast(i);
		}
		
		// 출력하기
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		// queue가 남지 않을때까지 반복
		while(deque.size()>1) {
			// k번째 숫자 찾기
			for(int i=0; i<k-1; i++) {
				deque.addLast(deque.pollFirst());
			}
			// k번째 숫자 삭제
			sb.append(deque.poll()).append(", ");
		}
		//출력
		sb.append(deque.poll()).append(">");
		System.out.println(sb);
	}
}
