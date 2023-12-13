package javaTest.stackQueueDeque;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*
 * 백준 28278번, 스택2
 * 정수를 저장하는 스택을 구현 
 * 
 * 1. 정수 x를 스택에 넣는다.
 * 2. 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 출력
 * 3. 스택에 들어있는 정수의 개수를 출력한다.
 * 4. 스택이 비어있으면 1, 아니면 0을 출력한다.
 * 5. 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력
 * 
 * 시간초과 발생 
 * switch 문 비교를 숫자로 변경 -> 시간 초과
 * 
 */
public class bj_28278_stack2 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 스택 사용법 확인하는 문제
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		// 스택 생성
		Stack<Integer> stack = new Stack<Integer>();
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			//String[] command = br.readLine().split(" ");
			st = new StringTokenizer(br.readLine(), " ");
			
			//switch(Integer.parseInt(command[0])) {
			switch(st.nextToken()) {
				case "1":
					int x = Integer.parseInt(st.nextToken());
					stack.push(x);
					break;
				case "2":
					//스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 출력
					if(stack.isEmpty()) {
						//System.out.println(stack.pop());
						sb.append(-1).append('\n');
					}else {
						sb.append(stack.pop()).append('\n');
						//System.out.println(-1);
					}
					break;
				case "3":
					// 스택에 들어있는 정수의 개수를 출력한다.
					sb.append(stack.size()).append('\n');
					//System.out.println(stack.size());
					break;
				case "4":
					//스택이 비어있으면 1, 아니면 0을 출력한다.
					if(stack.isEmpty()) {
						sb.append(1).append('\n');
					}else {
						sb.append(0).append('\n');
					}
					break;
				case "5":
					//스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력
					if(!stack.isEmpty()) {
						sb.append(stack.peek()).append('\n');
					}else {
						sb.append(-1).append('\n');
					}
					break;
				default: break;
			}
		}
		System.out.println(sb);
	}
}
