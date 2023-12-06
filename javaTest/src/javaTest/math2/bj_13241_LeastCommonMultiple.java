package javaTest.math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 13241번, 최소공배수 
 * 최대공약수, 최소공배수 문제는 유클리드 알고리즘을 사용 
 * 
 * 최대공약수 :
 * GCD(a,b) = GCD(b,r) >> r = a mod b 이다. 
 * b == 0인 경우, a가 최대공약수이다. 
 * 
 * 최소공배수 :
 * 최소공배수 * 최대공약수 = a * b 
 * 최소공배수 = (a*b) / 최대공약수
 * 
 */
public class bj_13241_LeastCommonMultiple {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// a,b 입력 받기
		String[] inputs = br.readLine().split(" ");
		long a = Integer.parseInt(inputs[0]);
		long b = Integer.parseInt(inputs[1]);
		
		// 최대공약수 구하기
		long gcd = GCD(a,b);
		
		// 최소공배수 = a*b / 최대공약수
		long lcm = (a*b)/gcd;
		System.out.println(lcm);
		
	}
	
	// 최대공약수 while문으로 풀이
	public static long GCD(long a, long b) {
		while( b != 0) {
			long r = a%b ;
			a = b ;
			b = r ;
		}
		return a;
	}

}
