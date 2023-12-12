package javaTest.math2;

import java.io.*;
import java.util.*;
/*
 * 백준 2485번, 가로수 
 * N개의 숫자의 간격을 동일하게 만들기 위해 
 * 추가해야 하는 숫자의 갯수를 구하는 문제
 * 
 * 여러 숫자의 최대 공약수를 구한 후 
 * 최대 공약수만큼 간격을 조정한다.
 * 
 */
public class bj_2485_StreetTrees {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> locations = new ArrayList<>();
		
		// 값 입력 받기
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			locations.add(num);
		}
		
		//정렬하기 
		Collections.sort(locations);
		
		// 가로수의 간격 구하기
		ArrayList<Integer> intervals = new ArrayList<>();
		for(int i=0; i< n-1; i++) {
			intervals.add(locations.get(i+1) - locations.get(i));
		}
		
		// 간격들의 최대공약수 구하기
		
		int gcd = intervals.get(0);
		for(int i=1; i<intervals.size(); i++) {
			int b = intervals.get(i);
			gcd = GCD(gcd, b);
			System.out.println(gcd);
		}
		
		// 추가로 심어야 하는 가로수의 수 구하기
		int result = 0;
		for(int i=0; i<n-1; i++) {
			result += (locations.get(i+1) - locations.get(i)) / gcd-1;
			// 간격 사이에 몇개의 가로수가 생기는지 확인하기 위해서 -1을 해주는 것이다.
			// ex) (4/2) - 1 = 1
			// 간격 / 최대공약수 -1 = 개수
		}
		System.out.println(result);

	}
	public static int GCD(int a, int b) {
		if( b == 0) {
			return a;
		}
		return GCD(b, a%b);
	}

}
