package javaTest.math2;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*
 * 백준 4134번, 다음 소수 
 * n보다 크거나 같은 소수 중 가장 작은 소수 찾는 문제
 * 
 * 10^9 이면 int로는 해결되지 않을 것 같다.
 * 
 * 여러 숫자의 최대 공약수를 구한 후 
 * 최대 공약수만큼 간격을 조정한다.
 * 
 */
public class bj_4134_PrimeNumberChecker {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		//정수들을입력받아 저장할 배열
		long[] numbers = new long[t]; 
		
		//정수 입력 받기
		for(int i=0; i<t; i++) {
			numbers[i] = Long.parseLong(br.readLine()); 
		}
		
		// 출력을 위해 사용
		StringBuilder sb = new StringBuilder();
		
		// 내장 함수를 사용해서 다음 소수를 구한
		for(int i=0; i<numbers.length; i++) {
			BigInteger bigNumer = new BigInteger(String.valueOf(numbers[i]));
			BigInteger result = findPrimeNumber(bigNumer);
			
			sb.append(result.toString()).append('\n');
		}
		
		System.out.println(sb);
	
	}
	
	// isProbablePrime, nextProbablePrime은 BigInteger만 제공된다.
	public static BigInteger findPrimeNumber(BigInteger num) {
		if(num.isProbablePrime(10)) {
			//만약 지금 받은 매개변수가 소수이면 그대로 반환
			return num;
		}else {
			// 소수가 아니면 다음 소수를 반환
			return num.nextProbablePrime(); 
		}
	}

}
