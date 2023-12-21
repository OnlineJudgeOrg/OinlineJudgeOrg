package javaTest.math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


/*
 * 백준 17103번 골드바흐 파티션
 * 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다. 
 * 짝수 N을 두 소수의 합으로 나타내는 표현할 수 있는 개수
 * 덧셈의 순서만 다른 것은 한개임.
 * 
 * 0.5초
 * 자바 1초 = 1억번 연산 
 * 
 * n = 1,000,000
 * 
 */
public class bj_17103_goldbachPartition {
	// 1. 소수를 구한다. (에라토스테네스의 체)
	// 2. 소수의 합이 가능한 모든 케이스(조합)를 구한다. 
	// 3. 소수의 합과 n 값을 비교하여 같으면 cnt를 증가한다.
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseNum = Integer.parseInt(br.readLine());
		
		
		// 소수 리스트 구하기
		// 시간초과 발생으로 미리 1000000개의 소수를 구한 배열을 반복해서 사용하기
		boolean[] primeList = primeCheck();
		
		while(testCaseNum --> 0) {
			int targetNum = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int j=2; j<=targetNum/2; j++ ) {
				// 두 수가 모두 소수이면
				if(!primeList[j] && !primeList[targetNum-j]) {
					cnt++; //카운트 증가
				}
			}
			System.out.println(cnt);
		}
		
	}
	
	// 소수 리스트 반환하는 함수
	public static boolean[] primeCheck() {
		boolean[] arrCheck = new boolean[1000001]; // boolean 배열은 기본으로 false 초기화
		arrCheck[0] = arrCheck[1] = true; // true : 소수가 아님
		
		for(int i=2; i*i < 1000001; i++) {
			if(!arrCheck[i]) // 소수 판별이 안된 숫자를 판별
				for(int j=i+i; j<1000001; j+=i) {
					arrCheck[j] = true; // 배수는 소수가 아니다.
			}
		}
		return arrCheck;
	}
}
