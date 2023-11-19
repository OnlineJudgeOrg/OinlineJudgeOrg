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
		int numerator1 = Integer.parseInt( input1[0] );
		int denominator1 = Integer.parseInt( input1[1] );
		
		String[] input2 = br.readLine().split(" ");
		int numerator2 = Integer.parseInt( input2[0] );
		int denominator2 = Integer.parseInt( input2[1] );
		
//		System.out.println("numerator1 : " + numerator1);
//		System.out.println("numerator2 : " + numerator2);

		numerator1 *= denominator2;
		denominator1 *= denominator2;
		
		numerator2 *= Integer.parseInt( input1[1] );
		denominator2 *= Integer.parseInt( input1[1] );

//		System.out.println("numerator1 : " + numerator1);
//		System.out.println("numerator2 : " + numerator2);
		
		int numerator = numerator1 + numerator2;
		int denominator = denominator1;
//		System.out.println("gcd 전 : " );
//		System.out.println("numerator : " + numerator);
//		System.out.println("denominator : " + denominator);
//		
		int gcd = GCD(numerator, denominator);
//		System.out.println("gcd : " + gcd);
		
		numerator /= gcd; 
		denominator /= gcd;
//		System.out.println("gcd 후 : " );
		System.out.println(numerator + " " + denominator);
		
	}
	
	public static int GCD(int a, int b) {
		
		while(b != 0) {
			int r = a%b;
			a = b;
			b = r;
			
		}
		return a;
	}

}
