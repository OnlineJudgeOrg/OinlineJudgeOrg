package javaTest.stackQueueDeque;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*
 * 백준 9012번, vps
 * 
 * 올바른 괄호인지 아닌지 확인하기
 * '(' 이면 push 
 * ')' 이면 pop 
 * pop이 되지 않으면 ')'더 많음 또는 stack의 개수가 남아있으면 '(' 더 많음 :  NO
 * break; 해줘야한다.
 * 
 * 모든 for문을 돌고 stack에 남아있는 값이 없으면 Yes 
 * 
 * 
 */
public class bj_9012_vps {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 입력 값 받아서 vps 판별 함수 호출하기
		for(int i=0; i<n; i++) {
			String parenthesis = br.readLine();
			boolean result = VPS(parenthesis);
			
			// 결과에 따라 출력으로 YES, NO 선택
			if(result) {
				sb.append("YES").append('\n');
			}else {
				sb.append("NO").append('\n');
			}
		}
		System.out.println(sb);
	}
	
	// 괄호 확인하는 함수
	public static boolean VPS(String parenthesis) {
		Stack<String> stack = new Stack<>();
		
		// 입력값을 배열로 변경
		String[] parenthesisArr = parenthesis.split("");
		boolean result = true;
		for(int i=0; i<parenthesis.length(); i++) {
			String left = parenthesisArr[i];
			if(left.equals("(")){
				// (는 push
				stack.push(left);
			}else {
				// )괄호 짝이 맞으면 pop
				if(stack.size() > 0) {
					stack.pop();
				}else {
					//pop이 되지 않으면 ')'더 많음 
					result = false;
				}
			}
		}
		//stack의 개수가 남아있으면 '(' 더 많음
		if(stack.size()>0) {
			result = false;
		}
		//모든 for문을 돌고 stack에 남아있는 값이 없으면 Yes, 있으면 No
		return result;
	}
		

}
