package javaTest.stackQueueDeque;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*
 * 백준 10773번, 제로
 * 
 * 정수를 입력 받고 0일 경우, 가장 최근에 작성된 수를 삭제한다. pop();
 * 아닐 경우 해당 수를 출력한다. push peek();
 * 
 */
public class bj_4949_balancedWorld {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 스택 생성
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				//수를 입력 받고 0일 경우, 가장 최근에 작성된 수를 삭제한다. pop();
				if(!stack.isEmpty()) {
					stack.pop();
				}
			}else {
				// 아닐 경우 해당 수를 쌓는다.
				stack.push(num);
			}
		}
		
		// 하나씩 꺼내서 합을 구한다.
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}
