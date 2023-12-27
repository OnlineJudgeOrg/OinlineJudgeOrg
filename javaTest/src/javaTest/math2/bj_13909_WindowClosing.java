package javaTest.math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


/*
 * 백준 13909_창문 닫기
 * 1부터 n까지 반복하며 배수의 boolean 값 변경 
 * 
 * n = 21억
 * int 범위 
 * 1초 : 1억 연산 
 * 64mb ?? 
 * 
 * 메모리초과
 * 창문은 홀수에 열린다.
 * n의 약수가 홀수개 = 제곱수
 * 
 */
public class bj_13909_WindowClosing {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      
	      // 창문, 사람의 개수 : n
	      int n = Integer.parseInt(br.readLine());
	      
	      // 열려있는 창문의 개수
	      int cnt = 0;
	      for(int i=1; i*i<=n; i++){
	          cnt++;
	      }
	      
	      System.out.println(cnt);
	}
}
