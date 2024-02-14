package javaTest.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2912_sum {
	// n개의 정수 수열을 입력 받아 
	// 연속된 몇 개의 수를 선택해서 구할 수 있는 가장 큰 합 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int[] dpOrigin = new int[100001];
		int[] dpUpdate = new int[100001];

		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			dpOrigin[i] = tmp;
			dpUpdate[i] = tmp;
			max = Math.max(max, tmp);
		}
	
		
		// dp 확인
		/*for(int i=0; i<n; i++) {
			System.out.print(dpOrigin[i]+ " " );
		}
		*/
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<(n-i); j++) {
//				System.out.println("\ni : " + i);
//				System.out.println("j : " + j);
				dpUpdate[j] = dpUpdate[j] + dpOrigin[j+i];
				max = Math.max(max, dpUpdate[j]);
//				System.out.println("dpUpdate[j] : " + dpUpdate[j]);
//				System.out.println("max : " + max);
			}
		}
		System.out.println(max);
		
	}
}
