package javaTest.math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
 * 백준 4948 베르트랑 공준
 * 범위 내부에 있는 소수의 개수 찾기
 * 에라토스테네스의 체 활용 
 * 1이 아닌 수의 배수는 소수가 아니다. 
 * 
 */
public class bj_4948_BertrandsPrime {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력을 계속 받기 위해 while(true)
		while(true) {
			String input = br.readLine();
			// 종료 조건
			if(input.equals("0")) {
				break;
			}
			
			// 범위 설정 
			int n = Integer.parseInt(input);
			int m = 2 * n;
			
			int result = isPrime(n,m);
			
			System.out.println(result);
		}
	}
	
	public static int isPrime(int start, int end) {
		// 0부터 시작하기 때문에 end 까지 확인하기 위해서는 end+1 배열을 생성해야한다.
		boolean[] numberCheck = new boolean[end +1];
		Arrays.fill(numberCheck, true);
		numberCheck[0] = numberCheck[1] = false;
		
		// 2부터 시작해서 제곱근까지만
		for(int i=2; i*i <= end; i++) {
			if(numberCheck[i]) {
				// 배수인 수를 false 처리
				for(int j=i+i; j<=end; j+=i) {
					numberCheck[j] = false;
				}
			}
		}
		int cnt = 0;
		// n보다 큰 소수를 찾아야 하기 때문에 
		// start 다음 수 부터 찾기 위해 +1을 한다.
		for(int i=start+1; i<=end; i++) {
			if(numberCheck[i]) {
				cnt++;
			}
		}
		return cnt;
	}
}
