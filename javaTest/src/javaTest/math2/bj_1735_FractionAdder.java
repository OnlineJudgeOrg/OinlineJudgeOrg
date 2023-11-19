package javaTest.math2;

import java.io.*;


/*
 * 백준 1735번, 분수 합 
 * 
 * 두 개의 분수 합을 구하기 
 * 기약분수로 표현 : 더 이상 약분되지 않는 분수
 * 
 * 분자 분모 순서로 출력
 * 
 */
public class bj_1735_FractionAdder {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input1 = br.readLine().split(" ");
		int A = Integer.parseInt( input1[0] );
		int B = Integer.parseInt( input1[1] );
		
		String[] input2 = br.readLine().split(" ");
		int C = Integer.parseInt( input2[0] );
		int D = Integer.parseInt( input2[1] );
		
		// 분수의 합
		int numerator = (A*D) + (B*C);
		int denominator = B*C;
		
		// 기약분수로 만들기 위해 최대공약수를 구한다.
		int gcd = GCD(numerator, denominator);
		
		// 기약분수로 변경
		numerator /= gcd; 
		denominator /= gcd;
		
		// 결과 출력
		System.out.println(numerator + " " + denominator);
		
	}
	
	// 유클리드 호제법
	public static int GCD(int a, int b) {
		
		// a가 b보다 큰 경우에 대해 코드를 추가해야하나? 
		
		// while(b != 0) {
		// 	int r = a%b;
		// 	a = b;
		// 	b = r;
		// 	
		// }
		if (b == 0) {
			return a;
		}
		return GCD(a, a%b);
	}

}
