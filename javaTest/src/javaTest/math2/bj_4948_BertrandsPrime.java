package javaTest.math2;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
/*
 * 백준 4949 균형잡힌 세상
 * 중괄호 대괄호 매칭
 * 
 */
public class bj_4948_BertrandsPrime {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받기
		while(true) {
			String input = br.readLine();
			if(input.equals(".")) {
				break;
			}
			// 괄호 비교 함수 호출
			boolean result = isBalanced(input);
			System.out.println(result ? "yes" : "no");
		}

	}
	
	public static boolean isBalanced(String input) {
		// 문자열을 하나씩 비교하기 위해 배열로 변환
		char[] inputArray = input.toCharArray();
		Deque<Character> stack = new ArrayDeque<>();
		// offer : 입력(push)
		// poll : 출력(pop)
		// peek : 값만 확인
		
		for(char ch : inputArray) {
			// stack에 값 입력
			if( (ch == '(') || (ch == '[') ) {
				stack.push(ch);
			// stack에서 값 출력
			}else if( (ch == ')') || (ch == ']') ){
				// stack에 값이 있는지? , 그리고 stack의 값과 입력 값이 매칭이 되는지 확인
				if(stack.isEmpty() || !isMatchingPair(stack.poll(), ch)) {
					return false;
				}
			}
		}
		// stack에 남아있는 값이 없는지 확인
		return stack.isEmpty();
	}
	
	// 입력 값과 stack의 값이 매칭 되는지 확인
	public static boolean isMatchingPair(char opening, char closing) {
		return (opening == '(' && closing == ')') || (opening == '[' && closing == ']');
	}
}
