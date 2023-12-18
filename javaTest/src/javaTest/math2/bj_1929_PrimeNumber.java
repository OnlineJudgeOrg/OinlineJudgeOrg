package javaTest.math2;

import java.io.*;
import java.util.*;
import java.math.*;


/*
 * 백준 1929 소수 구하기
 * 범위 내부에 있는 소수를 모두 찾기 
 * 에라토스테네스의 체 활용 
 * 1이 아닌 수의 배수는 소수가 아니다. 
 * 
 */
public class bj_1929_PrimeNumber {

	public static void main(String[] args)throws Exception {
		//m 이상 n 이하의 소수를 모두 출력하기
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		String[] mn = br.readLine().split(" ");
		int m = Integer.parseInt(mn[0]);
		int n = Integer.parseInt(mn[1]);
		
		// 소수를 구할 범위 배열 생성하기
		int[] numberArray = new int[n+1];
		
		// 소수 체크할 배열 생성하고 초기화하기
		boolean[] numberArrayCheck = new boolean[n+1];
		Arrays.fill(numberArrayCheck, true);
		numberArrayCheck[0] = numberArrayCheck[1] = false;
		
		// 소수 배열 초기화
		for(int i=0; i<n; i++) {
			numberArray[i] = i;
		}
		
		//에라토스테네스의 체
		for(int i=2; i*i <= n; i++) {
			if (numberArrayCheck[i]) {
				for(int j=i+i; j<= n; j+=i) {
					numberArrayCheck[j] = false;
				}
			}
		}
		
		//출력하기
		StringBuilder sb = new StringBuilder();
		for(int i=m; i<=n; i++) {
			if(numberArrayCheck[i]) {
				sb.append(numberArray[i]).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
