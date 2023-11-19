package javaTest.math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 1934번, 최소공배수 
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
public class bj_1934_LeastCommonMultiple {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			
			int gcd = GCD(a,b);
//			System.out.println("gcd : " +gcd);
			
			int lcm = (a*b)/ gcd;
			//System.out.println("lcm : " +lcm);
			sb.append(lcm).append('\n');
		}
		System.out.println(sb);
		
	}
	public static int GCD(int a, int b) {
		if( b == 0) {
			return a;
		}
		int r = a%b;
		return GCD(b, r);
	}

}
